package com.chuangcius.aoplog.service;

import com.chuangcius.aoplog.annotation.RecordOperate;
import com.chuangcius.aoplog.bean.SaveOrder;
import com.chuangcius.aoplog.bean.UpdateOrder;
import com.chuangcius.aoplog.convert.SaveOrderConvert;
import com.chuangcius.aoplog.convert.UpdateOrderConvert;
import org.springframework.stereotype.Service;

/**
 * OrderService
 *
 * @author chuanciug
 * @date 2022.11.29
 */
@Service
public class OrderService {

    @RecordOperate(desc = "Save Order", convert = SaveOrderConvert.class)
    public Boolean saveOrder(SaveOrder saveOrder) {
        System.out.println("save order, orderId: " + saveOrder.getId());
        return true;
    }

    @RecordOperate(desc = "Update Order", convert = UpdateOrderConvert.class)
    public Boolean updateOrder(UpdateOrder updateOrder) {
        System.out.println("update order, orderId: " + updateOrder.getOrderId());
        return true;
    }
}
