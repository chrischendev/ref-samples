package com.chris.base.libs.net;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * com.alg.ailigouapp.common.net
 * AiligouApp
 * Created by Chris Chen on 2017/6/29 13:31
 * Explain:网络请求客户端
 */

public class NetClient {
    public static OkHttpClient client;
    public static Retrofit.Builder builder;

    /**
     * 创建retrfit对象
     *
     * @param baseUrl
     * @return
     */
    public static Retrofit getRetrofit(String baseUrl) {
        if (builder == null) {
            builder = new Retrofit.Builder()
                    .client(getClient())
                    .addConverterFactory(GsonConverterFactory.create());
        }
        return builder.baseUrl(baseUrl).build();
    }

    /**
     * 创建okHttp客户端
     *
     * @return
     */
    public static OkHttpClient getClient() {
        if (client == null) {
            client = new OkHttpClient.Builder()
                    .addInterceptor(new NetInterceptor())
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .build();

        }
        return client;
    }
}
