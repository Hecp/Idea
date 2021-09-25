package com.hcp.demo.interfaceDefault;

/**
 * 默认方法demo——不重写default方法
 * Created by hcp on 2017/7/1.
 */
public class InterfaceDefaultMethodImpl implements InterfaceDefaultMethod {
    @Override
    public void printStr(String str) {
        System.out.println(str);
    }
}
