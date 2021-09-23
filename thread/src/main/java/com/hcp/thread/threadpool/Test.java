package com.hcp.thread.threadpool;

/**
 * Created by hcp on 2019/7/19.
 */
public class Test {

    public static Test test = new Test();

    static {
        System.out.println("静态代码块1");
    }

    public static Test test1 = new Test("有参构造方法");
    {
        System.out.println("方法构造器1");
    }
    static {
        System.out.println("静态代码块2");
    }

    {
        System.out.println("方法构造器2");
    }

    public Test() {
        this("无参构造方法 to 有参构造方法");
        System.out.println("无参构造方法");
    }

    public Test(String s) {
        System.out.println(s);
    }

    {
        System.out.println("方法构造器3");
    }
    public static void main(String[] args) {
        Test test = new Test();
    }
}
