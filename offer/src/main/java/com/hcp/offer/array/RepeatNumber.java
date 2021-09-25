package com.hcp.offer.array;

/**
 * 找出数组中重复的数字
 * 在一个长度为n的数组里的所有数字都在0~n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * 例如：如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，那么对应的输出是重复的数字2或者3。
 * Created by hcp on 2019/3/14.
 */
public class RepeatNumber {

    static int[] ints = {3,2,1,0,2,5,3};

    public static void main(String[] args) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length - i; j++) {
                if (ints[i] == ints[j]) {
                    System.out.println("第" + i +"个数字等于第" + j + "个数字，都是" + ints[i]);
                    break;
                }
            }
        }
    }
}
