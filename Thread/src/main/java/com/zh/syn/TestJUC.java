package com.zh.syn;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Beloved
 * @date 2020/9/24 11:03
 *
 * JUC安全类型的集合
 */
public class TestJUC {

    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }

        Thread.sleep(100);

        System.out.println(list.size());
    }

}
