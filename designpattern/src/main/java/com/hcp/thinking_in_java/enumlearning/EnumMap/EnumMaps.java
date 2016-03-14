package com.hcp.thinking_in_java.enumlearning.EnumMap;

import com.hcp.thinking_in_java.enumlearning.EnumSetDemo.AlarmPoints;

import static com.hcp.thinking_in_java.enumlearning.EnumSetDemo.AlarmPoints.*;

import java.util.EnumMap;
import java.util.Map;

/**
 * Thinking in java
 * 19.9 使用EnumMap
 * 与EnumSet一样，enum实例定义时的次序决定了其在EnumMap中的顺序。
 * Created by Administrator on 2016/3/13.
 */

interface Command{
    void action();
}
public class EnumMaps {
    public static void main(String[] args) {
        EnumMap<AlarmPoints, Command> em = new EnumMap<AlarmPoints, Command>(AlarmPoints.class);
        em.put(KITCHEN, new Command() {
            public void action() {
                System.out.println("Kitchen fire!");
            }
        });

        em.put(BATHROOM, new Command() {
            public void action() {
                System.out.println("Bathroom alert!");
            }
        });

        for (Map.Entry<AlarmPoints, Command> e : em.entrySet()) {
            System.out.println(e.getKey() + "：");
            e.getValue().action();
        }
        /*enum的每个实例作为一个键，总是存在的。但是，如果你没有为这个键调用put()方法来存入相应的值的话，
        其对应的值就是null，故以下代码出现NullPointException。*/
        em.get(UTILITY).action();
    }
}
