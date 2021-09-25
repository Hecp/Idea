package com.hcp.thread.threadpool;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hcp on 2019/7/18.
 */
public class DefaultThreadPool implements ThreadPool {

    private static final Integer MAX_WORKER_NUM = 50;

    private static final Integer DEFAULT_WORKER_NUM = 5;

    private final BlockingQueue<Runnable> taskList = new LinkedBlockingQueue<>();

    private final List<Worker> workerList = new LinkedList<>();

    private AtomicInteger threadId = new AtomicInteger();

    private Integer workerNum;

    public DefaultThreadPool(int workerNum) {
        if (workerNum > MAX_WORKER_NUM) {
            this.workerNum = DEFAULT_WORKER_NUM;
        } else {
            this.workerNum = workerNum;
        }
        initThreadPool(workerNum);
    }

    private void initThreadPool(int workerNum) {
        for (int i = 0; i < workerNum; i++) {
            Worker worker = new Worker();
            workerList.add(worker);
            Thread thread = new Thread(worker);
            thread.setName("thread pool-" + threadId.incrementAndGet());
            thread.start();
        }
    }

    @Override
    public void execute(Runnable task) {
        if (task == null) {
            throw new NullPointerException("task can not null.");
        }
        synchronized (taskList) {
            taskList.add(task);
            taskList.notifyAll();
        }
    }

    @Override
    public void shutdown() {
        for (Worker worker : workerList) {
            worker.shutdown();
        }
    }

    @Override
    public void addWorker(int num) {
        synchronized (workerList) {
            if (this.getWorkerNum() + num > MAX_WORKER_NUM) {
                num = MAX_WORKER_NUM - this.getWorkerNum();
            }
        }
        initThreadPool(num);
        this.workerNum += num;
    }

    @Override
    public int getWorkerNum() {
        return workerList.size();
    }

    public class Worker implements Runnable {

        private volatile boolean isRunning = true;

        @Override
        public void run() {
            Runnable runnable = null;
            //死循环
            while (isRunning) {
                //非线程安全，所以采用同步锁
                synchronized (taskList) {
                    while (isRunning && taskList.isEmpty()) {
                        try {
                            //如果任务队列为空，等待20毫秒 监听任务到达
                            taskList.wait(20);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    //任务队列不为空
                    if (!taskList.isEmpty()) {
                        try {
                            runnable = taskList.take();//获取第一个任务
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (runnable != null) {
                    runnable.run();
                }
                runnable = null;
            }
        }

        public void shutdown() {
            isRunning = false;
        }
    }
}
