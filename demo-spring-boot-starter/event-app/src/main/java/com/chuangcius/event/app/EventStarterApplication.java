package com.chuangcius.event.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * EventStarterApplication
 *
 * @author chuangcius
 * @date 2022.12.14
 */
@EnableScheduling
@SpringBootApplication
public class EventStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventStarterApplication.class, args);
    }
}
