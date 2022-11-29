package com.chuangcius.aoplog;

import com.chuangcius.aoplog.bean.SaveOrder;
import com.chuangcius.aoplog.bean.UpdateOrder;
import com.chuangcius.aoplog.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopLogApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AopLogApplication.class, args);
    }

    @Resource
    private OrderService orderService;

    @Override
    public void run(String... args) {
        SaveOrder saveOrder = new SaveOrder();
        saveOrder.setId(1L);
        orderService.saveOrder(saveOrder);

        UpdateOrder updateOrder = new UpdateOrder();
        updateOrder.setOrderId(2L);
        orderService.updateOrder(updateOrder);
    }
}
