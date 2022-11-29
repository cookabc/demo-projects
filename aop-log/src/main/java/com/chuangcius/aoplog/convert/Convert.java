package com.chuangcius.aoplog.convert;

import com.chuangcius.aoplog.bean.OperateLog;
import com.chuangcius.aoplog.bean.Order;

/**
 * Convert
 *
 * @author chuanciug
 * @date 2022.11.29
 */
public interface Convert {
    OperateLog convert(Order order);
}
