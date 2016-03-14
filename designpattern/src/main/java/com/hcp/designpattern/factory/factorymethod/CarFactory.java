package com.hcp.designpattern.factory.factorymethod;

/**
 * 工厂方法模式
 * 创建Car接口
 * Created by Administrator on 2016/3/14.
 */
public interface CarFactory {
    /**
     * 创建Car对象
     * @return Car对象
     */
    Car createCar();
}
