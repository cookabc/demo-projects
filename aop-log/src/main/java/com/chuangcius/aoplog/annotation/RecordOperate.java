package com.chuangcius.aoplog.annotation;

import java.lang.annotation.*;

/**
 * RecordOperate
 *
 * @author chuanciug
 * @date 2022.11.29
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RecordOperate {

    String desc() default "";
}
