package com.kuang.demo1;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//练习Thread，实现多线程同步下载图片
public class TestThread2 extends Thread{

    private String url; //网络图片地址
    private String name;  //保存的文件名

    public TestThread2(String url,String name){
        this.url = url;
        this.name = name;
    }

    //下载图片线程的执行体
    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为：" + name);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X3BuZy91SkRBVUtyR0M3SkRBbGdFaGljUWZ5VWVrbGVmclVoWWliSWV3M3ZvOE4xem95OWljMm5PVlZKV3RqWnNYZzdUV3NEREdoQUk1clNHWjB0blE2T0lPOE1CZy82NDA?x-oss-process=image/format,png","1.jpg");
        TestThread2 t2 = new TestThread2("https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X3BuZy91SkRBVUtyR0M3SkRBbGdFaGljUWZ5VWVrbGVmclVoWWlia1lJNWpma1lqOGhwaFl2N0dFZFFTY3pqYjFpY1F3aldHbFdxaEcyNlZPMXk1dGdNMk9jU3RhQS82NDA?x-oss-process=image/format,png","2.jpg");
        TestThread2 t3 = new TestThread2("https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X3BuZy91SkRBVUtyR0M3SkRBbGdFaGljUWZ5VWVrbGVmclVoWWliRXZ2UDhWMjdKTjF3azJCRGtwaDZQQ09qNDVKZmNuaEphaWJIc1Y2alZld3daWnVtYXB3VGliaWNnLzY0MA?x-oss-process=image/format,png","3.jpg");

        t1.start();
        t2.start();
        t3.start();
    }
}

//下载器
class WebDownloader{
    //下载方法
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downloader方法出现问题");
        }
    }
}
