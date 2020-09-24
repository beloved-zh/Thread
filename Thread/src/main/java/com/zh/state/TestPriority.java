package com.zh.state;

/**
 * @author Beloved
 * @date 2020/9/23 21:31
 * 测试优先级
 * 优先级范围 1 ~ 10
 */
public class TestPriority {

    public static void main(String[] args) {
        // 主线程默认优先级
        System.out.println(Thread.currentThread().getName()+"--->"+Thread.currentThread().getPriority());

        MyPriority myPriority = new MyPriority();

        Thread t1 = new Thread(myPriority, "t1");
        Thread t2 = new Thread(myPriority, "t2");
        Thread t3 = new Thread(myPriority, "t3");
        Thread t4 = new Thread(myPriority, "t4");
        Thread t5 = new Thread(myPriority, "t5");
        Thread t6 = new Thread(myPriority, "t6");

        // 先设置优先级在启动
        t1.start(); // 默认

        t2.setPriority(Thread.MIN_PRIORITY); // MIN_PRIORITY = 1
        t2.start();

        t3.setPriority(Thread.NORM_PRIORITY); // NORM_PRIORITY = 5
        t3.start();

        t4.setPriority(Thread.MAX_PRIORITY); // MAX_PRIORITY = 10
        t4.start();

        //t5.setPriority(-1); // 超出范围报错
        t5.setPriority(3);
        t5.start();

        //t6.setPriority(11); // 超出范围报错
        t6.setPriority(8);
        t6.start();
    }

}

class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"--->"+Thread.currentThread().getPriority());
    }
}
