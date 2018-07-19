package com.hcp.jvm.oom;

/**
 * VM args: -Xss128K
 * Created by hcp on 2018/6/9.
 */
public class JVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength ++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JVMStackSOF oom = new JVMStackSOF();
        try{
            oom.stackLeak();
        }catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
