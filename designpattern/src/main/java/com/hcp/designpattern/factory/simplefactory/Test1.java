package com.hcp.designpattern.factory.simplefactory;

import com.hcp.designpattern.factory.factorymethod.Audi;
import com.hcp.designpattern.factory.factorymethod.Byd;
import com.hcp.designpattern.factory.factorymethod.Car;

/**
 * 没有工厂模式的情况
 * Created by Administrator on 2016/3/14.
 */
public class Test1 {
    public static void main(String[] args) {
        Car car1 = new Audi();
        Car car2 = new Byd();
        System.out.println("Car1 = " + car1);
        System.out.println("Car2 = " + car2);
    }
}
