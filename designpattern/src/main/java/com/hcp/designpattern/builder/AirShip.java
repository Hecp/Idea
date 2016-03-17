package com.hcp.designpattern.builder;

/**
 * 构建者模式
 * 测试对象
 * Created by Administrator on 2016/3/17.
 */
public class AirShip {
    private OrbitalModule orbitalModule; //轨道舱
    private Engine engine; //引擎
    private EscapePod escapePod; //逃生舱

    public OrbitalModule getOrbitalModule() {
        return orbitalModule;
    }

    public void setOrbitalModule(OrbitalModule orbitalModule) {
        this.orbitalModule = orbitalModule;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public EscapePod getEscapePod() {
        return escapePod;
    }

    public void setEscapePod(EscapePod escapePod) {
        this.escapePod = escapePod;
    }
}
