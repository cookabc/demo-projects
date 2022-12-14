package com.chuangcius.greet.starter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * GreetProperties
 *
 * @author chuangcius
 * @date 2022.12.14
 */
@Data
@ConfigurationProperties(prefix = "greet-starter")
public class GreetProperties {
    private String username;
    private String message;
}
