package com.hcp.datastructrue.BinaryTree;

/**
 * 二叉树测试
 * Created by Administrator on 2016/5/16.
 */
public class TreeApp {
    public static void main(String[] args) {
        int value;
        BinaryTree tree = new BinaryTree();
        tree.inset(50, 1.5);
        tree.inset(25, 1.2);
        tree.inset(75, 1.7);
        tree.inset(12, 1.5);
        tree.inset(37, 1.2);
        tree.inset(43, 1.7);
        tree.inset(30, 1.5);
        tree.inset(33, 1.2);
        tree.inset(87, 1.7);
        tree.inset(93, 1.5);
        tree.inset(97, 1.5);

        Node found = tree.find(25);
        if (found != null){
            System.out.println(found.iData + " ***** " + String.valueOf(found.dData));
        }

    }
}
