package com.chris.elastic.job.config;

import com.chris.elastic.job.listener.MyElasticJobListener;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * @author chrischan
 * create on 2019/6/28 15:18
 * use for:
 */
//@Configuration
public class StockJobConfig {
    @Autowired
    JobRegCenterConfig jobRegCenterConfig;
    @Autowired
    ZookeeperRegistryCenter zookeeperRegistryCenter;
    @Autowired
    MyElasticJobListener myElasticJobListener;

    public StockJobConfig() {
    }

    @Bean(initMethod = "init")
    public JobScheduler simpleJobScheduler(final SimpleJob simpleJob,
                                           @Value("${stockJob.cron}") final String cron,
                                           @Value("${stockJob.shardingTotalCount}") final int shardingTotalCount,
                                           @Value("${stockJob.shardingItemParameters}") final String shardingItemParameters) {
        return new SpringJobScheduler(simpleJob, zookeeperRegistryCenter, getLiteJobConfiguration(simpleJob.getClass(), cron, shardingTotalCount, shardingItemParameters),myElasticJobListener);
    }

    /**
     * @Description 任务配置类
     */
    private LiteJobConfiguration getLiteJobConfiguration(final Class<? extends SimpleJob> jobClass,
                                                         final String cron,
                                                         final int shardingTotalCount,
                                                         final String shardingItemParameters) {

        JobCoreConfiguration jobCoreConfiguration = JobCoreConfiguration.newBuilder(jobClass.getName(), cron, shardingTotalCount)
                .shardingItemParameters(shardingItemParameters)
                .build();
        SimpleJobConfiguration jobConfig = new SimpleJobConfiguration(jobCoreConfiguration, jobClass.getCanonicalName());
        LiteJobConfiguration liteJobConfiguration = LiteJobConfiguration.newBuilder(jobConfig)
                .overwrite(true)
                .build();
        return liteJobConfiguration;

    }
}
