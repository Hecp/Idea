/**
 * Created by hcp on 2019/2/15.
 */
public class DeedLock {
    private static String s1 = "s1";
    private static String s2 = "s2";

    public static void main(String[] args) {
        Thread t1 = new Thread(new Lock1());
        Thread t2 = new Thread(new Lock2());

        t1.start();
        t2.start();
    }

    static class Lock1 implements Runnable {

        @Override
        public void run() {
            System.out.println("lock1 running……");
            while (true) {
                synchronized (DeedLock.s1) {
                    System.out.println("lock1 lock DeedLock.s1");
                    try {
                        Thread.sleep(3000L);
                        synchronized (DeedLock.s2) {
                            System.out.println("lock1 lock DeedLock.s2");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Lock2 implements Runnable {

        @Override
        public void run() {
            System.out.println("lock2 running……");
            while (true) {
                synchronized (DeedLock.s2) {
                    System.out.println("lock2 lock DeedLock.s2");
                    try {
                        Thread.sleep(3000L);
                        synchronized (DeedLock.s1) {
                            System.out.println("lock2 lock DeedLock.s1");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
