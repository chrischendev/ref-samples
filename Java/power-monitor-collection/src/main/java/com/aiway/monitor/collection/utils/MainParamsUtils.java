package com.aiway.monitor.collection.utils;

import com.aiway.monitor.collection.consts.AppCommonConsts;
import com.chris.es.jest.utils.StringUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Chris Chen
 * 2019/03/05
 * Explain: 运行参数处理
 */

public class MainParamsUtils implements AppCommonConsts {
    public static MainParams parse(String[] args) {
        MainParams mainParams = new MainParams();
        if (args == null || args.length == 0) {
            return mainParams;
        }

        for (String arg : args) {
            if (arg.indexOf('=') < 0) {
                continue;//必须用'='连接
            }
            String[] argKV = arg.split("=");
            if (argKV.length != 2) {//只能有一个'='
                continue;
            }
            String paramsKey = argKV[0];
            String paramsValue = argKV[1];

            if ("env".equalsIgnoreCase(paramsKey) && isEnv(paramsValue)) {
                mainParams.setEnv(paramsValue);
                continue;//环境参数
            }
            if ("topo".equalsIgnoreCase(paramsKey) && StringUtils.isNotEmptyOrAllBackSpace(paramsValue)) {
                mainParams.setTopoName(paramsValue);
                continue;//拓扑名称
            }
        }
        return mainParams;
    }

    //判断是不是合法的环境参数值
    private static boolean isEnv(String str) {
        Set<String> envSet = new HashSet<>(Arrays.asList(ENV_NAMES));
        if (envSet.contains(str)) {
            return true;
        }
        return false;
    }
}
