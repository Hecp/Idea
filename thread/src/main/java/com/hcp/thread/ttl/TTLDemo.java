package com.hcp.thread.ttl;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;

import java.util.concurrent.TimeUnit;

public class TTLDemo {
    static TransmittableThreadLocal ttl = new TransmittableThreadLocal();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
          ttl.set("ttl demo parent thread");
          new Thread(TtlRunnable.get(() -> {
              m1();
          }), "childThread").start();
        }, "parentThread").start();
        TimeUnit.SECONDS.sleep(5 * 1000);
    }

    private static void m1() {
        m2();
    }

    private static void m2() {
        System.out.println(ttl.get());
    }
}
