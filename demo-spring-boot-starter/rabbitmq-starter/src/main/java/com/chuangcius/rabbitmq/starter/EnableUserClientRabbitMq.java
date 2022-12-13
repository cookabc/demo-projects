package com.chuangcius.rabbitmq.starter;

import org.springframework.context.annotation.Import;

/**
 * EnableUserClientRabbitMq
 *
 * @author chuangcius
 * @date 2022.12.13
 */
@Import(UserClientRabbitMqConfig.class)
public @interface EnableUserClientRabbitMq {
}
