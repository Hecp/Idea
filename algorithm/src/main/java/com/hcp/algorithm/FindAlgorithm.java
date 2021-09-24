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
//        System.out.println(missingNumber(new int[]{0}));
//        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
//        System.out.println(findNumberIn2DArray(matrix, 2));
//        System.out.println(minArray(new int[]{3,4,5,1,2}));
        System.out.println(firstUniqChar("abaccdeff"));
    }

    /**
     * 找出数组中重复的数字。
     * <p>
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
     * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     * <p>
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
     * <p>
     * 示例 1:
     * <p>
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
     * <p>
     * 示例 1:
     * <p>
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
     * <p>
     * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
     * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     * <p>
     * 示例 1:
     * <p>
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

    /**
     * 二维数组中的查找
     * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * 示例:
     *
     * 现有矩阵 matrix 如下：
     *
     * [
     *   [1,   4,  7, 11, 15],
     *   [2,   5,  8, 12, 19],
     *   [3,   6,  9, 16, 22],
     *   [10, 13, 14, 17, 24],
     *   [18, 21, 23, 26, 30]
     * ]
     * 给定 target = 5，返回 true。
     *
     * 给定 target = 20，返回 false。
     *
     * @param
     * @return 
     * @author hcp
     * @date 2021/9/24 13:53
     */ 
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }

    /**
     * 旋转数组的最小数字
     *
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
     *
     * 示例 1：
     *
     * 输入：[3,4,5,1,2]
     * 输出：1
     *
     * @param
     * @return 
     * @author hcp
     * @date 2021/9/24 14:11
     */ 
    public static int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[left];
    }

    /**
     * 第一个只出现一次的字符
     * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
     *
     * 示例 1:
     *
     * 输入：s = "abaccdeff"
     * 输出：'b'
     *
     * @param
     * @return 
     * @author hcp
     * @date 2021/9/24 15:02
     */ 
    public static char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
