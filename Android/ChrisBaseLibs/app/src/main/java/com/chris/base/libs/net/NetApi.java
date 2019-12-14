package com.chris.base.libs.net;

import com.chris.base.libs.utils.JsonUtils;
import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * com.alg.ailigouapp.common.net
 * AiligouApp
 * Created by Chris Chen on 2017/6/29 13:29
 * Explain:
 */

public class NetApi {
    /**
     * 生成post请求数据
     *
     * @param map
     * @return
     */
    public static RequestBody postRequestBody(Map<String, Object> map) {
        NetRequest requestBody = getRequestBody();
        requestBody.params = map;
        //Logger.d("请求的JSON===>" + JsonUtils.objToJson(requestBody));
        return RequestBody.create(MediaType.parse("application/json"), JsonUtils.objToJson(requestBody));
    }

    /**
     * 生成
     *
     * @param map
     * @return
     */
    public static Map<String, Object> requestMap(Map<String, Object> map) {
        Map<String, Object> hMap = new HashMap<>();
        hMap.put("protocol", getRequestMap());
        hMap.put("params", map);

//        Map<String, Object> hMap = getRequestMap();
//        hMap.putAll(map);
        Logger.d("请求的JSON===>" + JsonUtils.objToJson(hMap));
        return hMap;
    }

    /**
     * 初始化一个RequestBody数据，具体有实时数据变化的，不能用这种方式。这只是在协议头数据基本没有变化的情况下使用
     *
     * @return
     */
    private static NetRequest getRequestBody() {
        NetRequest requestBody = new NetRequest();
        NetProtocol protocol = new NetProtocol();

        protocol.os = "android";
        protocol.ver = "1.0";
        protocol.channel = 1;
        protocol.token = "ZTAwNjIyOGQtZmU1Zi00NmNiLWJjNTgtMTY1MmE4OTI4OTkw";
        protocol.lng = 1;
        protocol.lat = 1;

        requestBody.protocol = protocol;
        return requestBody;
    }

    /**
     * 获得网络请求头的map数据
     *
     * @return
     */
    private static Map<String, Object> getRequestMap() {
        Map<String, Object> map = new HashMap<>();

//        map.put("requestId",1);
        map.put("os", "android");
        map.put("ver", "1.0");
        map.put("channel", 1);
        map.put("token", "ZTAwNjIyOGQtZmU1Zi00NmNiLWJjNTgtMTY1MmE4OTI4OTkw");
        map.put("lng", 1);
        map.put("lat", 1);
//        map.put("signType","1");
//        map.put("sign","sagshafhuiqwhuhqiow");

        return map;
    }
}
