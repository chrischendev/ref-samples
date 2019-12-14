package com.chris.elastic.job.config;

import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chrischan
 * create on 2019/6/28 15:14
 * use for:
 */
@Configuration
@ConditionalOnExpression("'${regCenter.serverList}'.length() > 0")
public class JobRegCenterConfig {
    @Bean(initMethod = "init")
    public ZookeeperRegistryCenter zookeeperRegistryCenter(@Value("${regCenter.serverList}") final String serverList,
                                                           @Value("${regCenter.namespace}") final String namespace) {
        return new ZookeeperRegistryCenter(new ZookeeperConfiguration(serverList, namespace));
    }
}
