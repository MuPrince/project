package com.prince.util.algorithmImpl.list;


import java.util.HashMap;
import java.util.Map;

/**
 * @author Prince
 * @description: 深度拷贝带随机指针的链表
 * @time 2020/9/23 11:15
 */
public class DeepCopyListWithRandomPointer {

    /**
     * @description: 使用 Map 记录映射关系,进行copy Map增加空间复杂度(On)
     *              [[7,null],[13,0],[11,4],[10,2],[1,0]]
     *              https://leetcode-cn.com/problems/copy-list-with-random-pointer/
     * @param head
     * @return com.prince.support.common.list.DeepCopyListWithRandomPointer.Node
     * @author Prince
     * @date 2020/9/23 13:33
     */
    public Node copyRandomListWithMap(Node head){
        if (head == null) {
            return null;
        }
        Map<Node,Node> map = new HashMap<>();
        Node newHead = head;
        while (newHead != null) {
            if (!map.containsKey(newHead)) {
                Node copyNode = new Node(newHead.val);
                map.put(newHead, copyNode);
            }
            if(newHead.random != null){
                Node random = newHead.random;
                if(!map.containsKey(random)){
                    Node copyRandom = new Node(random.val);
                    map.put(random,copyRandom);
                }
                map.get(newHead).random = map.get(random);
            }
            newHead = newHead.next;
        }
        newHead = head;
        while (newHead != null){
            Node next = newHead.next;
            map.get(newHead).next = map.get(next);
            newHead = newHead.next;
        }
        return map.get(head);
    }

    /**
     * @description: 不使用map保存映射关系
     *              https://leetcode-cn.com/problems/copy-list-with-random-pointer/
     * @param head
     * @return com.prince.support.common.list.DeepCopyListWithRandomPointer.Node
     * @author Prince
     * @date 2020/9/23 13:52
     */
    public Node copyRandomList(Node head){
        if (head == null) {
            return null;
        }
        copy(head);
        copyRandom(head);
        return split(head);
    }

    private Node split(Node head) {
        Node result = head.next;
        Node move = head.next;
        while (head != null && head.next != null){
            head.next = head.next.next;
            head = head.next;
            if(move != null && move.next != null){
                move.next = move.next.next;
                move = move.next;
            }
        }
        return result;
    }

    private void copy(Node head) {
        Node node = head;
        while (node != null){
            Node copy = new Node(node.val);
            copy.next = node.next;
            node.next = copy;
            node = copy.next;
        }
    }

    private void copyRandom(Node head) {
        Node node = head;
        while (node != null && node.next != null){
            if(node.random != null){
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
    }

    /**
     * @author Prince
     * @description: Definition for singly-linked list.
     * @time 2020/9/23 10:04
     */
    public class Node {
        int val;
        Node next;
        Node random;

        public Node(int value) {
            this.val = value;
            this.next = null;
            this.random = null;
        }
    }
}
