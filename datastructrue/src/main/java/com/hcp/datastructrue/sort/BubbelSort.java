package com.hcp.datastructrue.sort;

/**
 * 冒泡排序
 * Created by Administrator on 2016/5/19.
 */

class ArrayBub{
    private long[] a;
    private int nElems;

    public ArrayBub(int max){
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value){
        a[nElems] = value;
        nElems ++;
    }

    public void display(){
        for (int j = 0; j < nElems; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println();
    }

    /**
     * 冒泡排序——升序
     */
    public void bubbleSort(){
        for (int out = nElems - 1; out > 1; out--) {
            for (int in = 0; in < out; in++) {
                if (a[in] > a[in + 1]){
                    swap(in ,in + 1);
                }
            }
        }
    }

    /**
     * 冒泡排序——降序
     */
    public void bubbleSortDesc(){
        for (int out = nElems - 1; out > 0; out--) {
            for (int in = 0; in < out; in++) {
                if (a[in] < a[in + 1]){
                    swap(in ,in + 1);
                }
            }
        }
    }

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}

public class BubbelSort {
    public static void main(String[] args) {
        int maxSize = 10000;
        ArrayBub arr = new ArrayBub(maxSize);

        /*arr.insert(77);
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(0);
        arr.insert(66);
        arr.insert(33);*/

        for (int i = 0; i < maxSize; i++) {
            long n = (long) (Math.random() * (maxSize - 1));
            arr.insert(n);
        }

        arr.display();

        long startTime = System.currentTimeMillis();
        arr.bubbleSort();
        System.out.println(System.currentTimeMillis() - startTime);
        arr.display();

        startTime = System.currentTimeMillis();
        arr.bubbleSortDesc();
        System.out.println(System.currentTimeMillis() - startTime);
        arr.display();
    }
}
