package com.zh.concurrent;

/**
 * @author Beloved
 * @date 2020/9/22 22:12
 */
public class Test01 implements Runnable {

    // 票数
    private int ticketNums = 10;

    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            }
            // 模拟延迟
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Thread.currentThread().getName()：获取当前线程名
            System.out.println(Thread.currentThread().getName()+"--->拿到了第"+ticketNums--+"票");
        }
    }


    public static void main(String[] args) {
        Test01 t = new Test01();

        new Thread(t,"张三").start();
        new Thread(t,"李四").start();
        new Thread(t,"王五").start();
    }
}
