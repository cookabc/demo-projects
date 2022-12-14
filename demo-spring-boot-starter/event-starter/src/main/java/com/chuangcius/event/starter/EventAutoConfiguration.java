package com.chuangcius.event.starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * EventAutoConfiguration
 *
 * @author xugang.song
 * @date 2022.12.14
 */
@Configuration
@EnableConfigurationProperties(EventListenerProperties.class)
@ConditionalOnProperty(value = "event-starter.enabled", havingValue = "true")
public class EventAutoConfiguration {

    @Bean
    EventPublisher eventPublisher(List<EventListener> listeners) {
        return new EventPublisher(listeners);
    }
}
