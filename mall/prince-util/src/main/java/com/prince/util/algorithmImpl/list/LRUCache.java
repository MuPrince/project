package com.prince.util.algorithmImpl.list;


import java.util.HashMap;
import java.util.Map;

/**
 * @description: LRU缓存
 *              最近最少使用到的（least recently used）
 *              https://leetcode-cn.com/problems/lru-cache/
 * @author Prince
 * @time 2020/9/23 14:16
 */
public class LRUCache {

    private int capacity;
    private Map<Integer, CacheNode> valNodeMap = new HashMap<>();
    private CacheNode head = new CacheNode(-1, -1);
    private CacheNode tail = new CacheNode(-1, -1);

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.head.next = tail;
        this.tail.prev = head;
    }

    public int get(int key){
        if (!valNodeMap.containsKey(key)){
            return -1;
        }
        CacheNode current = valNodeMap.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;
        moveToTail(current);
        return valNodeMap.get(key).value;
    }

    public void put(int key, int value){
        if(get(key) != -1){
            valNodeMap.get(key).value = value;
            return;
        }
        if(valNodeMap.size() == capacity){
            valNodeMap.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        CacheNode insert = new CacheNode(key,value);
        valNodeMap.put(key,insert);
        moveToTail(insert);
    }

    private void moveToTail(CacheNode current) {
        current.next = tail;
        current.prev = tail.prev;
        tail.prev.next = current;
        tail.prev = current;
    }

    private class CacheNode{
        CacheNode prev;
        CacheNode next;
        int key;
        int value;
        public CacheNode(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
}
