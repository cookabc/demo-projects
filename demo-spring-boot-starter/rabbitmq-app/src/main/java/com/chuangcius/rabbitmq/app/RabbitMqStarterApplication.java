package com.chuangcius.rabbitmq.app;

import com.chuangcius.rabbitmq.starter.EnableUserClientRabbitMq;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * RabbitMqStarterApplication
 *
 * @author chuangcius
 * @date 2022.12.13
 */
@EnableUserClientRabbitMq
@EnableScheduling
@SpringBootApplication
public class RabbitMqStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitMqStarterApplication.class, args);
    }
}
