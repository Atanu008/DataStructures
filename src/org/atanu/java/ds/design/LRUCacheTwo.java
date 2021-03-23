package org.atanu.java.ds.design;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/lru-cache/
// This is slow due to multiple unnecessary map access
public class LRUCacheTwo {
    Node head = new Node();
    Node tail = new Node();
    int capacity;
    Map<Integer, Node> node_map = new HashMap<>();

    public LRUCacheTwo(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(node_map.containsKey(key)){
            Node node = node_map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }


    public void put(int key, int value) {
        if(node_map.containsKey(key)){
            remove(node_map.get(key));
        }
        else if(capacity == node_map.size()){
            remove(tail.prev);
        }

        Node newNode = new Node(key, value);
        insert(newNode);
    }

    private void insert(Node node) {
        node_map.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }

    private void remove(Node node) {
        node_map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    static class Node {
        Node prev, next;
        int key, value;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }

        public Node(){

        }
    }

    public static void main(String[] args) {
        LRUCacheTwo lRUCache = new LRUCacheTwo(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        System.out.println("Map Size "+lRUCache.node_map.size());
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }
}
