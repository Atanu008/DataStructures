package org.atanu.java.ds.twopointer;

import java.util.*;

public class IntersectionOfTwoArraysII {

    //Algorithm
    //If nums1 is larger than nums2, swap the arrays.

    //For each element in nums1:
    //Add it to the hash map m.
    //Increment the count if the element is already there.
    //Initialize the insertion pointer (k) with zero.

    //Iterate along nums2:
    //If the current number is in the hash map and count is positive:
    //Copy the number into nums1[k], and increment k.
    //Decrement the count in the hash map.

    //Return first k elements of nums1.

    // Time Complexity: O(n+m)
    // Space Complexity: O(min(n,m)).
    // We use hash map to store numbers (and their counts) from the smaller array.

    public int[] intersect(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length){
            return intersect(nums2, nums1);
        }
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums1){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for(int num : nums2){
            if(freq.containsKey(num) && freq.get(num) > 0){
                list.add(num);
                freq.put(num, freq.get(num) - 1);
            }
        }

        return list.stream().mapToInt(a ->a).toArray();
    }

    // Two Pointer Approach
    // The only difference between the first Question is here we need to have duplicates as well
    // In that case just use List instead of Set
    public int[] intersect_v2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] < nums2[j]) {
                i++;
            }
            else {
                j++;
            }
        }

        return list.stream().mapToInt(a ->a).toArray();
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        IntersectionOfTwoArraysII intersectionOfTwoArrays = new IntersectionOfTwoArraysII();
        int[] result = intersectionOfTwoArrays.intersect(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}
