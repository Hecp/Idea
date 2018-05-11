package com.hcp.datastructrue.stack;

import java.io.*;

/**
 * 利用栈实现字符串反转测试
 * Created by hcp on 2016/6/18.
 */
public class ReverserApp {

    public static void main(String[] args) {
        System.out.println("Please Enter a string: ");
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String str = null;
        try {
            str = String.valueOf(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!"".equals(str)) {
            Reverser reverser = new Reverser(str);
            String output = reverser.doReverse();
            System.out.println(output);
        }
    }
}
