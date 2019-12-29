package com.chris.dfz.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * Create by Chris Chan
 * Create on 2019/12/29 11:52
 * Use for: 自定义注解，组合@Configuration和ComponentScan
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration
@ComponentScan
public @interface MyConfiguration {
    String[] value() default {};//覆盖value参数

    @AliasFor(value = "value", annotation = ComponentScan.class)
    String[] pkgs() default {};//别名映射
}
