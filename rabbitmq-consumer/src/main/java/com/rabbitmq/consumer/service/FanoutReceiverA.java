package com.rabbitmq.consumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @description: 扇形1
 * @author: Huitengxian
 * @time: 2020/9/3 16:45
 */
@Component
public class FanoutReceiverA {

    @RabbitHandler
    @RabbitListener(queues = "fanout.A")
    public void process(Map testMessage) {
        System.out.println("FanoutReceiverA消费者收到消息  : " +testMessage.toString());
    }

}
