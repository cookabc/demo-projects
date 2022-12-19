package com.chuangcius.event.app;

import com.chuangcius.event.starter.Event;
import com.chuangcius.event.starter.EventPublisher;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * EventGenerator
 *
 * @author chuangcius
 * @date 2022.12.14
 */
@Component
@ConditionalOnProperty(value = "event-starter.enabled", havingValue = "true")
class EventGenerator {

    private final EventPublisher eventPublisher;

    public EventGenerator(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Scheduled(fixedRate = 5000)
    void generateEvent() {
        Event event = new Event("demo", "This is a demo event");
        eventPublisher.publishEvent(event);
    }
}
