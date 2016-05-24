package com.hcp.datastructrue.sort;

/**
 * 插入排序
 * Created by Administrator on 2016/5/23.
 */

class ArrayInsert{
    private long[] a;
    private int nElems;

    public ArrayInsert(int max){
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

    public void insertionSort(){
        int in;
        for (int out = 1; out < nElems; out++) {
            long temp = a[out];
            in = out;
            // 将当前元素与其前一个元素比较，如果前一个元素大于或等于当前元素，则将前一个元素后移一个位置。
            // 将当前元素下标减1，继续上面的比较，直到前一个元素小于当前元素，则将当前元素插入到这个位置。
            while (in > 0 && a[in - 1] >= temp){
                a[in] = a[in - 1];
                -- in;
            }
            a[in] = temp;
        }
    }


}

public class InsertionSort {
    public static void main(String[] args) {
        int maxSize = 10;
        ArrayInsert arrayInsert = new ArrayInsert(maxSize);

        arrayInsert.insert(77);
        arrayInsert.insert(99);
        arrayInsert.insert(44);
        arrayInsert.insert(55);
        arrayInsert.insert(22);
        arrayInsert.insert(88);
        arrayInsert.insert(11);
        arrayInsert.insert(0);
        arrayInsert.insert(66);
        arrayInsert.insert(33);

        arrayInsert.display();

        arrayInsert.insertionSort();
        arrayInsert.display();
    }
}
