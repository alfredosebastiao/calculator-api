package mz.alfredo.calculatorapi.utils;

import org.springframework.context.annotation.Configuration;

/**
 * Class used to set all constants used on the module
 * @author alfredosebastiao
 */
@Configuration
public class Constants {

    public static final String QUEUE = "calculator_queue";
    public static final String DIRECT_EXCHANGE = "calculator_direct_exchange";
    public static final String ROUTING_KEY = "calculator_routingKey";
}
