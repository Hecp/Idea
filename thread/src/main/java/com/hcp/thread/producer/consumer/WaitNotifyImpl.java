package com.hcp.thread.producer.consumer;

/**
 * Created by hcp on 2019/8/5.
 */
public class WaitNotifyImpl {

    private static int count = 0;

    private static int Full = 10;

    private static final String LOCK = "lock";

    public static void main(String[] args) {
        Thread p1 = new Thread(new Producer());
        p1.setName("p1");
        Thread p2 = new Thread(new Producer());
        p2.setName("p2");
        Thread p3 = new Thread(new Producer());
        p3.setName("p3");
        Thread p4 = new Thread(new Producer());
        p4.setName("p4");

        Thread c1 = new Thread(new Consumer());
        c1.setName("c1");
        Thread c2 = new Thread(new Consumer());
        c2.setName("c2");
        Thread c3 = new Thread(new Consumer());
        c3.setName("c3");
        Thread c4 = new Thread(new Consumer());
        c4.setName("c4");

        p1.start();
        c1.start();

        p2.start();
        c2.start();

        p3.start();
        c3.start();

        p4.start();
        c4.start();

    }

    static class Producer implements Runnable {
        @Override
        public void run() {
//            for (int i = 0; i < Full; i++) {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
            synchronized (LOCK) {
                while (count == Full) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count++;
                System.out.println(Thread.currentThread().getName() + "生产者生产了1个产品，目前总数是：" + count);
                LOCK.notifyAll();
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
//            for (int i = 0; i < Full; i++) {
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
            synchronized (LOCK) {
                while (count == 0) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                count--;
                System.out.println(Thread.currentThread().getName() + "消费者消费了1个产品，目前总数是：" + count);
                LOCK.notifyAll();
            }
        }
    }
}


