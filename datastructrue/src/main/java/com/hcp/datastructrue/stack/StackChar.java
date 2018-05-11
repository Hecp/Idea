package com.hcp.datastructrue.stack;

/**
 * char数组实现栈
 * Created by hcp on 2016/6/18.
 */
public class StackChar {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackChar(int s) {
        this.maxSize = s;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char j){
        stackArray[++top] = j;
    }

    public char pop(){
        return stackArray[top--];
    }

    public char peek(){
        return stackArray[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }
}


