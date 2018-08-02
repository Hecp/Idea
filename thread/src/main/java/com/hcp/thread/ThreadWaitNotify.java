package com.hcp.thread;

/**
 * Created by hcp on 2018/7/27.
 */
public class ThreadWaitNotify {
    private int start = 1;

    private boolean flag = false;

    public static void main(String[] args) {
        ThreadWaitNotify threadWaitNotify = new ThreadWaitNotify();

        Thread t1 = new Thread(new EvenNum(threadWaitNotify));
        t1.setName("T1");

        Thread t2 = new Thread(new OddNum(threadWaitNotify));
        t2.setName("T2");

        t1.start();
        t2.start();
    }

    public static class EvenNum implements Runnable {

        private ThreadWaitNotify number;

        public EvenNum(ThreadWaitNotify number) {
            this.number = number;
        }

        @Override
        public void run() {
            while (number.start <= 1000) {
                synchronized (ThreadWaitNotify.class) {
                    System.out.println("偶数线程抢到锁了……");
                    if (number.flag) {
                        System.out.println(Thread.currentThread().getName() + "********偶数：" + number.start);
                        number.start++;
                        number.flag = false;
                        ThreadWaitNotify.class.notify();
                    }else {
                        try {
                            ThreadWaitNotify.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static class OddNum implements Runnable {
        private ThreadWaitNotify number;

        public OddNum(ThreadWaitNotify number) {
            this.number = number;
        }

        @Override
        public void run() {
            while (number.start <= 1000) {
                synchronized (ThreadWaitNotify.class) {
                    System.out.println("奇数线程抢到锁了……");
                    if (!number.flag) {
                        System.out.println(Thread.currentThread().getName() + "*************奇数：" + number.start);
                        number.start++;
                        number.flag = true;
                        ThreadWaitNotify.class.notify();
                    } else {
                        try {
                            ThreadWaitNotify.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
