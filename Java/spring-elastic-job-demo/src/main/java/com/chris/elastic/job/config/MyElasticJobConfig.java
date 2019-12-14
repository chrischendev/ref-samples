package com.chris.elastic.job.config;

import com.chris.elastic.job.listener.MyElasticJobListener;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author chrischan
 * create on 2019/6/28 16:12
 * use for:
 */
@Configuration
public class MyElasticJobConfig {
    @Autowired
    ZookeeperRegistryCenter zookeeperRegistryCenter;
    @Autowired
    MyElasticJobListener myElasticJobListener;

    /**
     * 添加任务
     *
     * @param jobClass
     * @param cron
     * @param shardingTotalCount
     * @param shardingItemParameters
     */
    public void addJob(final Class<? extends SimpleJob> jobClass, final String cron, final int shardingTotalCount, final String shardingItemParameters) {
        JobCoreConfiguration jobCoreConfiguration = JobCoreConfiguration.newBuilder(jobClass.getName(), cron, shardingTotalCount)
                .shardingItemParameters(shardingItemParameters)
                .build();

        SimpleJobConfiguration simpleJobConfiguration = new SimpleJobConfiguration(jobCoreConfiguration, jobClass.getCanonicalName());

        LiteJobConfiguration liteJobConfiguration = LiteJobConfiguration.newBuilder(simpleJobConfiguration).build();

        JobScheduler jobScheduler = new JobScheduler(zookeeperRegistryCenter, liteJobConfiguration, myElasticJobListener);

        jobScheduler.init();

    }

}
