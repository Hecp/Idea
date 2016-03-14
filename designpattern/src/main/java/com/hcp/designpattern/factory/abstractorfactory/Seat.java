package com.hcp.designpattern.factory.abstractorfactory;

/**
 * 抽象工厂模式
 * Created by Administrator on 2016/3/14.
 */
public interface Seat {
    void massage();
}

class LuxuySeat implements Seat {

    public void massage() {
        System.out.println("可以自动按摩！");
    }
}

class LowSeat implements Seat{

    public void massage() {
        System.out.println("不能按摩！");
    }
}
