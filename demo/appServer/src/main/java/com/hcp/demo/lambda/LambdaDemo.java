package com.hcp.demo.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcp on 2017/7/1.
 */
public class LambdaDemo {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<String>();
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");
        stringList.add("D");
        stringList.add("E");
        for (String str : stringList) {
            System.out.println(str);
        }
        stringList.forEach(str -> System.out.println(str));
    }
}
