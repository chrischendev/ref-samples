package com.aiways.storm.utils;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;

/**
 * Created by Chris Chen
 * 2019/01/31
 * Explain:
 */

public class CommonUtils {
    private static final String ES_URL = "http://10.100.81.151:9200";

    //创建ES客户端
    public static JestClient createJestClient() {
        String serverUri = ES_URL;
        JestClientFactory jestClientFactory = new JestClientFactory();
        HttpClientConfig config = new HttpClientConfig.Builder(serverUri)
                .connTimeout(1000 * 10)
                .build();
        jestClientFactory.setHttpClientConfig(config);
        return jestClientFactory.getObject();
    }
}
