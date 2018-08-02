package com.hcp.thread;


/**
 * Created by hcp on 2018/7/27.
 */
public class EvenOddNum {
    private static volatile int num = 1;


    public static void main(String[] args) {
        Thread t1 = new Thread(new EvenNum());
        Thread t2 = new Thread(new OddNum());
        t1.start();
        t2.start();
    }


    public static class EvenNum implements Runnable {
        @Override
        public void run() {
            while (num <= 5000) {
                if (num % 2 == 1) {
                    System.out.println("奇数：" + num);
                    num++;
                }
            }
        }
    }

    public static class OddNum implements Runnable {

        @Override
        public void run() {
            while (num <= 5000) {
                if (num % 2 == 0) {
                    System.out.println("偶数：" + num);
                    num++;
                }
            }
        }
    }
}
