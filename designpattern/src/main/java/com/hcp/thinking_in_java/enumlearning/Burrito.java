package com.hcp.thinking_in_java.enumlearning;

import static com.hcp.thinking_in_java.enumlearning.Spiciness.*;
/**
 * Thinking in java
 * 将enum用于静态导入
 * Created by Administrator on 2016/3/8.
 */
public class Burrito {
    Spiciness degree;
    public Burrito(Spiciness degree){
        this.degree = degree;
    }

    public String toString(){
        return "Burrito is " + degree;
    }

    public static void main(String[] args) {
        System.out.println(new Burrito(NOT));
        System.out.println(new Burrito(MEDIUM));
        System.out.println(new Burrito(HOT));
    }
}
