package org.atanu.java.ds.binarysearch;

// https://leetcode.com/problems/most-beautiful-item-for-each-query/description/
// Leetcode 2070

import java.util.Arrays;
import java.util.TreeMap;

public class MostBeautifulItemForEachQuery {
    public int[] maximumBeauty(int[][] items, int[] queries) {

        Arrays.sort(items, (a, b) -> a[0] - b[0]); // Sort items by price in ascending order

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int maxBeauty = 0;

        for(int[] item : items){
            maxBeauty = Math.max(maxBeauty, item[1]);// rolling max of beauty seen
            treeMap.put(item[0], maxBeauty);
        }

        int[] result = new int[queries.length];
        int index = 0;
        for(int query : queries){
            Integer floorKey = treeMap.floorKey(query); // if entry for a price exists, value should have max beauty seen else pick floor price entry
            result[index++] = floorKey == null ? 0 : treeMap.get(floorKey);
        }

        return result;
    }
}
