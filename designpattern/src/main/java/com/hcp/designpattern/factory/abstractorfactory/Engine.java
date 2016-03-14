package com.hcp.designpattern.factory.abstractorfactory;

/**
 * 抽象工厂模式
 * Created by Administrator on 2016/3/14.
 */
public interface Engine {
    void run();

    void start();
}

class LuxucyEngine implements Engine {

    public void run() {
        System.out.println("马力大！");
    }

    public void start() {
        System.out.println("启动快！");
    }
}

class LowEngine implements Engine{

    public void run() {
        System.out.println("马力小！");
    }

    public void start() {
        System.out.println("启动慢！");
    }
}
