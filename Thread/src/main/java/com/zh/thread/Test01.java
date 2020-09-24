package com.zh.thread;

/**
 * @author Beloved
 * @date 2020/9/22 20:49
 * 1、继承Thread类
 * 2、重写run()方法
 * 3、调用start开启线程
 */
public class Test01 extends Thread {

    @Override
    public void run() {
        // run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("run--->"+i);
        }

    }

    public static void main(String[] args) {
        // main线程，主线程

        // 创建线程对象
        Test01 thread1 = new Test01();

        // 开启线程
        thread1.start();

        for (int i = 0; i < 20; i++) {
            System.out.println("main--->"+i);
        }
    }
}
