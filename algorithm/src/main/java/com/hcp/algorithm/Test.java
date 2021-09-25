package com.hcp.algorithm;

/**
 * Created by hcp on 2018/7/25.
 */
public class Test {
    public static void main(String[] args) {
//        int[] nums = {2, 7, 11, 15};
//        twoSum(nums, 9);
        test(10000);
        test1(10000);
    }

    public static void twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.println(nums[i] + ", " + nums[j]);
                }
            }
        }
    }
    
    public static void test(int i) {
        for (int j = 1; j <= i; j++) {
            System.out.println(j);
        }
    }


    /**
     * java.lang.StackOverflowError 10000次递归调用已超过方法调用最大深度
     * @param i
     */
    public static void test1(int i) {
        if (i > 0) {
            test1(i - 1);
            System.out.println("test1 = " + i);
        }
    }
}
