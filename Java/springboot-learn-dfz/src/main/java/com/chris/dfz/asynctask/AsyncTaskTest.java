package com.chris.dfz.asynctask;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Create by Chris Chan
 * Create on 2019/12/29 9:16
 * Use for:
 */
public class AsyncTaskTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);
        test01(context);
        context.close();
    }

    /**
     * 执行结果并未按照先后顺序打印，因此是异步的
     * @param context
     */
    private static void test01(ApplicationContext context) {
        AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);
        for (int i = 0; i < 10; i++) {
            asyncTaskService.t1();
            asyncTaskService.t2();
        }
    }
}
