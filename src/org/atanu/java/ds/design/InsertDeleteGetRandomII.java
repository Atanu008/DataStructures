package org.atanu.java.ds.design;

import java.util.*;

//https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
//LeetCode 381
public class InsertDeleteGetRandomII {

    List<Integer> valueList;
    Map<Integer, Set<Integer>> indexMap; //Set to Maintain all Indexes for one value. As Value can be duplicated

    public InsertDeleteGetRandomII() {
        valueList = new ArrayList<>();
        indexMap = new HashMap<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        //If the Element is being inserted for the First Time . Create the indexes List
        if(!indexMap.containsKey(val)){
            indexMap.put(val, new HashSet<>());
        }

        //Id index to indexes Set
        //Add value to the List
        indexMap.get(val).add(valueList.size());
        valueList.add(val);

        //If the Element is being inserted for the First Time. the size will always be one
        //If the element was present before then size would be greater that One
        return indexMap.get(val).size() == 1;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!indexMap.containsKey(val) || indexMap.get(val).size() == 0){
            return false;
        }
        int removeIndex = indexMap.get(val).iterator().next();
        //Remove that index from Set in Map
        indexMap.get(val).remove(removeIndex);
        int lastElement = valueList.get(valueList.size() -1);
        //Set Last element to the index
        valueList.set(removeIndex, lastElement);

        //Add index for Last values index set
        indexMap.get(lastElement).add(removeIndex);
        //Remove last values index from set
        indexMap.get(lastElement).remove(valueList.size() -1);

        //Remove from List
        valueList.remove(valueList.size() -1);
        return true;
    }

    public int getRandom() {

        return valueList.get(new Random().nextInt(valueList.size()));
    }
}
