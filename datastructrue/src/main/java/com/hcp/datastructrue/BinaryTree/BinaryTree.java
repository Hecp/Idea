package com.hcp.datastructrue.BinaryTree;


/**
 * 二叉树
 * Created by Administrator on 2016/5/9.
 */
public class BinaryTree {
    private Node root;

    public BinaryTree() {
        root = null;
    }

    /**
     * 查找节点
     *
     * @param key 节点key
     * @return
     */
    public Node find(int key) {
        Node current = root;
        // while循环保证找到最底层节点
        while (current.iData != key) {
            if (key < current.iData) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }
        return current;
    }

    /**
     * 二叉树插入节点
     *
     * @param id 节点key
     * @param dd 节点value
     */
    public void inset(int id, double dd) {
        Node newNode = new Node();
        newNode.iData = id;
        newNode.dData = dd;
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent;
            // while循环加上current == null判断保证找到最底层为null的节点，再将新增节点进行赋值。
            while (true) {
                // 将当前节点赋值给parent，要不然下面将当前节点的子节点为null赋值给当前节点后，将无法进行左右节点的赋值。
                parent = current;
                if (id < current.iData) {
                    // 如果增加的key小于当前节点的左节点，则将其左节点赋值给当前节点，遍历。
                    current = current.leftChild;
                    // 一直找到当前节点的左节点为空，则将新的节点赋值给左节点，该判断保证了找到最底层。
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while (current.iData != key) {
            parent = current;
            if (key < current.iData) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }

        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) { // 删除根节点
                root = null;
            } else if (isLeftChild) { // 删除当前节点的左节点
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }

        }
        return false;
    }
}

class Node {
    public int iData;
    public double dData;
    public Node leftChild;
    public Node rightChild;

    public void displayNode() {
        System.out.println("{");
        System.out.println(iData);
        System.out.println(",");
        System.out.println(dData);
        System.out.println("}");
    }
}

