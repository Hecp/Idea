package com.hcp.designpattern.factory.factorymethod;

/**
 * 工厂方法模式
 * 工厂方法模式当增加新的类型时，需要不断的增加类和该类的对象创建工厂，代码复杂度比较高。
 * Created by Administrator on 2016/3/14.
 */
public class Test {
    public static void main(String[] args) {
        Car car1 = new AudiFactory().createCar();
        Car car2 = new BydFactory().createCar();

        System.out.println("Car1 = " + car1);
        System.out.println("Car2 = " + car2);
    }
}
