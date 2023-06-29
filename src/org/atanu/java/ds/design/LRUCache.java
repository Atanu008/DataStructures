package org.atanu.java.ds.design;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/lru-cache/
public class LRUCache {

    final Node head = new Node();
    final Node tail = new Node();
    int capacity;
    Map<Integer, Node> node_map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        if(node_map.containsKey(key)){
            Node data = node_map.get(key);

            //Remove node from the LinkedList Tail
            remove(data);

            //Insert node to the LinkedList Head
            insert(data);

            return data.value;
        }

        return -1;
    }

    public void put(int key, int value) {

        if(node_map.containsKey(key)){
            Node node = node_map.get(key);
            //Update the value with new value
            node.value = value;

            //Remove node from the LinkedList
            remove(node);

            //Insert node to the LinkedList
            insert(node);
        }
        else {// New Node
            //If capacity reached , Remove from Map and LinkedList
            if(capacity  == node_map.size()){
                node_map.remove(tail.prev.key);
                remove(tail.prev);
            }

            Node insertNode = new Node(key, value);
            //Insert the new Node
            insert(insertNode);
            //Put the new Node in Map
            node_map.put(key, insertNode);
        }

    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insert(Node node){
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;

    }

    class Node{

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
        LRUCache lRUCache = new LRUCache(2);
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

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
