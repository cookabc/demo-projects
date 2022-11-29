package com.chuangcius.aoplog.service;

import com.chuangcius.aoplog.annotation.RecordOperate;
import com.chuangcius.aoplog.bean.SaveOrder;
import com.chuangcius.aoplog.bean.UpdateOrder;
import org.springframework.stereotype.Service;

/**
 * OrderService
 *
 * @author chuanciug
 * @date 2022.11.29
 */
@Service
public class OrderService {

    @RecordOperate(desc = "Save Order")
    public Boolean saveOrder(SaveOrder saveOrder) {
        System.out.println("save order, orderId: " + saveOrder.getId());
        return true;
    }

    @RecordOperate(desc = "Update Order")
    public Boolean updateOrder(UpdateOrder updateOrder) {
        System.out.println("update order, orderId: " + updateOrder.getOrderId());
        return true;
    }
}
