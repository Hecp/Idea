package com.hcp.jdklearning;

/**
 * Thread类相关测试
 * Created by Administrator on 2016/4/30.
 */
public class ThreadTest {

    public static class ThreadDemo implements Runnable{

        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("ThreadDemo " + i);
            }
        }
    }

    public static void main(String[] args) {
        String threadName = Thread.currentThread().getName();
        ThreadDemo t1 = new ThreadDemo();

        Thread demo = new Thread(t1, "ThreadDemo");
//        demo.start();
        try {
            demo.join();
            demo.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 50; i++) {
            System.out.println(threadName + "线程执行" + i);
        }
    }
}
