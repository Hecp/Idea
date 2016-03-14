package com.hcp.thinking_in_java.enumlearning;

/**
 * Thinking in java
 * 19.6 随机选取
 * Created by Administrator on 2016/3/9.
 */
enum Activity{
    SITTING, LYING, STANDING, HOPPING, RUNING, DODGING, JUMPING, FALLING, FLYING;
}
public class RandomTest {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(Enums.random(Activity.class) + " ");
        }
    }
}
