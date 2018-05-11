package com.hcp.datastructrue.array;

/**
 * 二分查找法——数组
 * Created by hcp on 2017/9/16.
 */
public class OrderArray {
    private long[] a;
    private int nElems;

    public OrderArray(int max) {
        a = new long[max];
        nElems = 0;
    }

    public int size(){
        return nElems;
    }

    
}
