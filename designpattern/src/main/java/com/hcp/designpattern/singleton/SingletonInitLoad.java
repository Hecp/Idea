package com.hcp.designpattern.singleton;

/**
 * 单例模式 —— 饿汉式
 * Created by Administrator on 2016/3/7.
 */
public class SingletonInitLoad {
    // 将对象定义为static，则可以在该类加载时则进行对象的创建和初始化，而且此时是线程安全的。
    private static SingletonInitLoad instance = new SingletonInitLoad();

    private SingletonInitLoad(){

    }

    /**
     * 获取对象
     *
     * @return 实例化对象
     */
    public static SingletonInitLoad getInstance() {
        return instance;
    }
}
