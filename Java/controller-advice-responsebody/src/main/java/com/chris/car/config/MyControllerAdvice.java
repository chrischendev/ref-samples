package com.chris.car.config;

import com.chris.car.model.NetResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Method;

/**
 * Create by Chris Chan
 * Create on 2019/12/30 2:22
 * Use for:
 */
@ControllerAdvice
public class MyControllerAdvice implements ResponseBodyAdvice<Object> {
    /**
     * 注意判断条件的优先顺序
     * 如果大多数需要处理，或者大多数不需要处理，则应设计一个适应于更少需求的注解来判断
     *
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        Method method = methodParameter.getMethod();
        //1. 包含IncludeHeader注解不处理
        if (null != method.getDeclaredAnnotation(IgnoreAdvice.class)) {
            return false;
        }

        //2. 只对GetMapping和PostMapping接口做此处理
        if (null != method.getDeclaredAnnotation(GetMapping.class) ||
                null != method.getDeclaredAnnotation(PostMapping.class)) {
            return true;
        }

        return false;
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //已经被包裹的数据不再包裹
        if (data instanceof NetResult) {
            return data;
        }
        return NetResult.create(0, "success", data);
    }
}
