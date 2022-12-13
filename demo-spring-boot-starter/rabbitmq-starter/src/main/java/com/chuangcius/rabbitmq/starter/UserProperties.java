package com.chuangcius.rabbitmq.starter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * UserProperties
 *
 * @author chuangcius
 * @date 2022.12.13
 */
@Data
@ConfigurationProperties(prefix = "myrabbit-starter")
public class UserProperties {
    public String rabbitMqExchange;
    public String rabbitMqQueue;
    public String rabbitMqRoutingKey;
}
