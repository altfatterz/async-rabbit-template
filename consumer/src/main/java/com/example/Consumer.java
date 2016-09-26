package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author Zoltan Altfatter
 */

@Component
@Slf4j
public class Consumer {

    @RabbitListener(queues = ConsumerConfig.FIBO_CALCULATOR_REQUEST_QUEUE_NAME)
    public FiboCalcResponse process(@Payload FiboCalcRequest request) {
        log.info("Received '{}'", request.getNumber());
        return new FiboCalcResponse(request.getNumber(), fibo(request.getNumber()));
    }

    static long fibo(int n) {
         if (n <= 1) return n;
        else return fibo(n-1) + fibo(n-2);
    }

}
