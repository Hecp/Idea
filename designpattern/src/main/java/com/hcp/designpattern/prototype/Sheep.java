package com.hcp.designpattern.prototype;

import java.util.Date;

/**
 * clone——原型模式
 * Created by Administrator on 2016/3/17.
 */
public class Sheep implements Cloneable{
    private String name;

    private Date birthDate;

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Sheep(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    /**
     * 重写clone方法
     * @return clone对象
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        //直接调用Object类的clone()方法
        Object obj = super.clone();
        return obj;
    }
}
