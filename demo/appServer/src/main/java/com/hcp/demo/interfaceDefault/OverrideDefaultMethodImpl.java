package com.hcp.demo.interfaceDefault;

/**
 * 默认方法demo——重写default方法
 * Created by hcp on 2017/7/1.
 */
public class OverrideDefaultMethodImpl implements InterfaceDefaultMethod {

    @Override
    public String notRequired() {
        return "Override implementation";
    }

    @Override
    public int getNum() {
        return 10;
    }



    @Override
    public void printStr(String str) {
        System.out.println(str);
    }
}
