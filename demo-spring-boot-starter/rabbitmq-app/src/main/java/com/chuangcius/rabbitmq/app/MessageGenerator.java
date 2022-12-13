package com.chuangcius.rabbitmq.app;

import com.chuangcius.rabbitmq.starter.UserClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * MessageGenerator
 *
 * @author chuangcius
 * @date 2022.12.13
 */
@Component
class MessageGenerator {

    private final UserClient userClient;

    public MessageGenerator(UserClient userClient) {
        this.userClient = userClient;
    }

    @Scheduled(fixedRate = 5000)
    void generateMessage() {
        userClient.sendMessage("This is a demo message");
    }
}
