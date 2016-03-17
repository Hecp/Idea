package com.hcp.designpattern.builder;

/**
 * Created by Administrator on 2016/3/17.
 */
public class ChinaAirShipDirector implements AirShipDirector {

    private AirShipBuilder builder;

    public ChinaAirShipDirector(AirShipBuilder builder){
        this.builder = builder;
    }

    /**
     * 组装飞船对象
     *
     * @return 飞船对象
     */
    public AirShip directAirShip() {
        OrbitalModule orbitalModule = builder.buildOrbitalModule();
        Engine engine = builder.buildEngine();
        EscapePod escapePod = builder.buildEscapePod();

        AirShip airShip = new AirShip();
        airShip.setOrbitalModule(orbitalModule);
        airShip.setEngine(engine);
        airShip.setEscapePod(escapePod);
        return airShip;
    }
}
