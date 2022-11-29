package com.chuangcius.aoplog.convert;

import com.chuangcius.aoplog.bean.OperateLog;
import com.chuangcius.aoplog.bean.Order;
import com.chuangcius.aoplog.bean.UpdateOrder;

/**
 * UpdateOrderConvert
 *
 * @author chuanciug
 * @date 2022.11.29
 */
public class UpdateOrderConvert implements Convert {

    @Override
    public OperateLog convert(Order order) {
        OperateLog operateLog = new OperateLog();
        operateLog.setOrderId(((UpdateOrder) order).getOrderId());
        return operateLog;
    }
}
