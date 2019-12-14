package com.chris.web.config;

import com.api.enhance.aspect.ApiEnhanceAspect;
import com.api.enhance.exception.ContinRequestException;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Create by Chris Chan
 * Create on 2019/4/1 16:04
 * Use for:
 */
@Aspect
@Order(-1000)
@Component
public class TimeLimitAspect extends ApiEnhanceAspect {
    @Override
    protected void handleTimeLimitException(ContinRequestException e) {
        throw new RuntimeException("time too short: " + e.getTime() + "<" + e.getTimeLimit());
    }
}
