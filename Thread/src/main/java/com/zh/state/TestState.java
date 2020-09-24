package com.zh.state;

/**
 * @author Beloved
 * @date 2020/9/23 21:10
 * 测试线程状态
 */
public class TestState {

    public static void main(String[] args) {

        Thread thread = new Thread(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("----------------------------");
        });


        // 观察状态
        Thread.State state = thread.getState();
        System.out.println(state);   // NEW  还未启动

        // 观察启动后
        thread.start();// 启动线程
        state = thread.getState();
        System.out.println(state); // RUN

        while (state != Thread.State.TERMINATED){ // 只要线程不终止，就一直输出状态
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            state = thread.getState(); // 更新线程状态
            System.out.println(state); // 输出状态
        }

        // thread.start();  线程已经死了，再次启动就会报错
    }

}
