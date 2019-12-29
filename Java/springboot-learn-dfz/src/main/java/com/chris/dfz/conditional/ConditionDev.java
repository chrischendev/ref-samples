package com.chris.dfz.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Arrays;

/**
 * Create by Chris Chan
 * Create on 2019/12/29 10:13
 * Use for: 条件1
 */
public class ConditionDev implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return Arrays.asList(context.getEnvironment().getActiveProfiles()).contains("dev");
    }
}
