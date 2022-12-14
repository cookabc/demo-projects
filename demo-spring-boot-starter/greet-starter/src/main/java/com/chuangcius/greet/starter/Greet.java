package com.chuangcius.greet.starter;

/**
 * Greet
 *
 * @author chuangcius
 * @date 2022.12.14
 */
public class Greet {

    private final GreetConfig greetConfig;

    public Greet(GreetConfig greetConfig) {
        this.greetConfig = greetConfig;
    }

    public String greet() {
        String name = greetConfig.getProperty("username");
        return String.format("Hello %s, %s", name, greetConfig.get("message"));
    }
}
