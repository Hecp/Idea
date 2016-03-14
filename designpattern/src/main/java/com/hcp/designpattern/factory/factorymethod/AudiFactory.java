package com.hcp.designpattern.factory.factorymethod;

/**
 * 工厂方法模式
 * 创建Audi对象工厂
 * Created by Administrator on 2016/3/14.
 */
public class AudiFactory implements CarFactory{

    /**
     * 创建Audi对象
     * @return Audi对象
     */
    public Car createCar() {
        return new Audi();
    }
}
