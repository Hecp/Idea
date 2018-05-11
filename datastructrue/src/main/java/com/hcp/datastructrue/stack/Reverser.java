package com.hcp.datastructrue.stack;

/**
 * 利用栈进行字符串反转
 * Created by hcp on 2016/6/18.
 */
class Reverser {
    private String input;
    private String output;

    public Reverser(String input) {
        this.input = input;
    }

    public String doReverse(){
        int stackSize = input.length();
        StackChar stackX = new StackChar(stackSize);

        for (int i = 0; i < stackSize; i++) {
            char ch = input.charAt(i);
            stackX.push(ch);
        }

        output = "";
        while (!stackX.isEmpty()){
            char ch = stackX.pop();
            output += ch;
        }
        return output;
    }
}
