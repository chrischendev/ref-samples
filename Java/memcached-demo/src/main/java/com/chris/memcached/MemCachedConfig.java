package com.chris.memcached;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * create by: Chris Chan
 * create on: 2019/11/28 17:04
 * use for: MemCached配置
 */
@Configuration
public class MemCachedConfig {
    private static String[] MEM_SERVERS = {"192.168.0.108:11211"};//服务器
    private static Integer[] MEM_SERVERS_WEIGHT = {1};//权重

    @Bean
    public SockIOPool sockIOPool() {
        //建立通信的连接池
        SockIOPool pool = SockIOPool.getInstance();
        //设置连接池可用cache服务器列表，服务器构成形式：ip地址+端口号
        pool.setServers(MEM_SERVERS);
        //设置连接池可用cache服务器的权重，和server数组的位置一一对应
        pool.setWeights(MEM_SERVERS_WEIGHT);
        //设置初始连接数
        pool.setInitConn(100);
        //设置最小连接数
        pool.setMinConn(20);
        //设置最大连接数
        pool.setMaxConn(100);
        //设置可用连接的最长等待时间
        pool.setMaxIdle(1000 * 30 * 30);
        //设置连接池维护线程的睡眠时间，设置为0，维护线程不启动
        pool.setMaintSleep(50);
        //设置Nagle算法，设置为false，因为通讯数据量比较大要求响应及时
        pool.setNagle(false);
        //设置socket读取等待超时时间
        pool.setSocketTO(3000);
        //设置连接等待超时值
        pool.setSocketConnectTO(0);
        //失效转移机制
        pool.setFailover(true);
        //状态检测机制
        pool.setAliveCheck(true);
        //设置完参数后，启动pool
        pool.initialize();
        return pool;
    }

    @Bean
    public MemCachedClient memCachedClient() {
        return new MemCachedClient();
    }
}
