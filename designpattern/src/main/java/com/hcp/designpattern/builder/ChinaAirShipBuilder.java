package com.hcp.designpattern.builder;

/**
 * 中国神舟飞船
 * Created by Administrator on 2016/3/17.
 */
public class ChinaAirShipBuilder implements AirShipBuilder {

    public OrbitalModule buildOrbitalModule() {
        System.out.println("构建轨道舱");
        return new OrbitalModule();
    }

    public Engine buildEngine() {
        System.out.println("构建引擎");
        return new Engine();
    }

    public EscapePod buildEscapePod() {
        System.out.println("构造逃生舱");
        return new EscapePod();
    }
}
