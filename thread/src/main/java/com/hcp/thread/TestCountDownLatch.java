package com.hcp.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by hcp on 2018/7/27.
 */
public class TestCountDownLatch {

    public static void main(String[] args) {
        testCountDownLatch();
    }

    public static void testCountDownLatch() {
        int threadNum = 3;
        long startTime = System.currentTimeMillis();
        final CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for (int i = 0; i < threadNum; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " running……");
                    try {
                        Thread.sleep(2000);
                        countDownLatch.countDown();
                        System.out.println(Thread.currentThread().getName() + " over.");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main thread total time : " + (System.currentTimeMillis() - startTime));
    }
}
