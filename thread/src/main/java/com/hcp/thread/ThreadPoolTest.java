package com.hcp.thread;

/**
 * 线程池demo
 * Created by hcp on 2016/6/16.
 */

public class ThreadPoolTest {
    static Object obj = new Object();
    static Object obj1= new Object();
    public static void main(String[] args) {
        /**
         * 核心线程数：5
         * 最大线程数：10
         * 线程存活时间为：200ms（前提是线程池已满才会进行清理）
         * 线程缓存队列为ArrayBlockingQueue，数量为5（当缓存队列已满时，则开始创建新的线程）
         */
        /*ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));*/

        /*Executors.newCachedThreadPool()线程数量为无限大，因为最大线程数为Integer.MAX_VALUE，没有线程缓存队列。
        因为最大线程数为Integer.MAX_VALUE，所以不会抛出异常。*/
        /*ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();*/

        /*Executors.newFixedThreadPool(10)，创建最大线程数为10的线程池，采用LinkedBlockingQueue队列缓存，
        队列最大容量是Integer.MAX_VALUE。因为缓存队列容量是Integer.MAX_VALUE，所以不会抛出异常。*/
        /*ThreadPoolExecutor poolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);*/

        /*单线程线程池*/
        /*ExecutorService poolExecutor = Executors.newSingleThreadExecutor();*/

//        ScheduledExecutorService poolExecutor = Executors.newScheduledThreadPool(10);
//
//        for (int i = 0; i < 200; i++) {
//            MyTask myTask = new MyTask(i);
//            /*延迟1秒后每3秒执行一次*/
//            poolExecutor.scheduleAtFixedRate(myTask, 1, 3, TimeUnit.SECONDS);
//            poolExecutor.execute(myTask);
//            System.out.println("线程池中的线程数量：" + i /*+ poolExecutor.getPoolSize() + "，队列中等待的线程数量："
//                    + poolExecutor.getQueue().size() + "，已执行完成的线程数量：" + poolExecutor.getCompletedTaskCount()*/);
//        }
//        poolExecutor.shutdown();

        new Thread(new MyTask(1)).start();
        new Thread(new MyTask(2)).start();
    }
}

class MyTask implements Runnable{

    private int taskNum;

    public MyTask(int taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public void run() {
            System.out.println("正在执行Task：" + taskNum);
        while (true) {
            synchronized (ThreadPoolTest.obj){
                System.out.println("lock obj ......");
                try {
                    Thread.sleep(4000);
                    synchronized (ThreadPoolTest.obj1) {
                        System.out.println("lock obj1.......");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
