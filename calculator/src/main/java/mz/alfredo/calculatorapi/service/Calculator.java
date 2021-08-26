package mz.alfredo.calculatorapi.service;

import mz.alfredo.calculatorapi.model.OperationType;
import mz.alfredo.calculatorapi.model.RequestInput;
import mz.alfredo.calculatorapi.model.RequestOutput;
import mz.alfredo.calculatorapi.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class Calculator {
    private static final Logger LOGGER = LoggerFactory.getLogger(Calculator.class);

    /**
     * Function that listens to the RabbitMQ Message queue and performs the operation launched by REST api
     * @param requestInput Request input from REST
     * @return Request Output
     */
    @RabbitListener(queues = Constants.QUEUE)
    public RequestOutput getRequestFromQueue(RequestInput requestInput) {
        LOGGER.info("getRequestFromQueue() Method started");
        RequestOutput requestOutput = new RequestOutput(this.calculate(requestInput));
        LOGGER.info("getRequestFromQueue() Method requestOutput: "+requestOutput);
        LOGGER.info("getRequestFromQueue() Method finished");
        return requestOutput;
    }

    /**
     * Function that calculate REST input
     * @param requestInput Request input from REST
     * @return Calculation result
     */
    private BigDecimal calculate(RequestInput requestInput) {
        switch (requestInput.getOperationType()){
            case "+": return  requestInput.getA().add(requestInput.getB());
            case "-": return  requestInput.getA().subtract(requestInput.getB());
            case "x": return  requestInput.getA().multiply(requestInput.getB());
            case "/": return  requestInput.getA().divide(requestInput.getB(), 2, RoundingMode.HALF_UP).stripTrailingZeros();
        }
        return new BigDecimal(0);
    }

}
