package com.chuangcius.greet.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * GreetStarterApplication
 *
 * @author chuangcius
 * @date 2022.12.14
 */
@EnableScheduling
@SpringBootApplication
public class GreetStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreetStarterApplication.class, args);
    }
}
