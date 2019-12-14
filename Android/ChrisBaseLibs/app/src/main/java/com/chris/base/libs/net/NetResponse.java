package com.chris.base.libs.net;

import retrofit2.Call;

/**
 * com.alg.ailigouapp.common.net
 * AiligouApp
 * Created by Chris Chen on 2017/6/29 16:17
 * Explain:网络请求返回数据体
 */

public class NetResponse<ResultType> {
    public Call call;
    public boolean isSuccess;//是否请求成功
    public int state;//状态码
    public int code;//状态码
    public ResultType data;//返回的数据主体

    public NetResponse(Call call, boolean isSuccess, int state, ResultType data) {
        this.call = call;
        this.isSuccess = isSuccess;
        this.state = state;
        this.data = data;
    }
}
