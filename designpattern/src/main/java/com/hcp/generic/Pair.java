package com.hcp.generic;

/**
 * 自定义泛型类demo
 * 在Java库中，使用变量E表示集合的元素类型，
 * K和V表示表的关键字和值的类型，
 * T（需要时还可以用临近的字母U和S）表示任意类型。
 * Created by hcp on 2016/7/24.
 */
public class Pair<T> {
    private T first;
    private T second;

    public Pair() {
        first = null;
        second = null;
    }

    public Pair(T second, T first) {
        this.second = second;
        this.first = first;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
