package com.hcp.designpattern.builder;

/**
 * 创建接口
 * Created by Administrator on 2016/3/17.
 */
public interface AirShipBuilder {
    /**
     * 构建轨道舱
     *
     * @return 轨道舱对象
     */
    OrbitalModule buildOrbitalModule();

    /**
     * 构建引擎
     *
     * @return 引擎对象
     */
    Engine buildEngine();

    /**
     * 构建逃生舱
     *
     * @return 逃生舱对象
     */
    EscapePod buildEscapePod();
}
