package com.hcp.demo.interfaceDefault;

/**
 * 接口默认方法demo
 * Created by hcp on 2017/7/1.
 */
public interface InterfaceDefaultMethod {
    default String notRequired(){
        return "Default implementation";
    }

    default int getNum(){
        return 0;
    }

    static int getNum2(){
        return 1;
    }

    void printStr(String str);
}
