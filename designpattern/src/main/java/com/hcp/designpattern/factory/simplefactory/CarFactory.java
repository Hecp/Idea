package com.hcp.designpattern.factory.simplefactory;


/**
 * 简单工厂类
 * Created by Administrator on 2016/3/14.
 */
public class CarFactory {
    /**
     * 根据对象类型创建Car实例类的具体对象
     * @param type 对象类型
     * @return Car实例类的具体对象
     */
    public static Car createCar(String type){
        /*简单工厂当增加新的类时，需要在此处不断增加类型判断和创建对象代码。
        该做法违反开闭原则（Open Close Principle）面向扩展开放，面向修改关闭。*/
        if("奥迪".equals(type)){
            return new Audi();
        }else if("比亚迪".equals(type)){
            return new Byd();
        }else{
            return null;
        }
    }
}
