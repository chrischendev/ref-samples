package com.chris.base.libs.net;

import com.chris.base.libs.utils.NetworkUtils;
import com.orhanobut.logger.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * com.alg.ailigouapp.common.net
 * AiligouApp
 * Created by Chris Chen on 2017/6/29 16:03
 * Explain:网络请求回调接口
 */

public abstract class NetCallback<ResultType> implements Callback, NetStatus {
    //需要查看未经过json格式转换工厂的返回数据，可以打开拦截器查看
    @Override
    public void onResponse(Call call, Response response) {
        //如果请求成功
        if (response.code() == 200) {
            //打印请求路径
            String requestUrl = response.raw().networkResponse().request().url().url().toString();
            //Logger.d("请求的URL===>" + requestUrl);
            //解析json
            NetResult<ResultType> result = (NetResult<ResultType>) response.body();
            //Logger.d("返回的json===>" + JsonUtils.objToJson(result));
            //todo 检测API请求返回数据结构是否正确
            Logger.d("MobileAPI:" + requestUrl + "  数据结构没问题");

            //判断:如果请求成功
            if (result.code == 0) {
                //如果数据不为空
                if (result.data != null) {
                    onComplete(new NetResponse<>(call, true, SUCCESS, result.data));
                } else {
                    //如果数据为空
                    onComplete(new NetResponse<ResultType>(call, true, DATA_EMPTY, null));
                }

            } else {
                onComplete(new NetResponse<ResultType>(call, false, DATA_ERROR, null));
            }

        }
    }

    /**
     * 请求完成后调用的方法，进行具体的处理
     *
     * @param netResponse
     */
    protected abstract void onComplete(NetResponse<ResultType> netResponse);


    @Override
    public void onFailure(Call call, Throwable t) {
        t.printStackTrace();
        //判断网网络情况
        if (NetworkUtils.isNetworkConnected()) {
            onComplete(new NetResponse<ResultType>(call, false, NET_ERROR, null));
        } else {
            onComplete(new NetResponse<ResultType>(call, false, DATA_ERROR, null));
            //todo 检测API请求返回数据结构是否正确
            Logger.d("MobileAPI:" + "某个数据接口返回数据结构有大问题~~~~~~~~~");
        }
    }
}
