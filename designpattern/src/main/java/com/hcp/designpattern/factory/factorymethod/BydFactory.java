package com.hcp.designpattern.factory.factorymethod;

/**
 * 工厂方法模式
 * Byd工厂类
 * Created by Administrator on 2016/3/14.
 */
public class BydFactory implements CarFactory {

    /**
     * 创建Byd对象
     * @return Byd对象
     */
    public Car createCar() {
        return new Byd();
    }
}
