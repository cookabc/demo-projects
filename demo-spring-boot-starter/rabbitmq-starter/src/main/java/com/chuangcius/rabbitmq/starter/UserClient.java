package com.chuangcius.rabbitmq.starter;

/**
 * UserClient
 *
 * @author chuangcius
 * @date 2022.12.13
 */
public interface UserClient {

    /**
     * 发送消息
     *
     * @param message 消息内容
     */
    void sendMessage(String message);
}
