package com.rabbitmq.consumer.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @description: 轮询2
 * @author: Huitengxian
 * @time: 2020/9/2 18:09
 */
@Service
public class SecondDirectReceiver {

    @RabbitHandler
    @RabbitListener(queues = "TestDirectQueue")//监听的队列名称 TestDirectQueue
    public void process(Map testMessage) {
        System.out.println("第二个DirectReceiver消费者收到消息  : " + testMessage.toString());
    }

}
