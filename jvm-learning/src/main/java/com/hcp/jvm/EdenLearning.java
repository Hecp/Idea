package com.hcp.jvm;

/**
 * 3.6.1 对象优先在Eden分配
 * Created by Administrator on 2016/4/9.
 */
public class EdenLearning {
    private static final int _1MB = 1024 * 1024;



    public static void main(String[] args) {
        /*testAllocation();*/
        testPretenureSizeThreshold();
    }

    /**
     * jvm 参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     */
    public static void testAllocation(){
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }

    /**
     * jvm 参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
     */
    public static void testPretenureSizeThreshold(){
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }
}
