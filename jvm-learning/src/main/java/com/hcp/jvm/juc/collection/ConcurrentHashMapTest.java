package com.hcp.jvm.juc.collection;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by hcp on 2019/3/19.
 */
public class ConcurrentHashMapTest {
    static Map<Integer, Integer> concurrentMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        System.out.println("Fibonacci result for 20 is" + fibonacci(20));
    }

    static int fibonacci(int i) {
        if (i == 0) {
            return i;
        }

        if (i == 1) {
            return 1;
        }

        return concurrentMap.computeIfAbsent(i, (key) -> {
            System.out.println("Value is " + key);
            return fibonacci(i - 2) + fibonacci(i - 1);
        });
    }
}
