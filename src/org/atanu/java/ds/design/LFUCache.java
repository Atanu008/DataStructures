package org.atanu.java.ds.design;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/lfu-cache/
public class LFUCache {

    int capacity;
    int size;
    int minFrequency;
    Map<Integer, DoubleLinkedList> frequencyMap;
    Map<Integer, Node> cache;
    /*.*/
    /*
     * @param capacity: total capacity of LFU Cache
     * @param curSize: current size of LFU cache
     * @param minFrequency: frequency of the last linked list (the minimum frequency of entire LFU cache)
     * @param cache: a hash map that has key to Node mapping, which used for storing all nodes by their keys
     * @param frequencyMap: a hash map that has key to linked list mapping, which used for storing all
     * double linked list by their frequencies
     * */
    public LFUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        minFrequency = 0;
        this.cache = new HashMap<>();
        frequencyMap = new HashMap<>();
    }

    /** get node value by key, and then update node frequency as well as relocate that node **/
    public int get(int key) {

        if(cache.containsKey(key)){
            update(key);
            System.out.println(cache.get(key).value);
            return cache.get(key).value;
        }
        return -1;
    }

    /**
     * add new node into LFU cache, as well as double linked list
     * condition 1: if LFU cache has input key, update node value and node position in list
     * condition 2: if LFU cache does NOT have input key
     *  - sub condition 1: if LFU cache does NOT have enough space, remove the Least Recent Used node
     *  in minimum frequency list, then add new node
     *  - sub condition 2: if LFU cache has enough space, add new node directly
     * **/
    public void put(int key, int value) {
        // corner case: check cache capacity initialization
        if (capacity == 0) {
            return;
        }
        if(cache.containsKey(key)){
            Node curNode = cache.get(key);
            curNode.value = value;
            update(key);
        }
        else{
            if(cache.size() == capacity){
                DoubleLinkedList minFrequencyList = frequencyMap.get(minFrequency);
                Node deleteNode = minFrequencyList.removeTail();
                cache.remove(deleteNode.key);
            }
            // reset min frequency to 1 because of adding new node
            minFrequency = 1;
            Node newNode = new Node(key, value);

            // get the list with frequency 1, and then add new node into the list, as well as into LFU cache
            DoubleLinkedList curList = frequencyMap.getOrDefault(1,new DoubleLinkedList());
            curList.add(newNode);
            frequencyMap.putIfAbsent(1, curList);
            cache.put(key,newNode);

        }
    }

    private void update(int key) {
        Node currentNode = cache.get(key);
        int nodeFreq = currentNode.frequency;
        DoubleLinkedList currentList = frequencyMap.get(nodeFreq);
        currentList.remove(currentNode);

        // if current list the the last list which has lowest frequency and current node is the only node in that list
        // we need to remove the entire list and then increase min frequency value by 1
        if(nodeFreq == minFrequency && currentList.size == 0){
            minFrequency++;
        }

        currentNode.frequency++;
        DoubleLinkedList newList = frequencyMap.getOrDefault(currentNode.frequency, new DoubleLinkedList());
        newList.add(currentNode);
        frequencyMap.putIfAbsent(currentNode.frequency, newList);
    }

    class DoubleLinkedList {
        int size;
        Node head;
        Node tail;

        public DoubleLinkedList(){
            this.size = 0;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        private void add(Node node){
            Node headNext = head.next;
            head.next = node;
            node.next = headNext;
            node.prev = head;
            headNext.prev = node;
            size++;
        }

        private void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        private Node removeTail(){
            if(size == 0){
                return null;
            }
            Node tailNode = tail.prev;
            remove(tailNode);
            return tailNode;
        }


    }
    class Node {
        Node prev, next;
        int key, value, frequency;


        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
        }
        public Node() {

        }
    }

    public static void main(String[] args) {
        // cnt(x) = the use counter for key x
// cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
        LFUCache lfu = new LFUCache(2);
        lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
        lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
        lfu.get(1);      // return 1
        // cache=[1,2], cnt(2)=1, cnt(1)=2
        lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
        // cache=[3,1], cnt(3)=1, cnt(1)=2
        lfu.get(2);      // return -1 (not found)
        lfu.get(3);      // return 3
        // cache=[3,1], cnt(3)=2, cnt(1)=2
        lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
        // cache=[4,3], cnt(4)=1, cnt(3)=2
        lfu.get(1);      // return -1 (not found)
        lfu.get(3);      // return 3
        // cache=[3,4], cnt(4)=1, cnt(3)=3
        lfu.get(4);      // return 4
        // cache=[3,4], cnt(4)=2, cnt(3)=3
    }


}
