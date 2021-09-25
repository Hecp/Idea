package com.hcp.jvm.juc.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hcp on 2019/1/15.
 */
public class ReentrantLockTest {
    private static Lock lock = new ReentrantLock(true);

    public static void main(String[] args) {
        lock.lock();
        for (int i = 0; i < 5; i++) {
            System.out.println("thread name : " + Thread.currentThread().getName() + " " + i);
        }
        lock.unlock();
    }
}
