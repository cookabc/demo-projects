package com.chuangcius.event.app;

import com.chuangcius.event.starter.Event;
import com.chuangcius.event.starter.EventListener;
import com.chuangcius.event.starter.EventListenerProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * DemoEventListener
 *
 * @author chuangcius
 * @date 2022.12.14
 */
@Slf4j
@Component
@ConditionalOnProperty(value = "event-starter.enabled", havingValue = "true")
public class DemoEventListener extends EventListener {

    public DemoEventListener(EventListenerProperties properties) {
        super(properties);
    }

    @Override
    public String getSubscribedEventType() {
        return "demo";
    }

    @Override
    public void onEvent(Event event) {
        log.info("received event {}", event);
    }
}
