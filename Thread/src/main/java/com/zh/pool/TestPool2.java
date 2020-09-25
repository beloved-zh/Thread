package com.zh.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Beloved
 * @date 2020/9/25 9:51
 *
 * 测试CachedThreadPool
 */
public class TestPool2 {

    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            service.execute(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }

        service.shutdown();

    }

}
