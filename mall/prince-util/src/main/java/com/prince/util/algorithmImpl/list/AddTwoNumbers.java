package com.prince.util.algorithmImpl.list;


/**
 * @description: 链表相加
 *              输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 *              输出：9 -> 1 -> 2，即912
 *              https://leetcode-cn.com/problems/sum-lists-lcci/
 * @author Prince
 * @time 2020/9/23 13:53
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode list,ListNode other){
        if (list == null) {
            return other;
        }
        if (other == null) {
            return list;
        }
        int carry = 0;
        ListNode head = new ListNode(-1);
        ListNode prev = head;
        while (list != null && other != null){
            int number = list.val + other.val + carry;
            carry = number / 10;
            prev.next = new ListNode(number % 10);
            prev = prev.next;
            list = list.next;
            other = other.next;
        }
        while (list != null){
            int number = list.val + carry;
            carry = number / 10;
            prev.next = new ListNode(number % 10);
            prev = prev.next;
            list = list.next;
        }
        while (other != null){
            int number = other.val + carry;
            carry = number / 10;
            prev.next = new ListNode(number % 10);
            prev = prev.next;
            other = other.next;
        }
        if(carry != 0){
            ListNode node = new ListNode(carry);
            prev.next = node;
        }
        return head.next;
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

        public ListNode() {
        }

        ListNode(int value){
            this.val = value;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
