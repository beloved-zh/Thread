package com.zh.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Beloved
 * @date 2020/9/24 11:34
 *
 * 测试Lock锁
 */
public class TestLock {

    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket,"张三").start();
        new Thread(buyTicket,"李四").start();
        new Thread(buyTicket,"王五").start();
    }

}

class BuyTicket implements Runnable{

    // 票
    private int ticketNums = 10000;

    // 定义Lock锁
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        // 买票
        while (true){

            try {
                // 加锁
                lock.lock();
                if (ticketNums > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"---->"+ticketNums--);
                }else {
                    break;
                }
            }finally {
                // 解锁
                lock.unlock();
            }


        }
    }
}
