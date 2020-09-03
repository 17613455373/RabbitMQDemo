package com.rabbitmq.consumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @description: 主题2
 * @author: Huitengxian
 * @time: 2020/9/3 16:25
 */
@Component
public class TopicTotalReceiver {

    @RabbitHandler
    @RabbitListener(queues = "topic.woman")
    public void process(Map testMessage) {
        System.out.println("TopicTotalReceiver消费者收到消息  : " + testMessage.toString());
    }


}
