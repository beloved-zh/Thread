package com.zh.downloader;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * @author Beloved
 * @date 2020/9/24 23:09
 */
public class WebDownloaderImage {

    public static void main(String[] args) {

        String url = "https://api.btstu.cn/sjbz/api.php";

        String filePath = "F:\\壁纸下载\\";

        // 创建线程池
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                5,
                10,
                60L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue(10)
        );

        while (true){
            poolExecutor.execute(()-> {

                        String fileName = UUID.randomUUID().toString() + ".jpg";

                        try {
                            FileUtils.copyURLToFile(new URL(url), new File(filePath + fileName));
                            System.out.println(Thread.currentThread().getName() + "---->OK--->" + fileName);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
            );
        }

    }


}
