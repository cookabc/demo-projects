package com.chuangcius.event.starter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * EventPublisher
 *
 * @author chuangcius
 * @date 2022.12.14
 */
@Slf4j
@RequiredArgsConstructor
public class EventPublisher {

    private final List<EventListener> listeners;

    public void publishEvent(Event event) {
        log.info("publishing event: {}", event);
        for (EventListener listener : listeners) {
            listener.receive(event);
        }
    }
}
