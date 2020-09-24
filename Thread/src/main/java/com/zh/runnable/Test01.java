package com.zh.runnable;

/**
 * @author Beloved
 * @date 2020/9/22 21:27
 * 1、实现Runnable接口
 * 2、重写run方法
 * 3、执行线程需要丢入Runnable接口实现类，调用start方法
 */
public class Test01 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("run--->"+i);
        }
    }

    public static void main(String[] args) {
        Test01 t1 = new Test01();

        new Thread(t1).start();

        for (int i = 0; i < 20; i++) {
            System.out.println("main--->"+i);
        }
    }
}
