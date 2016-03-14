package com.hcp.designpattern.factory.abstractorfactory;

/**
 * 抽象工厂模式
 * Created by Administrator on 2016/3/14.
 */
public interface Tyre {
    void revolve();
}

class LuxuyTyre implements Tyre {

    public void revolve() {
        System.out.println("磨损小！");
    }
}

class LowTyre implements Tyre {

    public void revolve() {
        System.out.println("磨损大！");
    }
}
