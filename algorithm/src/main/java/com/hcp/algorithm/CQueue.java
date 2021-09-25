package com.hcp.algorithm;

import java.util.Deque;
import java.util.LinkedList;

public class CQueue {
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;

    public CQueue(Deque<Integer> stack1, Deque<Integer> stack2) {
        this.stack1 = new LinkedList<>();
        this.stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return -1;
        }else {
            return stack2.pop();
        }
    }
}
