package org.atanu.java.ds.design;

import java.util.LinkedList;

public class HashMapUsingChaining {
    LinkedList<Entry>[] bucket;
    public int SIZE = 769;

    /** Initialize your data structure here. */
    public HashMapUsingChaining() {
        bucket = new LinkedList[SIZE];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucktIndex = key%SIZE;
        LinkedList<Entry> entries = bucket[bucktIndex];

        if(entries == null) {
            LinkedList<Entry> newList = new LinkedList<>();
            Entry newEntry = new Entry(key, value);
            newList.add(newEntry);
            bucket[bucktIndex] = newList;
            return;
        }
        else{
            for(Entry entry: entries){
                if(entry.key == key){
                    entry.value = value;
                    return;
                }
            }
            Entry newEntry = new Entry(key, value);
            entries.add(newEntry);
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {

        int bucktIndex = key%SIZE;
        LinkedList<Entry> entries = bucket[bucktIndex];

        if(entries != null){
            for(Entry entry: entries){
                if(entry.key == key){
                    return entry.value;
                }
            }
        }

        return -1;

    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucktIndex = key%SIZE;
        LinkedList<Entry> entries = bucket[bucktIndex];
        Entry entryToRemove = null;
        if(entries == null) {
            return;
        }

        for(Entry entry: entries){
            if(entry.key == key){
                entryToRemove = entry;
                break;
            }
        }

        if(entryToRemove == null) {
            return;
        }
        entries.remove(entryToRemove);

    }

    public class Entry {
        int key, value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        HashMapUsingChaining myHashMap = new HashMapUsingChaining();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(1));    // return 1, The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(2));    // return 2
        System.out.println(myHashMap.get(3));    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        System.out.println(myHashMap.get(2));    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        System.out.println(myHashMap.get(2));    // return -1 (i.e., not found), The map is now [[1,1]]
    }
}
