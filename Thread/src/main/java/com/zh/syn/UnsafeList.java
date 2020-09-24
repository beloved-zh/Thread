package com.zh.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Beloved
 * @date 2020/9/24 8:36
 *
 * 线程不安全的集合
 */
public class UnsafeList {

    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }

        Thread.sleep(100);
        // 并不能插入10000条数据
        System.out.println(list.size());
    }

}
