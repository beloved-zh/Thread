package com.zh.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Beloved
 * @date 2020/9/24 22:46
 *
 * 测试线程池
 */
public class TestPool {

    public static void main(String[] args) {
        // 1.创建线程池
        //  nThreads：线程池大小
        ExecutorService service = Executors.newFixedThreadPool(10);

        // 2.执行
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());

        // 3.关闭
        service.shutdown();
    }

}

class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
