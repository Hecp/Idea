package com.hcp.datastructrue.sort;

/**
 * 希尔排序
 * <p/>
 * Created by Administrator on 2016/5/25.
 */

class ArrayShell {
    private long[] a;
    private int nElems;

    public ArrayShell(int max) {
        a = new long[max];
        nElems = 0;
    }

    public void insert(long value) {
        a[nElems] = value;
        nElems++;
    }

    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public void shellSort() {
        int inner, outer;
        long temp;

        int h = 1;
        while (h <= nElems / 3) {
            h = h * 3 + 1;
        }
        while (h > 0) {
            for (outer = h; outer < nElems; outer++) {
                temp = a[outer];
                inner = outer;

                // 插入排序
                while (inner > h - 1 && a[inner - 1] >= temp) {
                    a[inner] = a[inner - 1];
                    inner -= h;
                }
                a[inner] = temp;
            }
            h = (h - 1) / 3;
        }
    }

    public void shellSort1() {
        int i, j, gap;
        for (gap = nElems / 2; gap > 0; gap /= 2) {
            for (i = 0; i < gap; i++) {  // 直接插入排序
                for (j = i + gap; j < nElems; j += gap){
                    sortUtil(j, gap);
                }
            }
        }
    }

    public void shellSort2()
    {
        int j, gap;

        for (gap = nElems / 2; gap > 0; gap /= 2)
            for (j = gap; j < nElems; j++)//从数组第gap个元素开始
                sortUtil(j, gap);
    }

    public void shellSort3()
    {
        int i, j, gap;
        long temp;

        for (gap = nElems / 2; gap > 0; gap /= 2)
            for (i = gap; i < nElems; i++)
                for (j = i - gap; j >= 0 && a[j] > a[j + gap]; j -= gap){
                    temp = a[j + gap];
                    a[j + gap] = a[j];
                    a[j] = temp;
                }
    }

    private void sortUtil(int j, int gap) {
        if (a[j] < a[j - gap])//每个元素与自己组内的数据进行直接插入排序
        {
            long temp = a[j];
            int k = j - gap;
            while (k >= 0 && a[k] > temp)
            {
                a[k + gap] = a[k];
                k -= gap;
            }
            a[k + gap] = temp;
        }
    }

}

public class ShellSort {

    public static void main(String[] args) {
        int maxSize = 10000;
        ArrayShell arrayShell = new ArrayShell(maxSize);

        for (int i = 0; i < maxSize; i++) {
            long n = (long) (Math.random() * 99);
            arrayShell.insert(n);
        }

        /*arrayShell.display();
        long startTime = System.currentTimeMillis();
        arrayShell.shellSort();
        System.out.println("shellSort——" + (System.currentTimeMillis() - startTime));
        arrayShell.display();*/

       /* arrayShell.display();
        long startTime = System.currentTimeMillis();
        arrayShell.shellSort1();
        System.out.println("shellSort1——" + (System.currentTimeMillis() - startTime));
        arrayShell.display();*/

        /*arrayShell.display();
        long startTime = System.currentTimeMillis();
        arrayShell.shellSort2();
        System.out.println("shellSort2——" + (System.currentTimeMillis() - startTime));
        arrayShell.display();*/

        arrayShell.display();
        long startTime = System.currentTimeMillis();
        arrayShell.shellSort3();
        System.out.println("shellSort3——" + (System.currentTimeMillis() - startTime));
        arrayShell.display();
    }
}
