package com.hcp.designpattern.factory.abstractorfactory;

/**
 * 抽象工厂模式
 * Created by Administrator on 2016/3/14.
 */
public interface CarFactory {
    Engine createEngine();

    Seat createSeat();

    Tyre createTyre();
}
