package com.zh.syn;

/**
 * @author Beloved
 * @date 2020/9/23 22:56
 * 不安全的买票
 */
public class UnsafeBuyTicket {

    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket,"李四").start();
        new Thread(buyTicket,"张三").start();
        new Thread(buyTicket,"黄牛").start();
    }

}


class BuyTicket implements Runnable{

    // 票
    private int ticketNums = 1000;
    private boolean flag = true; // 外部停止标识

    @Override
    public void run() {
        // 买票
        while (flag){
            buy();
        }
    }

    // synchronized 同步方法 锁的this--->BuyTicket
    private synchronized void buy(){
        // 判断是否有票
        if (ticketNums <= 0){
            flag = false;
            return;
        }

        // 模拟网络延迟
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //买票
        System.out.println(Thread.currentThread().getName()+"--->"+ticketNums--);
    }

}