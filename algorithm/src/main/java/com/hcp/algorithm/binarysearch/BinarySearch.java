package com.hcp.algorithm.binarysearch;


/**
 * Created by hcp on 2018/5/10.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] ints = {1, 2, 4, 5, 3, 9, 0, 6, 18, 11};
        binarySearch(ints, 6);
        binarySearchByRecursive(ints, 6, 0, ints.length - 1);
    }

    /**
     * 二分查找法（非递归）
     *
     * @author hcp(hepingzhige13@163.com)
     * @date 2018/5/11 20:13
     */
    public static void binarySearch(int[] ints, int x) {
        int start = 0;
        int end = ints.length - 1;

        while (start <= end) {
            // 用中间元素值与查找值对比，如果等于则直接返回；
            // 如果小于，则说明查找值在右边数组，则将开始值赋值为中间元素下标+1；
            // 如果大于，则说明查找值在左边数组，则将结束值赋值为中间元素下标-1。
            int mid = (start + end) / 2;
            if (ints[mid] == x) {
                System.out.println("binary search, index = " + mid + ", value = " + ints[mid]);
                return;
            } else if (ints[mid] < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }

    /**
     * 二分查找法（递归）
     *
     * @author hcp(hepingzhige13@163.com)
     * @date 2018/5/11 20:28
     */
    public static void binarySearchByRecursive(int[] ints, int x, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (ints[mid] == x) {
                System.out.println("binary search by recursive, index = " + mid + ", value = " + ints[mid]);
                return;
            } else if (ints[mid] < x) {
                binarySearchByRecursive(ints, x, mid + 1, end);
                return;
            }else {
                binarySearchByRecursive(ints, x, start, end - 1);
                return;
            }
        }
    }
}
