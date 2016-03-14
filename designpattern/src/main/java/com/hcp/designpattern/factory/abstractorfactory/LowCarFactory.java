package com.hcp.designpattern.factory.abstractorfactory;

/**
 * 抽象工厂模式
 * Created by Administrator on 2016/3/14.
 */
public class LowCarFactory implements CarFactory{
    public Engine createEngine() {
        return new LowEngine();
    }

    public Seat createSeat() {
        return new LowSeat();
    }

    public Tyre createTyre() {
        return new LowTyre();
    }
}
