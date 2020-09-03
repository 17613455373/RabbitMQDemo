package com.rabbitmq.consumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @description: 扇形3
 * @author: Huitengxian
 * @time: 2020/9/3 16:45
 */
@Component
public class FanoutReceiverC {

    @RabbitHandler
    @RabbitListener(queues = "fanout.C")
    public void process(Map testMessage) {
        System.out.println("FanoutReceiverC消费者收到消息  : " +testMessage.toString());
    }

}
