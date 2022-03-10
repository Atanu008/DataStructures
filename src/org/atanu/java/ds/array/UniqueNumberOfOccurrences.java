package org.atanu.java.ds.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/unique-number-of-occurrences/
//LeetCode 1207
public class UniqueNumberOfOccurrences {

    public boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int a : arr) {
            frequencyMap.put(a, frequencyMap.getOrDefault(a, 0)+1);
        }

        Set<Integer> set = new HashSet<>(frequencyMap.values());

        return frequencyMap.size() == set.size();
    }
}
