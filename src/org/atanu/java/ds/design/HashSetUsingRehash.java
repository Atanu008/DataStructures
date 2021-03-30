package org.atanu.java.ds.design;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//LeetCode 705
//https://leetcode.com/problems/design-hashset/
public class HashSetUsingRehash {
    List<Integer>[] bucket;
    int bucketSize;
    int size;
    double loadFactor;

    public HashSetUsingRehash() {
        bucketSize = 16;
        bucket = new LinkedList[bucketSize];
        loadFactor = 0.75;
        size = 0;
    }

    public void add(int key) {
        if(contains(key)) {
            return;
        }
        int bucketIndex = key%bucketSize;
        List<Integer> entries = bucket[bucketIndex];
        if(entries == null) {
            entries = new LinkedList<>();
        }
        entries.add(key);
        bucket[bucketIndex] = entries;
        size++;

        if(overload()) {
            rehash();
        }
    }

    public void remove(int key) {
        int bucketIndex = key % bucketSize;
        List<Integer> entries = bucket[bucketIndex];
        if (entries != null) {
            Iterator<Integer> iterator = entries.iterator();
            while (iterator.hasNext()) {
                if (iterator.next() == key) {
                    iterator.remove();
                    size--;
                }
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucketIndex = key%bucketSize;
        List<Integer> entries = bucket[bucketIndex];
        if(entries != null) {
            for(int a: entries){
                if(a == key){
                    return true;
                }
            }
        }

        return false;

    }

    private void rehash() {
        List<Integer>[] oldBucket = bucket;
        bucketSize *=2;
        bucket = new LinkedList[bucketSize];
        for(List<Integer> entries: oldBucket) {
            if(entries == null) {
                continue;
            }
            for(int k : entries){
                add(k);
            }
        }
    }

    private boolean overload() {
        double currentLoad = size/bucketSize;
        return currentLoad > loadFactor;
    }

    public static void main(String[] args) {
        HashSetUsingRehash myHashSet = new HashSetUsingRehash();
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
