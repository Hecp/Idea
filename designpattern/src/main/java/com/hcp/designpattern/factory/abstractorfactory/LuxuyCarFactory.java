package com.hcp.designpattern.factory.abstractorfactory;

/**
 * 抽象工厂模式
 * Created by Administrator on 2016/3/14.
 */
public class LuxuyCarFactory implements CarFactory{
    public Engine createEngine() {
        return new LuxucyEngine();
    }

    public Seat createSeat() {
        return new LuxuySeat();
    }

    public Tyre createTyre() {
        return new LuxuyTyre();
    }
}
