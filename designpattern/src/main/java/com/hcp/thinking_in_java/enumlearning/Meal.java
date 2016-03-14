package com.hcp.thinking_in_java.enumlearning;

/**
 * Thinking in java
 * 19.7 使用接口组织枚举
 * Created by Administrator on 2016/3/13.
 */
public class Meal {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (Course course : Course.values()) {
                Food food = course.randomSelection();
                System.out.println(food);
            }
            System.out.println("====================");
        }
    }
}
