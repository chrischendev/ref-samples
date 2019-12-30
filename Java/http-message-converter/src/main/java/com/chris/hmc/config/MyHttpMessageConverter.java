package com.chris.hmc.config;

import com.chris.hmc.model.NetResult;
import com.chris.hmc.model.UserModel;
import com.google.gson.Gson;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * Create by Chris Chan
 * Create on 2019/12/31 4:53
 * Use for: 自定义HttpMessageConverter
 */
@Component
public class MyHttpMessageConverter extends AbstractHttpMessageConverter<Object> {

    /**
     * 新建媒体类型application/x-chris
     */
    public MyHttpMessageConverter() {
        //super(new MediaType("application", "x-chris", StandardCharsets.UTF_8));
        super(MediaType.APPLICATION_JSON);
    }

    /**
     * 只处理UserModel数据类型
     *
     * @param clazz
     * @return
     */
    @Override
    protected boolean supports(Class<?> clazz) {
        return !NetResult.class.isAssignableFrom(clazz);
    }

    /**
     * 这个是处理请求参数的
     * 为什么没有被执行？是不是因为媒体类型不对路？待测试
     *
     * @param clazz
     * @param inputMessage
     * @return
     * @throws IOException
     * @throws HttpMessageNotReadableException
     */
    @Override
    protected Object readInternal(Class<? extends Object> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        System.out.println("来了~~~~~~");
        System.out.println(inputMessage.getHeaders().getContentType().getType());
        InputStream body = inputMessage.getBody();
        String bodyStr = StreamUtils.copyToString(body, StandardCharsets.UTF_8);
        System.out.println(bodyStr);
        return null;
    }

    /**
     * 修改响应数据
     *
     * @param obj
     * @param outputMessage
     * @throws IOException
     * @throws HttpMessageNotWritableException
     */
    @Override
    protected void writeInternal(Object obj, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        NetResult netResult = NetResult.create(0, "successed", obj);
        outputMessage.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        outputMessage.getBody().write(new Gson().toJson(netResult).getBytes());
    }


}
