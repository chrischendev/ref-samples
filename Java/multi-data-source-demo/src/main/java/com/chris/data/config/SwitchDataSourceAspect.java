package com.chris.data.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author chrischan
 * create on 2019\7\18 0018 15:58
 * use for:
 */
@Aspect
@Component
@Lazy(false)
@Order(1)
public class SwitchDataSourceAspect {
    @Before("execution(* com.chris.data.*.*(..))")
    public void doBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        if (methodName.startsWith("get")) {
            DataSourceContextHolder.setDbType(DataSourceContextHolder.SELECT_DB);
        } else {
            DataSourceContextHolder.setDbType(DataSourceContextHolder.UPDATE_DB);
        }
    }
}
