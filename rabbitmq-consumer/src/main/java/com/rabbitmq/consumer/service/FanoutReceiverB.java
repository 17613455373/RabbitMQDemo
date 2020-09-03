package com.rabbitmq.consumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @description: 扇形2
 * @author: Huitengxian
 * @time: 2020/9/3 16:45
 */
@Component
public class FanoutReceiverB {

    @RabbitHandler
    @RabbitListener(queues = "fanout.B")
    public void process(Map testMessage) {
        System.out.println("FanoutReceiverB消费者收到消息  : " +testMessage.toString());
    }

}
