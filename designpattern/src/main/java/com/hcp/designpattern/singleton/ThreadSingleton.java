package com.hcp.designpattern.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * 多线程测试单例模式
 * Created by Administrator on 2016/3/13.
 */
public class ThreadSingleton {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int threadNum = 10;
        final CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i < 100000; i++) {
                        Object obj = SingletonInitLoad.getInstance();
                        /*Object obj = SingletonInnerClass.getInstance();*/
                    }
                    countDownLatch.countDown();
                }
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("总耗时：" + (System.currentTimeMillis() - startTime));
    }
}
