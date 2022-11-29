package com.chuangcius.aoplog.bean;

/**
 * OperateLog
 *
 * @author chuanciug
 * @date 2022.11.29
 */
public class OperateLog {

    private Long orderId;
    private String desc;
    private String result;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String toJSONString() {
        return """
                {
                    "orderId": %s,
                    "desc": %s,
                    "result": %s,
                }""".formatted(orderId, desc, result);
    }
}
