package com.hcp.thread.thinking.in.java;

/**
 * Created by hcp on 2018/5/25.
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
