package com.hcp.thinking_in_java.enumlearning;

/**
 * Thinking in java
 * values()的神秘之处
 * Created by Administrator on 2016/3/9.
 */
enum Search{
    HITHER, YON
}
public class UpcastEnum {
    public static void main(String[] args) {
        Search[] values = Search.values();
        Enum e = Search.HITHER;
        for (Enum en : e.getClass().getEnumConstants()) {
            System.out.println(en);
        }
    }
}
