package com.chuangcius.rabbitmq.starter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;

import javax.annotation.Resource;

/**
 * RabbitMqUserClient
 *
 * @author chuangcius
 * @date 2022.12.13
 */
@Slf4j
public class RabbitMqUserClient implements UserClient {

    @Resource
    private AmqpTemplate userRabbitTemplate;

    @Resource
    private UserProperties userProperties;

    @Override
    public void sendMessage(String message) {
        userRabbitTemplate.convertAndSend(userProperties.rabbitMqExchange, userProperties.rabbitMqRoutingKey, message);
        log.info("Sending message: {}", message);
    }
}
