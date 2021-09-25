package com.hcp.demo.interfaceDefault;

/**
 * 接口default方法测试
 * Created by hcp on 2017/7/1.
 */
public class Test {
    public static void main(String[] args) {
        InterfaceDefaultMethodImpl defaultMethod = new InterfaceDefaultMethodImpl();
        defaultMethod.printStr(defaultMethod.notRequired() + " " + defaultMethod.getNum() + " " +
                InterfaceDefaultMethod.getNum2());

        OverrideDefaultMethodImpl overrideDefaultMethod = new OverrideDefaultMethodImpl();
        overrideDefaultMethod.printStr(overrideDefaultMethod.notRequired() + " " + overrideDefaultMethod.getNum() + " " +
                InterfaceDefaultMethod.getNum2());
    }
}
