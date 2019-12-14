package com.chris.elastic.job.listener;

import com.dangdang.ddframe.job.executor.ShardingContexts;
import com.dangdang.ddframe.job.lite.api.listener.ElasticJobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author chrischan
 * create on 2019/6/28 16:00
 * use for:
 */
@Component
public class MyElasticJobListener implements ElasticJobListener {
    private static Logger logger = LoggerFactory.getLogger(MyElasticJobListener.class);
    private long startTime = 0;

    @Override
    public void beforeJobExecuted(ShardingContexts shardingContexts) {
        startTime = System.currentTimeMillis();
    }

    @Override
    public void afterJobExecuted(ShardingContexts shardingContexts) {
        //logger.debug("Job used time " + (System.currentTimeMillis() - startTime) + " ms.");
        System.out.println("Job used time " + (System.currentTimeMillis() - startTime) + " ms.");
    }
}
