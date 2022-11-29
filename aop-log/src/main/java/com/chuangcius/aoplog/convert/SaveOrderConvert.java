package com.chuangcius.aoplog.convert;

import com.chuangcius.aoplog.bean.OperateLog;
import com.chuangcius.aoplog.bean.Order;
import com.chuangcius.aoplog.bean.SaveOrder;

/**
 * SaveOrderConvert
 *
 * @author chuanciug
 * @date 2022.11.29
 */
public class SaveOrderConvert implements Convert {

    @Override
    public OperateLog convert(Order order) {
        OperateLog operateLog = new OperateLog();
        operateLog.setOrderId(((SaveOrder) order).getId());
        return operateLog;
    }
}
