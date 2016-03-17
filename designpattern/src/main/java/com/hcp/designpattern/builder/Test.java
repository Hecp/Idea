package com.hcp.designpattern.builder;

/**
 * 构建者模式
 * 测试类
 * Created by Administrator on 2016/3/17.
 */
public class Test {
    public static void main(String[] args) {
        AirShipDirector director = new ChinaAirShipDirector(new ChinaAirShipBuilder());
        AirShip airShip = director.directAirShip();
        System.out.println(airShip.getEngine());
    }
}
