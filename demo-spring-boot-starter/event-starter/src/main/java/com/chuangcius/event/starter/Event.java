package com.chuangcius.event.starter;

import lombok.ToString;
import lombok.Value;

/**
 * Event
 *
 * @author chuangcius
 * @date 2022.12.14
 */
@Value
@ToString
public class Event {
    String type;
    String payload;
}
