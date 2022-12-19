package com.chuangcius.event.starter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Collections;
import java.util.List;

/**
 * EventListenerProperties
 *
 * @author chuangcius
 * @date 2022.12.14
 */
@Data
@ConfigurationProperties(prefix = "event-starter")
public class EventListenerProperties {

    private boolean enabled = false;

    private List<String> enabledEvents = Collections.emptyList();
}