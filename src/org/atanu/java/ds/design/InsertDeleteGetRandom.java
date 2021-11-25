package org.atanu.java.ds.design;

import java.util.*;

//https://leetcode.com/problems/insert-delete-getrandom-o1/
//LeetCode 380
public class InsertDeleteGetRandom {

    List<Integer> valueList;
    Map<Integer, Integer> indexMap;

    public InsertDeleteGetRandom() {
        valueList = new ArrayList<>();
        indexMap = new HashMap<>();
    }

    public boolean insert(int val) {
        if(indexMap.containsKey(val)){
            return false;
        }
        indexMap.put(val,valueList.size());
        valueList.add(val);

        return true;
    }

    //Retrieve an index of element to delete from the hashmap.
    //Move the last element to the place of the element to delete,O(1) time.
    //Pop the last element out, O(1) time.
    public boolean remove(int val) {
        if(!indexMap.containsKey(val)){
            return false;
        }
        // move the last element to the place idx of the element to delete
        int index = indexMap.get(val);
        int lastValue = valueList.get(valueList.size() -1);

        valueList.set(index, lastValue);
        indexMap.put(lastValue, index);

        // delete the last element
        indexMap.remove(val);
        valueList.remove(valueList.size() -1);

        return true;
    }

    public int getRandom() {
        int size = valueList.size();
        int randomIndex = new Random().nextInt(size);
        return valueList.get(randomIndex);
    }
}
