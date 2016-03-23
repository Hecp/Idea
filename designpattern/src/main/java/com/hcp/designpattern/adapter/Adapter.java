package com.hcp.designpattern.adapter;

/**
 * Adapter Pattern——适配器模式
 * 适配器类
 * 实现方式：1、通过继承被适配对象（源对象）实现——类适配器；
 *           2、通过组合的方式（包含被适配类的对象）实现。
 * Created by Administrator on 2016/3/20.
 */
public class Adapter implements Target{

    /**
     * 通过组合的方式（包含被适配类的对象）实现适配器模式
     */
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void request() {
        adaptee.doSomething();
    }
}
