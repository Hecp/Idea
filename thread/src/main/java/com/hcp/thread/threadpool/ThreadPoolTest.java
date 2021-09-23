package com.hcp.thread.threadpool;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hcp on 2019/7/19.
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        DefaultThreadPool threadPool = new DefaultThreadPool(20);
        for (int i = 0; i < 10000; i++) {
            threadPool.execute(new Job());
        }
        threadPool.shutdown();
    }

    public static class Job implements Runnable {

        private static AtomicInteger i = new AtomicInteger(0);

        @Override
        public void run() {
            System.out.println("当前处理的线程:" + Thread.currentThread().getName() + " 执行任务" + (i.incrementAndGet()) + " 完成");
        }
    }
}
