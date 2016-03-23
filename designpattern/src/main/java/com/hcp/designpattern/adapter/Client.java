package com.hcp.designpattern.adapter;

/**
 * Adapter Pattern——适配器模式
 * 需要适配器的客户端
 * Created by Administrator on 2016/3/20.
 */
public class Client {

    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();

        Target t = new Adapter(adaptee);

        t.request();
    }

}
