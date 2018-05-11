package com.hcp.datastructrue.stack;

/**
 * long数组实现栈
 * Created by hcp on 2016/6/18.
 */
public class StackX {
    private int maxSize;
    private long[] stackArray;
    private int top;

    public StackX(int s) {
        this.maxSize = s;
        stackArray = new long[maxSize];
        top = -1;
    }

    public void push(long j){
        stackArray[++top] = j;
    }

    public long pop(){
        return stackArray[top--];
    }

    public long peek(){
        return stackArray[top];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }
}


class StackApp{
    public static void main(String[] args) {
        StackX stackX = new StackX(10);

        stackX.push(20);
        stackX.push(40);
        stackX.push(60);
        stackX.push(80);

        while (!stackX.isEmpty()){
            System.out.println(stackX.peek());
            long value = stackX.pop();
            System.out.print("pop value: " + value);
            System.out.println();
        }

    }
}
