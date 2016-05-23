package com.hcp.datastructrue.sort;

/**
 * 选择排序
 * Created by Administrator on 2016/5/23.
 */

class ArraySelect{
    private long[] a;
    private int nElems;

    public ArraySelect(int max){
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

    public void selectionSort(){
        int out, min, in;
        for (out = 0; out < nElems - 1; out++) {
            min = out;  // 当前最小值的下标——相当于标记
            for (in = out + 1; in < nElems; in++) {
                if (a[in] < a[min]){
                    min = in;
                }
            }
            swap(out, min);
        }
    }

    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }

}

public class SelectSort {
    public static void main(String[] args) {
        int maxSize = 100;
        ArraySelect arraySelect = new ArraySelect(maxSize);

        arraySelect.insert(77);
        arraySelect.insert(99);
        arraySelect.insert(44);
        arraySelect.insert(55);
        arraySelect.insert(22);
        arraySelect.insert(88);
        arraySelect.insert(11);
        arraySelect.insert(0);
        arraySelect.insert(66);
        arraySelect.insert(33);

        arraySelect.display();

        arraySelect.selectionSort();
        arraySelect.display();
    }
}
