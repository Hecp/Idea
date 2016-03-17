package com.hcp.designpattern.factory.abstractorfactory;

/**
 * 抽象工厂模式
 * Created by Administrator on 2016/3/14.
 */
public class Test {
    public static void main(String[] args) {
        //创建高级汽车工厂
        CarFactory carFactory1 = new LuxuyCarFactory();

        //创建高级汽车引擎
        Engine engine1 = carFactory1.createEngine();
        engine1.start();
        engine1.run();

        //创建高级汽车座椅
        Seat seat1 = carFactory1.createSeat();
        seat1.massage();;

        //创建高级汽车轮胎
        Tyre tyre1 = carFactory1.createTyre();
        tyre1.revolve();

        //创建低端汽车工厂
        CarFactory carFactory2 = new LowCarFactory();

        //创建低端汽车引擎
        Engine engine2 = carFactory2.createEngine();
        engine2.start();
        engine2.run();

        //创建低端汽车座椅
        Seat seat2 = carFactory2.createSeat();
        seat2.massage();

        //创建低端汽车轮胎
        Tyre tyre2 = carFactory2.createTyre();
        tyre2.revolve();

    }
}
