package com.zh.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Beloved
 * @date 2020/9/25 9:51
 *
 * 测试newScheduledThreadPool
 */
public class TestPool4 {

    public static void main(String[] args) {

        // corePoolSize 线程池大小
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 10; i++) {
            service.schedule(
                    ()->{
                        System.out.println(Thread.currentThread().getName());
                    },
                    3,      // 周期执行时间
                    TimeUnit.SECONDS // 时间单位
            );
        }

        service.shutdown();

    }

}
