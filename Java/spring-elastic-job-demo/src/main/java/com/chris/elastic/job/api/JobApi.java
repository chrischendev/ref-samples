package com.chris.elastic.job.api;

import com.chris.elastic.job.config.MyElasticJobConfig;
import com.chris.elastic.job.job.MyElasticJob;
import com.chris.elastic.job.job.MyElasticJob2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chrischan
 * create on 2019/6/28 16:21
 * use for:
 */
@RestController
@RequestMapping("/job")
public class JobApi {
    @Autowired
    MyElasticJobConfig myElasticJobConfig;

    @GetMapping("/addJob")
    public ResponseEntity<?> addJob() {
        myElasticJobConfig.addJob(MyElasticJob.class, "0/8 * * * * ?", 2, "0=A,1=B");
        return ResponseEntity.ok("AddJob Success!");
    }

    @GetMapping("/addJob2")
    public ResponseEntity<?> addJob2() {
        myElasticJobConfig.addJob(MyElasticJob2.class, "0/5 * * * * ?", 3, "0=AA,1=BB,2=CC");
        return ResponseEntity.ok("AddJob2 Success!");
    }
}
