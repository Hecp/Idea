package com.hcp.designpattern.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 测试反射和反序列化破解单例模式
 * Created by Administrator on 2016/3/9.
 */
public class Client {

    public static void main(String[] args) {
        SingletonLazyLoad singletonLazyLoad1 = SingletonLazyLoad.getInstance();
        SingletonLazyLoad singletonLazyLoad2 = SingletonLazyLoad.getInstance();

        System.out.println(singletonLazyLoad1);
        System.out.println(singletonLazyLoad2);

        /*reflectTestSingleton();*/
        serializeTestSingleton(singletonLazyLoad1);
    }

    /**
     * 利用反射破解单例模式
     */
    public static void reflectTestSingleton() {


        try {
            Class<SingletonLazyLoad> clazz = (Class<SingletonLazyLoad>) Class.forName("com.hcp.designpattern.singleton.SingletonLazyLoad");
            Constructor<SingletonLazyLoad> constructor = clazz.getDeclaredConstructor(null);
            /* 1、尽管SingletonLazyLoad的构造方法是private，但是通过调用setAccessible(true)还是可以访问，从而进行SingletonLazyLoad对象的创建
                2、该反射漏洞可以通过将单例模式类的默认无参构造方法中判断是否已存在该类对象，如果存在则抛出异常（具体请见SingletonLazyLoad类代码）。
             */
            constructor.setAccessible(true);
            SingletonLazyLoad singletonlazyLoad3 = constructor.newInstance();
            SingletonLazyLoad singletonlazyLoad4 = constructor.newInstance();

            System.out.println(singletonlazyLoad3);
            System.out.println(singletonlazyLoad4);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 利用序列化破解单例模式
     * @param obj 序列化对象
     */
    public static void serializeTestSingleton(SingletonLazyLoad obj) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            /*将obj对象序列化后写入test.txt文档*/
            fos = new FileOutputStream("test.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);

            /*将test.txt文件中的序列化后的内容反序列化成SingletonLazyLoad的对象*/
            ois = new ObjectInputStream(new FileInputStream("test.txt"));
            SingletonLazyLoad singletonLazyLoad3 = (SingletonLazyLoad) ois.readObject();
            System.out.println(singletonLazyLoad3);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                oos.close();
                fos.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
