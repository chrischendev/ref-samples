package com.chris.base.libs.net;

/**
 * com.alg.ailigouapp.common.net
 * AiligouApp
 * Created by Chris Chen on 2017/6/29 13:49
 * Explain:网络请求协议头部信息
 */

public class NetRequestHeader {
    public int requestId;//请求id
    public String os;//操作系统
    public String ver;//协议版本
    public int channel;//渠道号
    public String token;//用户令牌
    public double lng;//经度
    public double lat;//纬度
    public String signType;//签名类型
    public String sign;//签名
}
