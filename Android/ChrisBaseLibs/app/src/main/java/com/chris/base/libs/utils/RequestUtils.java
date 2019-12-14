package com.chris.base.libs.utils;

import com.chris.base.libs.net.NetRequest;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;

public class RequestUtils {

    /**
     * 替换RequestBody中NetRequest自定义协议内的Token
     *
     * @param body
     * @param newToken
     * @return
     */
    public static RequestBody replaceToken(RequestBody body, String newToken) {
        NetRequest requestBody = getRequestBody(body);
        requestBody.protocol.token = newToken;
        return RequestBody.create(body.contentType(), JsonUtils.objToJson(requestBody));
    }

    /**
     * 获得NetRequest类型的requestBody，便于取出其中的协议信息
     *
     * @param body
     * @return
     */
    public static NetRequest getRequestBody(RequestBody body) {
        return JsonUtils.jsonToObj(getRequestBodyJson(body), NetRequest.class);
    }

    /**
     * 获得request中body的json字符串，便于打印
     *
     * @param body
     * @return
     * @throws IOException
     */
    public static String getRequestBodyJson(RequestBody body) {
        Buffer buffer = new Buffer();
        try {
            body.writeTo(buffer);
            Charset charset = Charset.forName("UTF-8");
            MediaType mediaType = body.contentType();
            if (mediaType != null) {
                charset = mediaType.charset(StandardCharsets.UTF_8);
            }
            return buffer.readString(charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}