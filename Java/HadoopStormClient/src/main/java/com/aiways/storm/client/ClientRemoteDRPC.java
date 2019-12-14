package com.aiways.storm.client;


import org.apache.storm.Config;
import org.apache.storm.utils.DRPCClient;
import org.apache.storm.utils.Utils;

import java.util.Map;

public class ClientRemoteDRPC {
    private static final String NIMBUS_HOST = "10.100.81.177";

    public static void main(String[] args) throws Exception {
//        Config conf = new Config();
//        conf.setDebug(true);
        Map<String, Object> config = Utils.readDefaultConfig();
        DRPCClient drpcClient = new DRPCClient(config, NIMBUS_HOST, 3772);
        String res = drpcClient.execute("chrisTestTopology", "远程调用成功");
        System.out.println(res);
        drpcClient.close();
    }
}