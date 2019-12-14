package com.chris.base.libs.net;

/**
 * com.alg.ailigouapp.common.net
 * AiligouApp
 * Created by Chris Chen on 2017/6/29 13:44
 * Explain:网络请求返回结果
 */

public class NetResult<ResultType> {
    public int code;//请求结果返回码(0 成功,1 失败)
    public String msg;//请求返回提示信息

    public ResultType data;//请求返回的数据主体
}
