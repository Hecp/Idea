package com.hcp.jvm.classloader;

/**
 * Created by hcp on 2018/9/2.
 */
public class Demo {
    public static void main(String[] args) {
        int[] list = {82,103,157,209,267,365,368,400,410,308,235,153,99,86,61,32,24,11,8};
        int index = test(list);
        System.out.println("index = " + index + ", num = " + list[index]);
    }

    public static int test(int[] nums){
        int start = 0;
        int end = nums.length;
        int index = (start + end) / 2;
        while (true) {
            if (nums[index - 1] < nums[index] && nums[index] > nums[index + 1]) {
                return index;
            } else if (nums[index - 1] < nums[index] && nums[index] < nums[index + 1]) {
                // 在右边
                start = index;
            } else if (nums[index - 1] > nums[index] && nums[index] > nums[index + 1]) {
                // 在左边
                end = index;
            }
            index = (start + end) / 2;
        }
    }
}
