package com.chris.elastic.job;

import com.dangdang.ddframe.job.api.AbstractOneOffElasticJob;
import com.dangdang.ddframe.job.api.JobExecutionMultipleShardingContext;

public class MyElasticJob extends AbstractOneOffElasticJob {

    @Override
    protected void process(JobExecutionMultipleShardingContext context) {
        // do something by sharding items
        System.out.println("MyElasticJob~~~~~~~~~~~~~~~~");
    }
}