package com.chris.base.libs.net;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

/**
 * AiligouApp
 * com.alg.ailigou.common.net
 * Created by Chris Chen on 2017/7/13 17:50.
 * Explain:
 */

public class NetManager {
    private static List<Call> requests = new ArrayList<>();

    /**
     * 添加请求
     *
     * @param call
     */
    public static void addRequest(Call call) {
        requests.add(call);
    }

    /**
     * 清除所有请求
     */
    public static void removeAllRequest() {
        List<Call> calls = new ArrayList<>();
        calls.addAll(requests);
        for (Call call : calls) {
            if (call != null) {
                if (call.isExecuted()) {
                    call.cancel();
                }
                call = null;
            }
        }
        calls.clear();
    }
}
