package mz.alfredo.calculatorapi.controller;

import mz.alfredo.calculatorapi.filter.UniqueRequestIdFilter;
import mz.alfredo.calculatorapi.model.OperationType;
import mz.alfredo.calculatorapi.model.RequestInput;
import mz.alfredo.calculatorapi.model.RequestOutput;
import mz.alfredo.calculatorapi.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;

@Controller
@EnableAutoConfiguration
@RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
public class CalculatorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorController.class);

    @Autowired
    private RabbitTemplate template;

    @GetMapping(value = "/sum")
    @ResponseBody
    public ResponseEntity<Object> sum(@RequestParam(value = "a") BigDecimal a, @RequestParam(value = "b") BigDecimal b) {

        try {
            LOGGER.info("/sum Method started");
            RequestInput requestInput = new RequestInput(MDC.get(UniqueRequestIdFilter.getMdcKey()), a,b, OperationType.SUM.getOperation());
            RequestOutput requestOutput = (RequestOutput) template.convertSendAndReceive(Constants.DIRECT_EXCHANGE, Constants.ROUTING_KEY, requestInput);
            LOGGER.info("/sum Method finished");
            return new ResponseEntity<>(requestOutput,new HttpHeaders(), HttpStatus.OK);
        }catch (Exception exception){
            LOGGER.error("Error on /sum Method",exception);
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(value = "/subtract")
    @ResponseBody
    public ResponseEntity<Object> subtract(@RequestParam(value = "a") BigDecimal a, @RequestParam(value = "b") BigDecimal b) {
        try {
            LOGGER.info("/subtract Method started");
            RequestInput requestInput = new RequestInput(MDC.get(UniqueRequestIdFilter.getMdcKey()), a,b, OperationType.SUBTRACTION.getOperation());
            RequestOutput requestOutput = (RequestOutput) template.convertSendAndReceive(Constants.DIRECT_EXCHANGE, Constants.ROUTING_KEY, requestInput);
            LOGGER.info("/subtract Method finished");
            return new ResponseEntity<>(requestOutput,new HttpHeaders(), HttpStatus.OK);
        }catch (Exception exception){
            LOGGER.error("Error on /subtract Method",exception);
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/multiply")
    @ResponseBody
    public ResponseEntity<Object> multiply(@RequestParam(value = "a") BigDecimal a, @RequestParam(value = "b") BigDecimal b) {

        try {
            LOGGER.info("/multiply Method started");
            RequestInput requestInput = new RequestInput(MDC.get(UniqueRequestIdFilter.getMdcKey()), a,b, OperationType.MULTIPLICATION.getOperation());
            RequestOutput requestOutput = (RequestOutput) template.convertSendAndReceive(Constants.DIRECT_EXCHANGE, Constants.ROUTING_KEY, requestInput);
            LOGGER.info("/multiply Method finished");
            return new ResponseEntity<>(requestOutput,new HttpHeaders(), HttpStatus.OK);
        }catch (Exception exception){
            LOGGER.error("Error on /multiply Method",exception);
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(value = "/divide")
    @ResponseBody
    public ResponseEntity<Object> divide(@RequestParam(value = "a") BigDecimal a, @RequestParam(value = "b") BigDecimal b) {

        try {
            LOGGER.info("/divide Method started");
            if(!b.equals(BigDecimal.ZERO)){
                RequestInput requestInput = new RequestInput(MDC.get(UniqueRequestIdFilter.getMdcKey()), a,b, OperationType.DIVIDE.getOperation());
                RequestOutput requestOutput = (RequestOutput) template.convertSendAndReceive(Constants.DIRECT_EXCHANGE, Constants.ROUTING_KEY, requestInput);
                LOGGER.info("/divide Method finished");
                return new ResponseEntity<>(requestOutput,new HttpHeaders(), HttpStatus.OK);
            }else {
                LOGGER.info("/divide Method: b is  BigDecimal.ZERO");
                LOGGER.info("/divide Method finished");
                return new ResponseEntity<>(a+ " can't be divided by "+b,new HttpHeaders(), HttpStatus.NOT_ACCEPTABLE);
            }

        }catch (Exception exception){
            LOGGER.error("Error on /divide Method",exception);
            return new ResponseEntity<>(new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
