package com.zh.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author Beloved
 * @date 2020/9/22 21:02
 * 多线程同步下载图片
 */
public class Test02 extends Thread{

    private String url;
    private String name;

    public Test02(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader downloader = new WebDownloader();
        downloader.downloader(url,name);
        System.out.println("下载文件名为："+name);
    }

    public static void main(String[] args) {
        Test02 t1 = new Test02("https://api.btstu.cn/sjbz/api.php", "1.jpg");
        Test02 t2 = new Test02("https://api.btstu.cn/sjbz/api.php", "2.jpg");
        Test02 t3 = new Test02("https://api.btstu.cn/sjbz/api.php", "3.jpg");

        t1.start();
        t2.start();
        t3.start();
    }
}

/**
 * 下载器
 */
class WebDownloader{
    // 下载方法
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常");
        }
    }
}
