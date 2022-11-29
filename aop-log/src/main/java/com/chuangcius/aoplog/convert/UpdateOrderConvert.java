package com.chuangcius.aoplog.convert;

import com.chuangcius.aoplog.bean.OperateLog;
import com.chuangcius.aoplog.bean.UpdateOrder;

/**
 * UpdateOrderConvert
 *
 * @author chuanciug
 * @date 2022.11.29
 */
public class UpdateOrderConvert implements Convert<UpdateOrder> {

    @Override
    public OperateLog convert(UpdateOrder updateOrder) {
        OperateLog operateLog = new OperateLog();
        operateLog.setOrderId(updateOrder.getOrderId());
        return operateLog;
    }
}
