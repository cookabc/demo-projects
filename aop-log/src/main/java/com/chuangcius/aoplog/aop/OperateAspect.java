package com.chuangcius.aoplog.aop;

import com.chuangcius.aoplog.annotation.RecordOperate;
import com.chuangcius.aoplog.bean.OperateLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * OperateAspect
 *
 * @author chuanciug
 * @date 2022.11.29
 */
@Aspect
@Component
public class OperateAspect {

    @Pointcut("@annotation(com.chuangcius.aoplog.annotation.RecordOperate)")
    private void pointcut() {
    }

    private final ThreadPoolExecutor executor =
            new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<>(10));

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();
        executor.execute(() -> {
            try {
                MethodSignature signature = (MethodSignature) joinPoint.getSignature();
                RecordOperate annotation = signature.getMethod().getAnnotation(RecordOperate.class);

                OperateLog operateLog = new OperateLog();
                operateLog.setDesc(annotation.desc());
                operateLog.setResult(result.toString());

                System.out.println("insert operate log: " + operateLog.toJSONString());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return result;
    }
}
