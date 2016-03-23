package com.hcp.designpattern.prototype;

import java.util.Date;

/**
 * 原型模式测试类
 * Created by Administrator on 2016/3/17.
 */
public class Test {
    public static void main(String[] args) {
        Sheep sheep = new Sheep("sheepClone", new Date(222121212));
        System.out.println(sheep);
        System.out.println(sheep.getName());
        System.out.println(sheep.getBirthDate());

        try {
            Sheep sheepClone = (Sheep) sheep.clone();
            System.out.println(sheepClone);
            System.out.println(sheepClone.getName());
            System.out.println(sheepClone.getBirthDate());

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
