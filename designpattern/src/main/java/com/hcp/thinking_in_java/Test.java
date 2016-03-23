package com.hcp.thinking_in_java;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Random;

/**
 * 别名现象
 * Created by Administrator on 2016/3/18.
 */
class Demo{
    int num;
}
public class Test implements Serializable{
    public static void main(String[] args) {
        /*Demo demo = new Demo();
        demo.num = 1;
        System.out.println(demo.num);


        Demo demo1 = new Demo();
        demo1.num = 2;
        System.out.println(demo1.num);

        demo = demo1;
        System.out.println(demo);
        System.out.println(demo1);
        System.out.println(demo.num);

        new Test().demoTest(demo);
        System.out.println(demo);
        System.out.println(demo.num);*/
        randomReflect();
        randomTest();
    }

    public void demoTest(Demo demo){
        demo.num = 3;
    }


    public static void randomReflect(){
        try {
            Class clazz = Class.forName("java.util.Random");
            System.out.println(clazz.getConstructor());
            System.out.println(clazz.getAnnotations());
            Field[] fields = clazz.getFields();
            for (Field field : fields) {
                System.out.println("field——" + field.getName());
            }
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                System.out.println("method——" + method.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void randomTest(){
        Random random = new Random(47);
        Random random1 = new Random(47);
        System.out.println("random" + random.nextInt());
        System.out.println("random1" + random1.nextInt());
        System.out.println(random.nextInt() == random1.nextInt());
    }
}
