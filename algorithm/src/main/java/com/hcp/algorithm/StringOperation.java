package com.hcp.algorithm;

public class StringOperation {
    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
        System.out.println(reverseLeftWordsBySubString("abcage", 2));
        System.out.println(reverseLeftWordsByStringBuilder("abcage", 2));
    }

    /**
     * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
     * 
     * @param oldString 
     * @return 
     * @author hcp
     * @date 2021/9/24 10:37
     */ 
    public static String replaceSpace(String oldString) {
        int size = oldString.length();
        char[] replaceCharArray = new char[size * 3];
        int index = 0;
        for (int i = 0; i < size; i++) {
            char c = oldString.charAt(i);
            if (c == ' ') {
                replaceCharArray[index++] = '%';
                replaceCharArray[index++] = '2';
                replaceCharArray[index++] = '0';
            } else {
                replaceCharArray[index++] = c;
            }
        }
        return new String(replaceCharArray, 0, index);
    }

    /**
     * 左旋转字符串-通过String.substring();
     *
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
     * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     *
     * @param 
     * @return 
     * @author hcp
     * @date 2021/9/24 10:37
     */ 
    public static String reverseLeftWordsBySubString(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }

    /**
     * 左旋转字符串-通过StringBuilder拼接
     *
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
     * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     *
     * @param
     * @return
     * @author hcp
     * @date 2021/9/24 10:37
     */
    public static String reverseLeftWordsByStringBuilder(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder(s.length());
        for (int i = n; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }
}
