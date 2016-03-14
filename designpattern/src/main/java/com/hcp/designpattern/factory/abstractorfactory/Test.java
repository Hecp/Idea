package com.hcp.designpattern.factory.abstractorfactory;

/**
 * 抽象工厂模式
 * Created by Administrator on 2016/3/14.
 */
public class Test {
    public static void main(String[] args) {
        CarFactory carFactory1 = new LuxuyCarFactory();
        Engine engine = carFactory1.createEngine();
        engine.start();
        engine.run();
    }
}
