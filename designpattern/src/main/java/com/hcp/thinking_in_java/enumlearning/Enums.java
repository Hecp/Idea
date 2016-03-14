package com.hcp.thinking_in_java.enumlearning;

import java.util.Random;

/**
 * Thinking in java
 * 19.6 随机选取
 * Created by Administrator on 2016/3/9.
 */
public class Enums {
    private static Random random = new Random(47);

    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[random.nextInt(values.length)];
    }

}
