package com.hcp.thinking_in_java.enumlearning;

import com.hcp.thinking_in_java.utils.OSExecute;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;
import java.util.TreeSet;

/**
 * Tinking in java
 * values()的神秘之处
 * Created by Administrator on 2016/3/8.
 */
enum Explore {
    HERE, THERE
}

public class Reflection {
    public static Set<String> analyze(Class<?> enumClass) {
        System.out.println("------------- Analyzing " + enumClass + " --------------------");
        System.out.println("Interface:");
        Set<String> methods = null;
        for (Type t : enumClass.getGenericInterfaces()) {
            System.out.println(t);
        }
        System.out.println("Base " + enumClass.getSuperclass());
        System.out.println("Methods:");
        methods = new TreeSet<String>();
        for (Method m : enumClass.getMethods()) {
            methods.add(m.getName());
        }
        System.out.println(methods);
        return methods;
    }

    public static void main(String[] args) {
        System.out.println("中文测试");
        Set<String> exploreMethods = analyze(Explore.class);
        Set<String> enumMethods = analyze(Enum.class);
        System.out.println("Explore.containsAll(Enum)? " + exploreMethods.containsAll(enumMethods));
        System.out.println("Explore.removeAll(Enum): " + exploreMethods.removeAll(enumMethods));
        System.out.println(exploreMethods);
        OSExecute.command("javap Explore");
    }
}
