package com.hcp.algorithm;

import java.util.*;

public class BinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 从上到下打印二叉树
     *
     * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
     *
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回：
     *
     * [3,9,20,15,7]
     *
     * @param
     * @return 
     * @author hcp
     * @date 2021/9/24 16:00
     */ 
    public static int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>(queue.size());
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    /**
     * 从上到下打印二叉树 II
     *
     * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
     *
     *  
     *
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     *
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     *
     * @param
     * @return
     * @author hcp
     * @date 2021/9/24 16:39
     */
    public static List<List<Integer>> levelOrderByLevel(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> nodeList = new ArrayList<>(2);
            for (int i = queue.size(); i > 0 ; i--) {
                TreeNode node = queue.poll();
                nodeList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(nodeList);
        }
        return list;
    }

    /**
     * 从上到下打印二叉树 III
     *
     * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
     *
     *  
     *
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     *
     * [
     *   [3],
     *   [20,9],
     *   [15,7]
     * ]
     *
     * @author hcp
     * @date 2021/9/25 15:26
     */
    public static List<List<Integer>> levelOrderByLevel2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            LinkedList<Integer> nodeList = new LinkedList<>();
            for (int i = queue.size(); i > 0 ; i--) {
                TreeNode node = queue.poll();
                if (list.size() % 2 == 0) {
                    nodeList.addLast(node.val);
                } else {
                    nodeList.addFirst(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(nodeList);
        }
        return list;
    }

    /**
     * 树的子结构
     *
     * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
     *
     * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
     *
     * 例如:
     * 给定的树 A:
     *
     *      3
     *     / \
     *    4   5
     *   / \
     *  1   2
     * 给定的树 B：
     *
     *    4 
     *   /
     *  1
     * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
     *
     * 示例 1：
     *
     * 输入：A = [1,2,3], B = [3,1]
     * 输出：false
     * 示例 2：
     *
     * 输入：A = [3,4,5,1,2], B = [4,1]
     * 输出：true
     *
     * @author hcp
     * @date 2021/9/25 20:39
     */
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (hashSubStructure(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));

    }

    private static boolean hashSubStructure(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null || a.val != b.val) {
            return false;
        }
        return hashSubStructure(a.left, b.left) && hashSubStructure(a.right, b.right);
    }

    /**
     * 二叉树的镜像
     *
     * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
     *
     * 例如输入：
     *
     *      4
     *    /   \
     *   2     7
     *  / \   / \
     * 1   3 6   9
     * 镜像输出：
     *
     *      4
     *    /   \
     *   7     2
     *  / \   / \
     * 9   6 3   1
     *
     *  
     *
     * 示例 1：
     *
     * 输入：root = [4,2,7,1,3,6,9]
     * 输出：[4,7,2,9,6,3,1]
     *
     * @author hcp
     * @date 2021/9/26 11:12
     */
    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * 对称的二叉树
     *
     * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
     *
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     *
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     *
     *  
     *
     * 示例 1：
     *
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     * 示例 2：
     *
     * 输入：root = [1,2,2,null,3,null,3]
     * 输出：false
     *
     * @author hcp
     * @date 2021/9/26 16:22
     */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return childIsSymmetric(root.left, root.right);
    }

    private static boolean childIsSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return childIsSymmetric(left.left, right.right) && childIsSymmetric(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        root.left = left;
        left.left  = new TreeNode(7);
        left.right  = new TreeNode(15);
        TreeNode right = new TreeNode(9);
        root.right = right;
        right.left = new TreeNode(15);
        right.right = new TreeNode(7);

//        System.out.println(Arrays.toString(levelOrder(root)));
//        System.out.println((levelOrderByLevel(root)));
//        System.out.println((levelOrderByLevel2(root)));
        TreeNode childTree = new TreeNode(20);
        childTree.left = new TreeNode(15);
//        System.out.println(isSubStructure(root, childTree));
//        mirrorTree(root);
        System.out.println(isSymmetric(root));

    }
}
