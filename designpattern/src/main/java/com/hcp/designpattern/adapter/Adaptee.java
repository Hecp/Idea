package com.hcp.designpattern.adapter;

/**
 * Adapter Pattern——适配器模式
 * 被适配类型（需要用适配器转换的源对象）
 * Created by Administrator on 2016/3/20.
 */
public class Adaptee {

    public void doSomething(){
        System.out.println("做自己的事！");
    }
}
