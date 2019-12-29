package com.chris.car.config;

import java.lang.annotation.*;

/**
 * Create by Chris Chan
 * Create on 2019/12/30 2:24
 * Use for:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface IgnoreAdvice {
}
