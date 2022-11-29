package com.chuangcius.aoplog.convert;

import com.chuangcius.aoplog.bean.OperateLog;
import com.chuangcius.aoplog.bean.SaveOrder;

/**
 * SaveOrderConvert
 *
 * @author chuanciug
 * @date 2022.11.29
 */
public class SaveOrderConvert implements Convert<SaveOrder> {

    @Override
    public OperateLog convert(SaveOrder saveOrder) {
        OperateLog operateLog = new OperateLog();
        operateLog.setOrderId(saveOrder.getId());
        return operateLog;
    }
}
