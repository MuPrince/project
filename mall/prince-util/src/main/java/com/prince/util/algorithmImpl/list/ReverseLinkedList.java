package com.prince.util.algorithmImpl.list;

/**
 * @description: 翻转链表
 *
 * @author Prince
 * @time 2020/9/23 10:03
 */
public class ReverseLinkedList {
    /**
     * @description: 完全翻转链表
     * @param head
     * @return com.prince.support.common.list.ListNode
     * @author Prince
     * @date 2020/9/23 10:55
     */
    public ListNode reverseList(ListNode head){
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        ListNode current = head.next;
        prev.next = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    /**
     * @description: 翻转指定范围内的链表 dummy:哨兵节点
     *              https://leetcode-cn.com/problems/reverse-linked-list-ii/
     * @param head
     * @param start
     * @param end
     * @return com.prince.support.common.list.ListNode
     * @author Prince
     * @date 2020/9/23 10:56
     */
    public ListNode reverseBetween(ListNode head , int start, int end){
        if (head == null || start >= end) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        for (int i = 1; i < start; i++) {
            head = head.next;
        }
        ListNode prev = head;
        ListNode startNode = head.next;
        ListNode endNode = startNode;
        ListNode postEnd = endNode.next;
        for (int i = start; i < end; i ++){
            ListNode next = postEnd.next;
            postEnd.next = endNode;
            endNode = postEnd;
            postEnd = next;
        }
        startNode.next = postEnd;
        prev.next = endNode;
        return dummy.next;
    }

    /**
     * @description: Definition for singly-linked list.
     *
     * @author Prince
     * @time 2020/9/23 10:04
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int value){
            this.val = value;
        }

    }

}
