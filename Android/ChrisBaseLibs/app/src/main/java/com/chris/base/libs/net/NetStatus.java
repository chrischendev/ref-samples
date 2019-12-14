package com.chris.base.libs.net;

/**
 * com.alg.ailigouapp.common.net
 * AiligouApp
 * Created by Chris Chen on 2017/6/29 16:21
 * Explain:网络请求状态
 */

public interface NetStatus {
    int SUCCESS=0;//请求成功
    int DATA_EMPTY=1;//数据为空
    int DATA_ERROR=2;//数据错误
    int NET_ERROR=3;//网络错误
}
