package com.hcp.algorithm.mergesort;

import java.util.Arrays;

/**
 * Created by hcp on 2018/11/16.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] ints = {26, 5, 98, 108, 28, 99, 100, 56, 34, 1 };
        System.out.println("sort before: " + Arrays.toString(ints));
        sort(ints, 0, ints.length - 1);
    }

    private static void sort(int[] ints, int start, int end) {
        if (start >= end) {
            return;
        }
        // 二分
        int mid = (start + end) / 2;
        // 二路归并排序调用两次sort方法，多路归并排序调用多次sort方法
        sort(ints, start, mid);
        sort(ints, mid + 1, end);
        merge(ints, start, mid, end);

    }

    private static void merge(int[] ints, int start, int mid, int end) {
        int[] temp = new int[ints.length];
        int right = mid + 1;
        int tIndex = start;
        int cIndex = start;
        while (start <= mid && right <= end) {
            if (ints[start] <= ints[right]) {
                temp[tIndex++] = ints[start++];
            } else {
                temp[cIndex++] = ints[right++];
            }

        }
    }
}
