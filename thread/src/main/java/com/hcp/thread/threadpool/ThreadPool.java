package com.hcp.thread.threadpool;

/**
 * Created by hcp on 2019/7/18.
 */
public interface ThreadPool {
    void execute(Runnable worker);

    public void shutdown();

    public void addWorker(int num);

    public int getWorkerNum();
}
