package com.hcp.designpattern.singleton;

/**
 * 利用枚举实现单例模式
 * 防止反射和序列化漏洞
 * Created by Administrator on 2016/3/7.
 */
public enum SingletonEnum {
    INSTANCE;

    public void singletonOpration(){

    }

}
