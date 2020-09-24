package com.zh.callable;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/**
 * @author Beloved
 * @date 2020/9/22 21:48
 */
public class Test01 implements Callable<Boolean> {

    private String url;
    private String name;

    public Test01(String url, String name) {
        this.url = url;
        this.name = name;
    }

    // 自定义返回值
    @Override
    public Boolean call() throws Exception {
        WebDownloader downloader = new WebDownloader();
        downloader.downloader(url,name);
        System.out.println("下载文件名为："+name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Test01 t1 = new Test01("https://api.btstu.cn/sjbz/api.php", "1.jpg");
        Test01 t2 = new Test01("https://api.btstu.cn/sjbz/api.php", "2.jpg");
        Test01 t3 = new Test01("https://api.btstu.cn/sjbz/api.php", "3.jpg");

        // 创建执行服务     nThreads：多少个线程
        ExecutorService ser = Executors.newFixedThreadPool(3);

        // 提交执行
        Future<Boolean> rs1 = ser.submit(t1);
        Future<Boolean> rs2 = ser.submit(t2);
        Future<Boolean> rs3 = ser.submit(t3);

        // 获取结果
        Boolean r1 = rs1.get();
        Boolean r2 = rs2.get();
        Boolean r3 = rs3.get();

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);

        // 关闭服务
        ser.shutdownNow();
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