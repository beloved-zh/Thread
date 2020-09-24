package com.zh.deadlock;

/**
 * @author Beloved
 * @date 2020/9/24 11:10
 *
 * 死锁：多个线程互相拥有对方需要的资源，然后形成僵持
 */
public class Deadlock {

    public static void main(String[] args) {
        Makeup makeup1 = new Makeup(1, "白雪公主");
        Makeup makeup2 = new Makeup(2, "灰姑娘");

        makeup1.start();
        makeup2.start();
    }
}

// 口红
class Lipstick{}

// 镜子
class Mirror{}

class Makeup extends Thread{

    // 需要的资源只有一份，用static保证只有一份
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();

    int id; // 用户标识
    String girlName; // 用户名

    public Makeup(int id, String girlName) {
        this.id = id;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 化妆  互相拥有对方的资源，需要拿到对方的资源才能运行
    private void makeup() throws InterruptedException {
        if (id == 1){
            synchronized (lipstick){ // 获得口红的锁
                System.out.println(this.girlName+"--->获得口红的锁");
                Thread.sleep(1000);
            }
            synchronized (mirror){ // 一秒后想获得镜子的锁
                System.out.println(this.girlName+"--->获得镜子的锁");
            }
        }else {
            synchronized (mirror){ // 获得镜子的锁
                System.out.println(this.girlName+"--->获得镜子的锁");
                Thread.sleep(2000);
            }
            synchronized (lipstick){ // 两秒后想获得口红的锁
                System.out.println(this.girlName+"--->获得口红的锁");
            }
        }
    }
}