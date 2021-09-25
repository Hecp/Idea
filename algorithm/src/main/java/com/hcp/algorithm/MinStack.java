package com.hcp.algorithm;

import java.util.Stack;

/**
 * 剑指 Offer 30. 包含min函数的栈
 *
 * @author hcp
 * @date 2021/9/13 22:50
 */
public class MinStack {
    Stack<Integer> A, B;

    public MinStack() {
        A = new Stack<>();
        B = new Stack<>();
    }

    public void push(int x) {
        A.add(x);
        if (B.empty() || B.peek() >= x) {
            B.add(x);
        }
    }

    public void pop() {
        if (A.pop().equals(B.peek())) {
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}
