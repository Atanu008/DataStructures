package org.atanu.java.ds.design;

import java.util.LinkedList;

//LeetCode 705
//https://leetcode.com/problems/design-hashset/
public class HashSetUsingChaining {

    LinkedList<Entry>[] bucket;
    int bucketSize;
    int size;
    /** Initialize your data structure here. */
    public HashSetUsingChaining() {
        bucketSize = 769;
        bucket = new LinkedList[bucketSize];

    }

    public void add(int key) {

        if(contains(key)){
            return;
        }
        int bucketIndex = key%bucketSize;
        LinkedList<Entry> entries = bucket[bucketIndex];
        Entry newEntry = new Entry(key, key);

        if(entries == null){
            LinkedList<Entry> newList = new LinkedList<>();
            newList.add(newEntry);
            bucket[bucketIndex] = newList;
        }
        else{
            entries.add(newEntry);
        }
    }

    public void remove(int key) {
        int bucketIndex = key%bucketSize;
        LinkedList<Entry> entries = bucket[bucketIndex];
        if(entries != null){
            entries.removeIf(entry -> entry.key == key);
        }

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketIndex = key%bucketSize;
        LinkedList<Entry> entries = bucket[bucketIndex];
        if(entries != null){
            for(Entry entry : entries){
                if(entry.key == key){
                    return true;
                }
            }
        }

        return false;
    }

    public class Entry {
        int key, value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        HashSetUsingChaining myHashSet = new HashSetUsingChaining();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(1)); // return True
        System.out.println(myHashSet.contains(3)); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(2)); // return True
        myHashSet.remove(2);   // set = [1]
        System.out.println(myHashSet.contains(2)); // return False, (already removed)
    }
}
