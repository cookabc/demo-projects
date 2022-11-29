package com.chuangcius.aoplog.convert;

import com.chuangcius.aoplog.bean.OperateLog;

/**
 * Convert
 *
 * @author chuanciug
 * @date 2022.11.29
 */
public interface Convert<T> {
    OperateLog convert(T t);
}
