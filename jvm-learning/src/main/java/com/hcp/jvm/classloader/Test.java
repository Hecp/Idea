package com.hcp.jvm.classloader;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hcp on 2018/9/2.
 */
public class Test {

    public static void main(String[] args) {
        Map<String,  String> map = new HashMap<>();
        map.put("hello", "你好");
        map.put("how are you?", "你好吗？");
        System.out.println(map.get("hello"));
        System.out.println(map.get("how are you?"));
    }

}
