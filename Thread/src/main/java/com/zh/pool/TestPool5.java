package com.zh.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Beloved
 * @date 2020/9/25 10:51
 *
 * 测试ThreadPoolExecutor
 */
public class TestPool5 {

    public static void main(String[] args) {

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                5,
                10,
                60L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue(10)
        );

        for (int i = 0; i < 10; i++) {
            poolExecutor.execute(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }

        poolExecutor.shutdown();

    }

}
