package org.atanu.java.ds.array;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/majority-element/
// Leetcode 169

public class MajorityElement {

    //The basic solution is to have two loops and keep track of maximum count for all different elements
    public static int majorityElement(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i; j < n; j++) {
                if (nums[i] == nums[j])
                    count++;
            }
            if (count > n / 2)
                return nums[i];
        }
        return -1;
    }


    public static int majorityElement_v2(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            if (freq.get(num) > nums.length / 2) {
                return num;
            }
        }
        return -1;
    }

    // Basic idea of the algorithm is that if we cancel out each occurrence of an element e
    // with all the other elements that are different from e then e will exist till end if it is a majority element.
    public static int majorityElement_v3(int[] nums) {

        int count = 0;
        Integer candidate = null; // we can initialize to 0, but zero can be any element in the array

        for(int num : nums){
            if(count == 0){
                candidate = num;
            }
            count += candidate == num ? 1 : -1;
        }
        return candidate;
    }


    public static void main(String[] args) {

        // Assumption - valid input (majority element is present)
        int arr[] = {1, 8, 7, 4, 1, 2, 2, 2, 2, 2, 2};

        // int arr[] = {1, 1, 2, 1, 3, 5, 1};

        System.out.println("Majority Element is " + majorityElement(arr));

        System.out.println("Majority Element is " + majorityElement_v2(arr));

        System.out.println("Majority Element is " + majorityElement_v3(arr));


    }

}
