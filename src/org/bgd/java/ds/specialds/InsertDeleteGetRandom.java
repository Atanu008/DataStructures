package org.bgd.java.ds.specialds;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * <a href="https://leetcode.com/problems/insert-delete-getrandom-o1/description/">...</a>
 *
 *Implement the RandomizedSet class:
 *
 * RandomizedSet() Initializes the RandomizedSet object.
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements
 * (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
 *
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 */
public class InsertDeleteGetRandom {
    class RandomizedSet {

        Map<Integer, Integer> map;
        List<Integer> list;
        Random random;

        public RandomizedSet() {
            this.map = new HashMap<>();
            this.list = new ArrayList<>();
            this.random = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            int lastValue = list.getLast();
            int index = map.get(val);
            list.set(index, lastValue);
            map.put(lastValue, index);
            list.removeLast();
            map.remove(val);
            return true;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}
