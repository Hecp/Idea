package com.hcp.designpattern.singleton;

import java.io.Serializable;

/**
 * 单例模式 —— 懒加载
 * Created by Administrator on 2016/3/7.
 */
public class SingletonLazyLoad implements Serializable {
    // 类加载时不进行instance对象的实例化。
    private static SingletonLazyLoad instance;

    private SingletonLazyLoad(){
        if (instance != null){
            throw new RuntimeException("singleton，已存在该类对象，不能再进行创建！");
        }
    }

    /**
     * 只有在调用instance对象时才进行对象的创建和初始化，以节省类加载时的资源。
     * 但此时该方法synchronized，并发时效率比较低。
     *
     * @return SingletonLazyLoad 对象
     */
    public static synchronized SingletonLazyLoad getInstance() {
        if (instance == null) {
            instance = new SingletonLazyLoad();
        }
        return instance;
    }

    /**
     * 修复利用序列化破解单例模式漏洞
     * @return 当前单例对象
     */
    private Object readResolve(){
        return instance;
    }
}
