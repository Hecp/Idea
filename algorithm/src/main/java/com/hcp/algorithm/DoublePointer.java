package com.hcp.algorithm;

import com.sun.xml.internal.ws.api.pipe.NextAction;

public class DoublePointer {
    public static class ListNode {
        int val;

        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 删除链表的节点
     *
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     *
     * 返回删除后的链表的头节点。
     *
     * 注意：此题对比原题有改动
     *
     * 示例 1:
     *
     * 输入: head = [4,5,1,9], val = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     *
     * @param head
     * @param val
     * @return
     * @author hcp
     * @date 2021/10/13 16:01
     */
    public static ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode currNode = head;
        // 如果currNode.next.val != val，则继续遍历；如果相等的话，则将currNode.next.next赋值给currNode.next，从而删除了currNode.next。
        while (currNode.next != null && currNode.next.val != val) {
            currNode = currNode.next;
        }
        if (currNode.next != null) {
            currNode.next = currNode.next.next;
        }
        return head;
    }

    /**
     * 链表中倒数第k个节点
     *
     * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     *
     * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
     *
     *  
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 k = 2.
     *
     * 返回链表 4->5.
     *
     * @param head
     * @param k
     * @return
     * @author hcp
     * @date 2021/10/13 16:11
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        int n = 0;
        ListNode node;
        for (node = head; node != null; node = node.next) {
            n++;
        }
        for (node = head; n > k; n--) {
            node = node.next;
        }
        return node;
    }

    public static ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode fast = head, slow = head;
        while (fast != null && k > 0) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 合并两个排序的链表
     *
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     *
     * 示例1：
     *
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     *
     * @param l1
     * @param l2
     * @return
     * @author hcp
     * @date 2021/10/13 16:43
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode node2 = new ListNode(3);
        root.next = node2;
        ListNode node3 = new ListNode(4);
        node2.next = node3;
        node3.next = new ListNode(6);
//        ListNode node = deleteNode(root, 5);
//        System.out.println(node);

//        ListNode node1 = getKthFromEnd2(root, 3);
//        System.out.println(node1);

        ListNode root1 = new ListNode(2);
        ListNode node12 = new ListNode(3);
        root1.next = node12;
        ListNode node13 = new ListNode(5);
        node12.next = node13;
        node13.next = new ListNode(7);
        ListNode listNode = mergeTwoLists(root, root1);
        System.out.println(listNode);
    }
}
