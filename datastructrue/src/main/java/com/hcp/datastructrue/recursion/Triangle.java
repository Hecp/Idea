package com.hcp.datastructrue.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 三角数字
 * 递归
 * Created by Administrator on 2016/5/9.
 */
public class Triangle {
    static int theNumber;

    public static void main(String[] args) {
        System.out.println("Enter a number: ");
        try {
            theNumber = getInt();
            int theAnswer = triangle(theNumber);
            int factorialNum = factorial(theNumber);
            System.out.println("Triangle: " + theAnswer);
            System.out.println("Factorial: " + factorialNum);
            imgOption();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void imgOption(){
        String content="<img border=\"1\" src=\"/ewebeditor/sysimage/icon16/doc.gif\"><a target=\"_blank\" href=\"/ewebeditor/uploadfile/大型巡查通知2.docx\">大型巡查通知2.docx</a>";

        String regex="<img\\s*([\\w]*=(\"|\')([^\"\']*)(\"|\')\\s*)*>";

        System.out.println(content.replaceAll(regex, ""));
    }

    /**
     * 递归获取第n项三角数字
     *
     * 递归方法的特征：
     * 1、调用自身
     * 2、当它调用自身的时候，它这样做是为了解决更小的问题
     * 3、存在某个足够简单的问题的层次，在这一层算法不需要调用自己就可以直接解答，且返回结果
     *
     * @param n 第n项
     * @return 第n项三角数字
     */
    public static int triangle(int n){
        /*System.out.println("Entering n = " + n);*/
        if(n == 1){
            /*System.out.println("Returning 1");*/
            return 1;
        }/*else{*/
        int temp = n + triangle(n - 1);
        /*System.out.println("Returning " + temp);*/
        return temp;
       /* }*/
    }

    /**
     * 递归获得n的阶乘
     * @param n 第n项
     * @return n的阶乘
     */
    public static int factorial(int n){
        if (n == 0) {
            return 1;
        }
        return (n * factorial(n - 1));
    }


    /**
     * 将控制台输入字符串转换为int
     * @return 字符串转换后的int
     * @throws IOException
     */
    private static int getInt() throws IOException {
        String s = getString();
        return Integer.parseInt(s);
    }

    /**
     * 获得控制台输入，并返回输入字符串
     * @return 控制台输入字符串
     * @throws IOException
     */
    private static String getString() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        return bufferedReader.readLine();
    }
}
