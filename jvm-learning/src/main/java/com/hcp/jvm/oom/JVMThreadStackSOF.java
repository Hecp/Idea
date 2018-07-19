package com.hcp.jvm.oom;

/**
 * 多线程导致内存溢出
 * VM args: -Xss2M
 * Created by hcp on 2018/6/9.
 */
public class JVMThreadStackSOF {
    private void dontStop() {
        while (true) {

        }
    }

    private void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }
}
