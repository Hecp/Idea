package com.hcp.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindAlgorithm {
    public static void main(String[] args) {
//        System.out.println(findRepeatNumber(new int[]{2,3,5,3,2}));
//        System.out.println(searchTimesByMap(new int[]{5,7,7,8,8,10}, 7));
//        System.out.println(searchTimesByBinarySearch(new int[]{5,7,7,8,8,10}, 7));
        System.out.println(missingNumber(new int[]{0}));
    }

    /**
     *
     * 找出数组中重复的数字。
     *
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
     * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

     * 示例 1：
     * 输入：
     * [2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     *
     * @param
     * @return
     * @author hcp
     * @date 2021/9/24 10:49
     */
    public static int findRepeatNumber(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        Set<Integer> existsSet = new HashSet<Integer>(nums.length);
        for (int num : nums) {
            if (existsSet.contains(num)) {
                return num;
            } else {
                existsSet.add(num);
            }
        }
        return 0;
    }

    /**
     * 统计一个数字在排序数组中出现的次数。
     *
     * 示例 1:
     *
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: 2
     *
     * @param nums
     * @param target
     * @return
     * @author hcp
     * @date 2021/9/24 11:10
     */
    public static int searchTimesByMap(int[] nums, int target) {
        Map<Integer, Integer> repeatMap = new HashMap<Integer, Integer>(nums.length);
        for (int num : nums) {
            if (repeatMap.containsKey(num)) {
                repeatMap.put(num, repeatMap.get(num) + 1);
            } else {
                repeatMap.put(num, 1);
            }
        }
        if (repeatMap.containsKey(target)) {
            return repeatMap.get(target);
        }
        return 0;
    }

    /**
     * 统计一个数字在排序数组中出现的次数。
     *
     * 示例 1:
     *
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: 2
     *
     * @param nums
     * @param target
     * @return
     * @author hcp
     * @date 2021/9/24 11:10
     */
    public static int searchTimesByBinarySearch(int[] nums, int target) {
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false) - 1;
        if (left <= right && right <= nums.length && nums[left] == target && nums[right] == target) {
            return right - left + 1;
        }
        return 0;
    }

    /**
     * 二分查找法
     *
     * @param
     * @return
     * @author hcp
     * @date 2021/9/24 11:21
     */
    public static int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && (nums[mid] >= target))) {
                right = mid - 1;
                ans = mid;
            } else {
                left = left + 1;
            }
        }
        return ans;
    }

    /**
     * 有序数组自然想到二分查找
     *
     * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
     * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     *
     * 示例 1:
     *
     * 输入: [0,1,3]
     * 输出: 2
     *
     * @param
     * @return
     * @author hcp
     * @date 2021/9/24 13:12
     */
    public static int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
