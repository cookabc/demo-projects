package com.chuangcius.greet.starter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * GreetAutoConfiguration
 *
 * @author chuangcius
 * @date 2022.12.14
 */
@Configuration
@ConditionalOnClass(Greet.class)
@EnableConfigurationProperties(GreetProperties.class)
public class GreetAutoConfiguration {

    @Resource
    private GreetProperties greetProperties;

    @Bean
    @ConditionalOnMissingBean
    public GreetConfig greetConfig() {

        String userName = greetProperties.getUsername() == null
                ? System.getProperty("username")
                : greetProperties.getUsername();
        String message = greetProperties.getMessage() == null
                ? System.getProperty("message")
                : greetProperties.getMessage();

        GreetConfig greetConfig = new GreetConfig();
        greetConfig.put("username", userName);
        greetConfig.put("message", message);

        return greetConfig;
    }

    @Bean
    @ConditionalOnMissingBean
    public Greet greet(GreetConfig greetConfig) {
        return new Greet(greetConfig);
    }
}
