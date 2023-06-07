package org.atanu.java.ds.binarysearch;

// https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/description/
// Leetcode 1287

import java.util.HashMap;
import java.util.Map;

public class ElementAppearingMoreThan25PercentageInSortedArray {

    // O(N)
    public int findSpecialInteger(int[] arr) {
        int quarter = arr.length / 4;
        // For a number to be Majority it has to be presnst i + quarter as the array is sorted
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == arr[i + quarter]){
                return arr[i];
            }
        }
        return -1;
    }

    // Using HashMap
    public int findSpecialInteger_v2(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> freq = new HashMap<>();
        for(int a : arr){
            freq.put(a, freq.getOrDefault(a, 0) + 1);
            if(freq.get(a) > n / 4){
                return a;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ElementAppearingMoreThan25PercentageInSortedArray elements = new ElementAppearingMoreThan25PercentageInSortedArray();
        int[] arr = {1,2,2,6,6,6,6,7,10};
        System.out.println(elements.findSpecialInteger(arr));
        System.out.println(elements.findSpecialInteger_v2(arr));
    }
}
