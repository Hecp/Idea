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

    public void inset(long value){
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
        int maxSize = 100;
        ArrayBub arr = new ArrayBub(maxSize);

        arr.inset(77);
        arr.inset(99);
        arr.inset(44);
        arr.inset(55);
        arr.inset(22);
        arr.inset(88);
        arr.inset(11);
        arr.inset(00);
        arr.inset(66);
        arr.inset(33);

        arr.display();

        arr.bubbleSort();
        arr.display();

        arr.bubbleSortDesc();
        arr.display();
    }
}
