package com.zh.state;

/**
 * @author Beloved
 * @date 2020/9/23 20:57
 */
public class TestJoin implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("VIP线程--->"+i);
        }
    }

    public static void main(String[] args) {
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        // 主线程
        for (int i = 0; i < 10; i++) {
            if (i==5){
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("main--->"+i);
        }
    }
}
