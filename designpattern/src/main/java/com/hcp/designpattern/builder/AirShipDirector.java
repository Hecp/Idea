package com.hcp.designpattern.builder;

/**
 * 飞船组装接口
 * Created by Administrator on 2016/3/17.
 */
public interface AirShipDirector {
    /**
     * 组装飞船对象
     *
     * @return 飞船对象
     */
    AirShip directAirShip();
}
