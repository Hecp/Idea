package com.hcp.jvm.oom;

import javassist.*;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by hcp on 2018/8/9.
 */
public class JavaMethodOOM {
    public static void main(String[] args) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        while (true) {
            // ClassPool CtClass对象的容器
            ClassPool pool = ClassPool.getDefault();
            // 通过ClassPool生成一个public新类Employee
            CtClass ctClass = pool.makeClass("com.hcp.jvm.oom.Employee");

            // 创建name字段
            CtField nameFiled = new CtField(pool.getCtClass("java.lang.String"), "name", ctClass);
            // name字段设置为private
            nameFiled.setModifiers(Modifier.PRIVATE);
            ctClass.addField(nameFiled);

            // 创建age字段
            CtField ageFiled = new CtField(pool.getCtClass("int"), "age", ctClass);
            // age字段设置为private
            ageFiled.setModifiers(Modifier.PRIVATE);
            ctClass.addField(ageFiled);

            // 创建gender字段
            CtField genderFiled = new CtField(pool.getCtClass("int"), "gender", ctClass);
            // gender字段设置为private
            genderFiled.setModifiers(Modifier.PRIVATE);
            ctClass.addField(genderFiled);

            // 添加Getter和Setter方法
            ctClass.addMethod(CtNewMethod.getter("getName", nameFiled));
            ctClass.addMethod(CtNewMethod.setter("setName", nameFiled));
            ctClass.addMethod(CtNewMethod.getter("getAge", ageFiled));
            ctClass.addMethod(CtNewMethod.setter("setAge", ageFiled));
            ctClass.addMethod(CtNewMethod.getter("getGender", genderFiled));
            ctClass.addMethod(CtNewMethod.setter("setGender", genderFiled));

            // 添加构造函数
            CtConstructor ctConstructor = new CtConstructor(new CtClass[]{}, ctClass);
            ctConstructor.setBody("{\n" + "name = \"Jack\";\n" + "age = 24;\n" + "gender = 1;\n}");
            ctClass.addConstructor(ctConstructor);

            CtMethod ctMethod = new CtMethod(CtClass.voidType, "printInfo", new CtClass[]{}, ctClass);
            ctMethod.setModifiers(Modifier.PUBLIC);
            String buffer2 = "{\n" + "System.out.println(\"begin!\");\n" +
                    "System.out.println(\"name = \"+name);\n" + "System.out.println(\"age = \"+age);\n" +
                    "System.out.println(\"gender = \"+gender);\n" + "System.out.println(\"end!\");\n" + "}";
            ctMethod.setBody(buffer2);
            ctClass.addMethod(ctMethod);

            Class<?> clazz = ctClass.toClass();
            Object obj = clazz.newInstance();
            obj.getClass().getMethod("printInfo", new Class[]{}).invoke(obj, new Object[]{});
        }
    }
}
