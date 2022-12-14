package com.chuangcius.event.starter;

import lombok.RequiredArgsConstructor;

/**
 * EventListener
 *
 * @author xugang.song
 * @date 2022.12.14
 */
@RequiredArgsConstructor
public abstract class EventListener {

    private final EventListenerProperties properties;

    public void receive(Event event) {
        if (isEnabled(event) && isSubscribed(event)) {
            onEvent(event);
        }
    }

    private boolean isSubscribed(Event event) {
        return event.getType().equals(getSubscribedEventType());
    }

    private boolean isEnabled(Event event) {
        return properties.getEnabledEvents().contains(event.getType());
    }

    protected abstract String getSubscribedEventType();

    protected abstract void onEvent(Event event);
}
