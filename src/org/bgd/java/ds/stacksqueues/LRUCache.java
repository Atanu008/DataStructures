package org.bgd.java.ds.stacksqueues;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/lru-cache/description/">...</a>
 *
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 */

public class LRUCache {
    int capacity;
    Map<Integer, ListNode<Integer>> map;
    ListNode<Integer> head;
    ListNode<Integer> tail;

    LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new ListNode<Integer>(-1, -1);
        this.tail = new ListNode<Integer>(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    /**
     * If map does not contain, return pre-emptively
     * Else: get Node from map
     * Move node to tail
     * return value
     *
     * @param key
     * @return
     */

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        ListNode<Integer> node = map.get(key);
        remove(node);
        addToTail(node);
        return node.val;
    }

    /**
     * If map contains key:
     * move Node to tail
     * update node with new value
     *
     * If map does not contain key,
     * create new Node
     * Add Node to Tail
     * Put node in map
     *
     * Check eviction based on capacity
     * Evict head.next node
     *
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode<Integer> oldNode = map.get(key);
            remove(oldNode);
        }
        ListNode<Integer> newNode = new ListNode<>(key, value);
        map.put(key, newNode);
        addToTail(newNode);

        if (map.size() > capacity) {
            ListNode<Integer> lruNode = head.next;
            remove(lruNode);
            map.remove(lruNode.key);
        }
    }

    public void addToTail(ListNode<Integer> node) {
        ListNode<Integer> previousEnd = tail.prev;
        previousEnd.next = node;
        node.prev = previousEnd;
        node.next = tail;
        tail.prev = node;
    }

    public void remove(ListNode<Integer> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

class ListNode<T> {
    T key;
    T val;
    ListNode<T> next;
    ListNode<T> prev;

    ListNode(T key, T val) {
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

