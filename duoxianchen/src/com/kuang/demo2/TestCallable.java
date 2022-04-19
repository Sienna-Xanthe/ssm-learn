package com.kuang.demo2;

import com.kuang.demo1.TestThread2;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

//线程创建方式三：实现callable接口

/**
 * callable的好处
 * 1.可以定义返回值
 * 2.可以抛出异常。
 */
public class TestCallable implements Callable<Boolean> {

    private String url;
    private String name;

    public TestCallable(String url,String name){
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() throws Exception {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为：" + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X3BuZy91SkRBVUtyR0M3SkRBbGdFaGljUWZ5VWVrbGVmclVoWWliSWV3M3ZvOE4xem95OWljMm5PVlZKV3RqWnNYZzdUV3NEREdoQUk1clNHWjB0blE2T0lPOE1CZy82NDA?x-oss-process=image/format,png","a.jpg");
        TestCallable t2 = new TestCallable("https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X3BuZy91SkRBVUtyR0M3SkRBbGdFaGljUWZ5VWVrbGVmclVoWWlia1lJNWpma1lqOGhwaFl2N0dFZFFTY3pqYjFpY1F3aldHbFdxaEcyNlZPMXk1dGdNMk9jU3RhQS82NDA?x-oss-process=image/format,png","b.jpg");
        TestCallable t3 = new TestCallable("https://imgconvert.csdnimg.cn/aHR0cHM6Ly9tbWJpei5xcGljLmNuL21tYml6X3BuZy91SkRBVUtyR0M3SkRBbGdFaGljUWZ5VWVrbGVmclVoWWliRXZ2UDhWMjdKTjF3azJCRGtwaDZQQ09qNDVKZmNuaEphaWJIc1Y2alZld3daWnVtYXB3VGliaWNnLzY0MA?x-oss-process=image/format,png","c.jpg");

        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);

        //获取结果
        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        boolean rs3 = r3.get();

        //关闭服务
        ser.shutdownNow();
    }
}

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
