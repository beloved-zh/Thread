package com.zh.state;

/**
 * @author Beloved
 * @date 2020/9/23 22:29
 * 测试守护线程
 *  虚拟机不会管守护线程
 *  用户线程结束，程序就会结束
 */
public class TestDaemon {

    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        thread.setDaemon(true); // 默认是false表示用户线程，正常的线程都是用户线程

        thread.start(); // 守护线程启动

        new Thread(you).start(); // 用户线程启动

    }
}

// 上帝：守护线程
class God implements Runnable{

    @Override
    public void run() {
        while (true){
            System.out.println("上帝保佑你");
        }
    }
}

// 你：用户线程
class You implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("每一天都开心的活着");
        }
        System.out.println("========goodbye! world!==========");
    }
}
