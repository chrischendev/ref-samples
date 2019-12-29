package com.chris.dfz.asynctask;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * Create by Chris Chan
 * Create on 2019/12/29 9:14
 * Use for:
 */
@Service
public class AsyncTaskService {
    @Async
    public void t1() {
        System.out.println("异步线程-1");
    }

    @Async
    public void t2() {
        System.out.println("异步线程-2");
    }
}
