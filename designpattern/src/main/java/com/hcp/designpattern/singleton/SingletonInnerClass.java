package com.hcp.designpattern.singleton;

/**
 * 通过静态内部类实现单例模式
 * Created by Administrator on 2016/3/7.
 */
public class SingletonInnerClass {

    private SingletonInnerClass(){

    }

    public static SingletonInnerClass getInstance(){
        return SingletonInnerClassInstance.instance;
    }

    private static class SingletonInnerClassInstance {
        private static SingletonInnerClass instance = new SingletonInnerClass();

    }
}
