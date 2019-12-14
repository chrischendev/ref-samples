package com.chris.job.biz;

import com.chris.job.biz.jobs.MyElasticJob;
import com.chris.job.biz.jobs.StockSimpleJob;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.dangdang.ddframe.job.config.JobCoreConfiguration;
import com.dangdang.ddframe.job.config.simple.SimpleJobConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.lite.config.LiteJobConfiguration;
import com.dangdang.ddframe.job.lite.spring.api.SpringJobScheduler;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StockJobConfig {

    @Autowired
    private JobRegistryCenterConfig jobRegistryCenterConfig;

    @Autowired
    private ZookeeperRegistryCenter regCenter;

    public StockJobConfig() {
    }

    @Qualifier("StockSimpleJob")
    @Bean
    public SimpleJob stockSimpleJob() {
        return new StockSimpleJob();
    }
    @Qualifier("MyElasticJob")
    @Bean
    public SimpleJob myElasticJob() {
        return new MyElasticJob();
    }

    /**
     * @param simpleJob              任务
     * @param cron                   表达式
     * @param shardingTotalCount     分片总数
     * @param shardingItemParameters 分片参数
     * @return
     */
    @Qualifier("job1")
    @Bean(initMethod = "init")
    public JobScheduler simpleJobScheduler(@Qualifier("StockSimpleJob") final SimpleJob simpleJob,
                                           @Value("${stockJob.cron}") final String cron,
                                           @Value("${stockJob.shardingTotalCount}") final int shardingTotalCount,
                                           @Value("${stockJob.shardingItemParameters}") final String shardingItemParameters) {
        LiteJobConfiguration liteJobConfiguration = getLiteJobConfiguration(simpleJob.getClass(), cron, shardingTotalCount, shardingItemParameters);
        SpringJobScheduler springJobScheduler = new SpringJobScheduler(simpleJob, regCenter, liteJobConfiguration);
        return springJobScheduler;
    }
    @Qualifier("job2")
    @Bean(initMethod = "init")
    public JobScheduler simpleJobScheduler2(@Qualifier("MyElasticJob") final SimpleJob simpleJob,
                                           @Value("${stockJob.cron}") final String cron,
                                           @Value("${stockJob.shardingTotalCount}") final int shardingTotalCount,
                                           @Value("${stockJob.shardingItemParameters}") final String shardingItemParameters) {
        LiteJobConfiguration liteJobConfiguration = getLiteJobConfiguration(simpleJob.getClass(), cron, shardingTotalCount, shardingItemParameters);
        SpringJobScheduler springJobScheduler = new SpringJobScheduler(simpleJob, regCenter, liteJobConfiguration);
        return springJobScheduler;
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
        SimpleJobConfiguration simpleJobConfiguration = new SimpleJobConfiguration(jobCoreConfiguration, jobClass.getCanonicalName());
        return LiteJobConfiguration
                .newBuilder(simpleJobConfiguration)
                .overwrite(true)
                .build();

    }
}