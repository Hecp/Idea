package com.hcp.jvm.oom;

/**
 * Created by hcp on 2018/8/15.
 */
public class TestAllocation {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        /**
         *  -XX:PretenureSizeThreshold=3145728 （内存占用大于这个值的对象直接分配在老年代）
         *  如果使用ParNew收集器（-XX:+UseParNewGC），不增加上面参数将会发生一次Minor GC，然后将allocation1、allocation2、allocation3转移到老年代。
         *  如果使用jdk1.8默认的Parallel Scavenge收集器，则不会发生Minor GC，而是直接将allocation4分配在老年代。
         */
        allocation4 = new byte[4 * _1MB];
    }

    public static void testPretenureSizeThreshold() {
        byte[] allocation = new byte[4 * _1MB];
    }
}
