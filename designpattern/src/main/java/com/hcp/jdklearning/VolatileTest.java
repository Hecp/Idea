package com.hcp.jdklearning;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * volatile 测试类
 * Created by Administrator on 2016/3/18.
 */
public class VolatileTest {

    /*volatile修饰的变量可以保证多线程情况下的可见性，但并不能保证该变量的操作原子性。*/
    /*public volatile int inc = 0;*/
    public AtomicInteger inc = new AtomicInteger();
    Lock lock = new ReentrantLock();

    /**
     * volatile修饰的变量进行自增操作
     * 自增操作存在三个步骤：1、读取变量的值；2、进行变量的+1操作；3、写入工作内存
     * 所以自增操作并不是原子性操作。
     * 解决办法：
     * 1、将当前方法增加synchronized，则可以保证当前方法体中操作的原子性。
     * 2、采用Lock进行加锁，以保证原子性操作。
     * 3、采用AtomicInteger——在java 1.5的java.util.concurrent.atomic包下提供了一些原子操作类，
     * 即对基本数据类型的 自增（加1操作），自减（减1操作）、以及加法操作（加一个数），
     * 减法操作（减一个数）进行了封装，保证这些操作是原子性操作。
     * atomic是利用CAS来实现原子性操作的（Compare And Swap），CAS实际上是利用处理器提供的CMPXCHG指令实现的，
     * 而处理器执行CMPXCHG指令是一个原子性操作。
     */
    public void increase() {
        /*lock.lock();
        try {
            inc++;
        } finally {
            lock.unlock();
        }*/
        inc.getAndIncrement();
    }

    public static void main(String[] args) {
        final VolatileTest test = new VolatileTest();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        test.increase();
                    }
                }
            }.start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(test.inc);
    }

}
