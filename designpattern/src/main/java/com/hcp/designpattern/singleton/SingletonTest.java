package com.hcp.designpattern.singleton;

/**
 * 单例模式测试类
 * Created by Administrator on 2016/3/7.
 */
public class SingletonTest {

    public static void main(String[] args) {
        TestSingletonInitLoad();
        TestSingletonLazyLoad();
        TestSingletonInnerClass();
        TestSingletonEnum();
    }

    public static void TestSingletonInitLoad() {
        SingletonInitLoad singletonInitLoad1 = SingletonInitLoad.getInstance();
        SingletonInitLoad singletonInitLoad2 = SingletonInitLoad.getInstance();
        System.out.println("singletonInitLoad1 = " + singletonInitLoad1);
        System.out.println("singletonInitLoad2 = " + singletonInitLoad2);
    }

    public static void TestSingletonLazyLoad(){
        SingletonLazyLoad singletonLazyLoad1 = SingletonLazyLoad.getInstance();
        SingletonLazyLoad singletonLazyLoad2 = SingletonLazyLoad.getInstance();
        System.out.println(singletonLazyLoad1 == singletonLazyLoad2);
    }

    public static void TestSingletonInnerClass(){
        SingletonInnerClass singletonInnerClass1 = SingletonInnerClass.getInstance();
        SingletonInnerClass singletonInnerClass2 = SingletonInnerClass.getInstance();
        System.out.println(singletonInnerClass1 == singletonInnerClass2);
    }

    public static void TestSingletonEnum(){
        SingletonEnum singletonEnum1 = SingletonEnum.INSTANCE;
        SingletonEnum singletonEnum2 = SingletonEnum.INSTANCE;
        System.out.println(singletonEnum1 == singletonEnum2);
    }
}
