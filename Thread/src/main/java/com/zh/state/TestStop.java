package com.zh.state;

/**
 * @author Beloved
 * @date 2020/9/23 20:17
 * 测试线程停止
 *  1、建议线程正常停止--->利用次数，不建议死循环
 *  2、建议使用标识位---->设置一个标志位
 *  3、不要使用stop或destroy等过时方法或JDK不建议使用的
 */
public class TestStop implements Runnable{

    // 设置标识位
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag){
            System.out.println("run...Thread--->"+i++);
        }
    }

    // 公开方法停止线程
    public void stop(){
        this.flag = false;
    }

    public static void main(String[] args) {
        TestStop testStop = new TestStop();

        new Thread(testStop).start();

        for (int i = 0; i < 100; i++) {
            System.out.println("main--->"+i);
            if (i == 10){
                testStop.stop();
                System.out.println("线程停止了..........");
            }
        }
    }
}
