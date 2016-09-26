package com.example;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Zoltan Altfatter
 */
@Configuration
public class ConsumerConfig {

    static final String FIBO_CALCULATOR_REQUEST_QUEUE_NAME = "app.fibonacci.request";

    @Bean
    Queue requestQueue() {
        return QueueBuilder.durable(FIBO_CALCULATOR_REQUEST_QUEUE_NAME ).build();
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
