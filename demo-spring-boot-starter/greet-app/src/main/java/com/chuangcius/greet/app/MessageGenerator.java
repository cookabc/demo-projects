package com.chuangcius.greet.app;

import com.chuangcius.greet.starter.Greet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * MessageGenerator
 *
 * @author chuangcius
 * @date 2022.12.14
 */
@Slf4j
@Component
class MessageGenerator {

    @Resource
    private Greet greet;

    @Scheduled(fixedRate = 5000)
    void generateMessage() {
        log.info(greet.greet());
    }
}