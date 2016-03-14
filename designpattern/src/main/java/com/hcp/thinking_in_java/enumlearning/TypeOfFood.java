package com.hcp.thinking_in_java.enumlearning;

import static com.hcp.thinking_in_java.enumlearning.Food.*;
/**
 * Think in java
 * 19.7 使用接口组织继承
 * Created by Administrator on 2016/3/13.
 */
public class TypeOfFood {
    public static void main(String[] args) {
        Food food = Appetizer.SALAD;
        food = MainCourse.LASAGNE;
        food = Dessert.GELATO;
        food = Coffee.CAPPUCCION;
    }
}
