package com.hcp.thinking_in_java.enumlearning;

/**
 * Thinking in java
 * 19.2向enum中添加新方法
 * Created by Administrator on 2016/3/8.
 */
public enum OzWitch {
    /**
     * java要求必须先定义enum实例。如果在定义enum实例之前定义了任何属性或方法，那么在编译时就会报错。
     * 列出这些实例时，系统会自动添加public static final修饰，无需程序员显式添加，所以enum是单例和线程安全。
     */
    WEST("Miss Gulch, aka the Wicked Witch of the West."),
    NORTH("Glinda, the Good Witch of the North."),
    EAST("Wicked Witch of the East, weaer of the Ruby " +
            "Slippers, crushed by Dorothy's house."),
    SOUTH("Good by inference, but missing.");


    private String description;

    /**
     * 枚举构造方法默认的访问修饰符即是private（也只能是private），我们只能在enum定义的内部使用其构造方法创建实例。
     * 一旦enum的定义结束，编译器就不允许我们再使用其构造方法来创建任何实例。
     * @param description 枚举实例描述信息
     */
    OzWitch(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;
    }

    public static void main(String[] args) {
        for (OzWitch witch : OzWitch.values()) {
            System.out.println(witch + "：" + witch.getDescription());
        }
    }

}
