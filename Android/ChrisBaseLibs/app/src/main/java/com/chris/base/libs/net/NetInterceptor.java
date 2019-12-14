package com.chris.base.libs.net;


import com.chris.base.libs.utils.JsonUtils;
import com.chris.base.libs.utils.RequestUtils;
import com.orhanobut.logger.Logger;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * com.alg.ailigouapp.common.net
 * AiligouApp
 * Created by Chris Chen on 2017/6/29 13:41
 * Explain:网络请求拦截器
 */

public class NetInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        String passWord = "chrischen";//加密解密专用密码
        Request request = chain.request();
        String requestUrl = request.url().url().toString();//请求URL
        RequestBody body = request.body();

        Response response = chain.proceed(request);
        ResponseBody responseBody = response.body();
        String encodeStr = responseBody.string();
        String decodeStr = encodeStr;

        //String decodeStr= CodecUtils.decode(encodeStr,passWord);//解密

        Logger.d("MobileAPI:" + requestUrl + "  返回数据==>" + encodeStr);
        //Logger.d("MobileAPI:" + requestUrl + "  解密数据==>" + deceStr);

        //处理Token过期的问题,RequestUtils可以替换协议中的token
        if (tokenException(decodeStr)) {
            responseBody.close();
            return replaceTokenResponse(chain, request);
        }
        return response.newBuilder()
                .body(responseBody.create(responseBody.contentType(), decodeStr))
                .build();
    }

    /**
     * 替换token后的Response
     *
     * @param chain
     * @param request
     * @return
     * @throws IOException
     */
    private Response replaceTokenResponse(Chain chain, Request request) throws IOException {
        String newToken = getToken();
        RequestBody token = RequestUtils.replaceToken(request.body(), newToken);
        return chain.proceed(request.newBuilder().method(request.method(), token).build());
    }

    /**
     * 判断是否被告知Token过期
     *
     * @param decodeStr
     * @return
     */
    private boolean tokenException(String decodeStr) {
        NetResult netResult = JsonUtils.jsonToObj(decodeStr, NetResult.class);
        return netResult != null && netResult.code == 999;
    }

    public String getToken() throws IOException {
        /*
        UserService service = NetClient.getRetrofit(USER_BASE_URL).create(UserService.class);
        Map<String, Object> map = new HashMap<>();
        map.put("phoneNumber", "13303860132");
        map.put("password", 123456);
        NetRequest requestBody = new NetRequest();
        requestBody.params = map;
        NetProtocol protocol = new NetProtocol();

        protocol.os = "android";
        protocol.ver = "1.0";
        protocol.channel = 1;
        protocol.token = null;
        protocol.lng = 1;
        protocol.lat = 1;
        requestBody.protocol = protocol;
        Call call = service.login(RequestBody.create(MediaType.parse("application/json"), objToJson(requestBody)));
        NetResult body = (NetResult) call.execute().body();
        return body.code + "123123";
        */
        return null;
    }
}
