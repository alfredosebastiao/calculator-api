package mz.alfredo.calculatorapi.service;

import mz.alfredo.calculatorapi.model.OperationType;
import mz.alfredo.calculatorapi.model.RequestInput;
import mz.alfredo.calculatorapi.model.RequestOutput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


import java.math.BigDecimal;

@SpringBootTest(classes={mz.alfredo.calculatorapi.service.Calculator.class})
@AutoConfigureMockMvc
@ContextConfiguration
public class CalculatorTests {

    @Test
    public void shouldReturnSumOfNumbers(){
        RequestInput requestInput = new RequestInput("test", BigDecimal.valueOf(10), BigDecimal.valueOf(10), OperationType.SUM.getOperation());
        Calculator calculator = new Calculator();
        RequestOutput calculatorOutput = calculator.getRequestFromQueue(requestInput);
        RequestOutput expectedOutPut = new RequestOutput(BigDecimal.valueOf(20));
        Assertions.assertEquals(expectedOutPut.getResult(),calculatorOutput.getResult());
    }

    @Test
    public void shouldReturnSubtractionOfNumbers(){
        RequestInput requestInput = new RequestInput("test", BigDecimal.valueOf(10), BigDecimal.valueOf(10), OperationType.SUBTRACTION.getOperation());
        Calculator calculator = new Calculator();
        RequestOutput calculatorOutput = calculator.getRequestFromQueue(requestInput);
        RequestOutput expectedOutPut = new RequestOutput(BigDecimal.valueOf(0));
        Assertions.assertEquals(expectedOutPut.getResult(),calculatorOutput.getResult());
    }

    @Test
    public void shouldReturnMultiplicationOfNumbers(){
        RequestInput requestInput = new RequestInput("test", BigDecimal.valueOf(10), BigDecimal.valueOf(10), OperationType.MULTIPLICATION.getOperation());
        Calculator calculator = new Calculator();
        RequestOutput calculatorOutput = calculator.getRequestFromQueue(requestInput);
        RequestOutput expectedOutPut = new RequestOutput(BigDecimal.valueOf(100));
        Assertions.assertEquals(expectedOutPut.getResult(),calculatorOutput.getResult());
    }

    @Test
    public void shouldReturnDivisionOfNumbers(){
        RequestInput requestInput = new RequestInput("test", BigDecimal.valueOf(10), BigDecimal.valueOf(10), OperationType.DIVIDE.getOperation());
        Calculator calculator = new Calculator();
        RequestOutput calculatorOutput = calculator.getRequestFromQueue(requestInput);
        RequestOutput expectedOutPut = new RequestOutput(BigDecimal.valueOf(1));
        Assertions.assertEquals(expectedOutPut.getResult(),calculatorOutput.getResult());
    }


}
