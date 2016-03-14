package com.hcp.designpattern.factory.simplefactory;

import com.hcp.designpattern.factory.factorymethod.Car;

/**
 * 使用简单工厂创建对象
 * 简单工厂当增加新的类时，需要修改工厂类。
 * 该做法违反开闭原则（Open Close Principle）面向扩展开放，面向修改关闭。
 * Created by Administrator on 2016/3/14.
 */
public class Test2 {
    public static void main(String[] args) {
        Car car1 = CarFactory.createCar("奥迪");
        Car car2 = CarFactory.createCar("比亚迪");

        System.out.println("Car1 = " + car1);
        System.out.println("Car2 = " + car2);
    }
}
