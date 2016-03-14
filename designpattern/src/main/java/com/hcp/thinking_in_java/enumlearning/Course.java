package com.hcp.thinking_in_java.enumlearning;

/**
 * Think in java
 * 19.7 使用接口组织继承
 * Created by Administrator on 2016/3/13.
 */
public enum Course {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);

    private Food[] values;
    Course(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }

    public Food randomSelection(){
        return Enums.random(values);
    }
}
