package com.zh.concurrent;

/**
 * @author Beloved
 * @date 2020/9/22 22:30
 */
public class Race implements Runnable {

    // 胜利者
    private static String winner;

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            boolean over = gameOver(i);

            if (over){
                break;
            }

            System.out.println(Thread.currentThread().getName()+"--->跑了"+i+"步");
        }
    }

    // 判断是否完成比赛
    private boolean gameOver(int steps){
        // 判断是否有胜利者
        if (winner != null){
            return true;
        }else {
            if (steps >= 10){
                winner = Thread.currentThread().getName();

                System.out.println("胜利者是："+winner);

                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race,"兔子").start();
        new Thread(race,"乌龟").start();
    }
}
