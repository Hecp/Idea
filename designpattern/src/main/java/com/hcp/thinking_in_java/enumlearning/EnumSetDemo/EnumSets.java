package com.hcp.thinking_in_java.enumlearning.EnumSetDemo;

import java.util.EnumSet;
import static com.hcp.thinking_in_java.enumlearning.EnumSetDemo.AlarmPoints.*;

/**
 * Thinking in java
 * 19.8 使用EnumSet替代标志
 * Created by Administrator on 2016/3/13.
 */
public class EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoints> points = EnumSet.noneOf(AlarmPoints.class);
        points.add(BATHROOM);
        System.out.println(points);
        points.addAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        System.out.println(points);
        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(EnumSet.of(STAIR1, STAIR2, KITCHEN));
        System.out.println(points);
        points.removeAll(EnumSet.range(OFFICE1, OFFICE4));
        System.out.println(points);
        points = EnumSet.complementOf(points);
        System.out.println(points);
    }

}
