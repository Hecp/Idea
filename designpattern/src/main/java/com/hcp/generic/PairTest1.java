package com.hcp.generic;

import javafx.scene.input.KeyCode;

import java.io.Serializable;

/**
 * 自定义泛型类测试
 * 1、变量smallest类型为T，这意味着它可以是任何一个对象。怎么才能确信T所属的类有compareTo方法呢？
 * 解决方案：将T限制为实现了Comparable接口的类(<T extends Comparable>)。
 * 2、一个类型变量或通配符可以有多个限定，例如：<T extends Comparable & Serializable>
 * 3、在Java的继承中，可以根据需要拥有多个接口超类型，但限定中至多有一个类。
 * 4、如果用一个类作为限定，它必须是限定列表中的第一个。
 * Created by hcp on 2016/7/24.
 */
public class PairTest1 {
    public static void main(String[] args) {
        String[] words = {"Mary", "has", "a", "little", "lamb"};
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
        System.out.println("middle = " + ArrayAlg.getMiddle("John", "Q.", "Public"));
    }


}

class ArrayAlg {
    public static Pair<String> minmax(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }
        String min = words[0];
        String max = words[0];
        for (String word : words) {
            if (min.compareTo(word) > 0) {
                min = word;
            }
            if (max.compareTo(word) < 0) {
                max = word;
            }
        }
        return new Pair<String>(min, max);
    }

    /**
     * 自定义泛型方法
     *
     * @param a   入参
     * @param <T> 泛型
     * @return 返回值
     */
    public static <T> T getMiddle(T... a) {
        return a[a.length / 2];
    }

    public static <T extends Comparable & Serializable> T min(T[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        T smallest = a[0];
        for (int i = 0; i < a.length; i++) {
            /*1、变量smallest类型为T，这意味着它可以是任何一个对象。怎么才能确信T所属的类有compareTo方法呢？
            解决方案：将T限制为实现了Comparable接口的类(<T extends Comparable>)。
            */
            if (smallest.compareTo(a[i]) > 0) {
                smallest = a[i];
            }
        }
        return smallest;
    }

    public static <T> T getInstance(){

        return null;
    }
}
