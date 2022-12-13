package com.chuangcius.rabbitmq.starter;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

import static java.util.Collections.emptyMap;

/**
 * UserClientRabbitMqConfig
 *
 * @author chuangcius
 * @date 2022.12.13
 */
@EnableRabbit
@Configuration
@EnableConfigurationProperties(UserProperties.class)
public class UserClientRabbitMqConfig {

    @Resource
    private UserProperties userProperties;

    @Bean
    Exchange userExchange() {
        return new DirectExchange(userProperties.rabbitMqExchange, true, false);
    }

    @Bean
    Queue userQueue() {
        return new Queue(userProperties.rabbitMqQueue, true, false, false);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate userRabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

    @Bean
    Binding userBinding() {
        return new Binding(
                userProperties.rabbitMqQueue,
                Binding.DestinationType.QUEUE,
                userProperties.rabbitMqExchange,
                userProperties.rabbitMqRoutingKey,
                emptyMap()
        );
    }

    @Bean
    UserClient rabbitMqUserClient() {
        return new RabbitMqUserClient();
    }
}

