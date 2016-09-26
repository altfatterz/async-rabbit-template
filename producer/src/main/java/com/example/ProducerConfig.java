package com.example;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Zoltan Altfatter
 */
@Configuration
public class ProducerConfig {

    static final String FIBO_CALCULATOR_EXCHANGE_NAME = "app.fibonacci.calculator";
    static final String FIBO_CALCULATOR_REQUEST_QUEUE_NAME = "app.fibonacci.request";
    static final String FIBO_CALCULATOR_REPLY_QUEUE_NAME = "app.fibonacci.reply";
    static final String FIBO_CALCULATOR_ROUTING_KEY_NAME = "fibo";

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ConnectionFactory connectionFactory;


    @Bean
    DirectExchange exchange() {
        return new DirectExchange(FIBO_CALCULATOR_EXCHANGE_NAME);
    }

    @Bean
    Queue requestQueue() {
        return QueueBuilder.durable(FIBO_CALCULATOR_REQUEST_QUEUE_NAME).build();
    }

    @Bean
    Queue replyQueue() {
        return QueueBuilder.durable(FIBO_CALCULATOR_REPLY_QUEUE_NAME).build();
    }

    @Bean
    Binding binding() {
        return BindingBuilder.bind(requestQueue()).to(exchange()).with(FIBO_CALCULATOR_ROUTING_KEY_NAME);
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    AsyncRabbitTemplate template() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setQueueNames(FIBO_CALCULATOR_REPLY_QUEUE_NAME);
        return new AsyncRabbitTemplate(rabbitTemplate, container);
    }

}
