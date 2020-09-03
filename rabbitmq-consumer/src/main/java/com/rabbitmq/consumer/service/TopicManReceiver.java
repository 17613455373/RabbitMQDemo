package com.rabbitmq.consumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @description: 主题1
 * @author: Huitengxian
 * @time: 2020/9/3 16:25
 */
@Component
public class TopicManReceiver {

    @RabbitHandler
    @RabbitListener(queues = "topic.man")
    public void process(Map testMessage) {
        System.out.println("TopicManReceiver消费者收到消息  : " + testMessage.toString());
    }


}
