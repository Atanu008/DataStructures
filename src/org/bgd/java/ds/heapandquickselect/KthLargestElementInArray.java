package org.bgd.java.ds.heapandquickselect;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 * 215. Kth Largest Element in an Array
 *
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Can you solve it without sorting?
 */

/**
 * While this can be solved with Heap in O(nlogk), a better approach is the quick select which has an average case of O(n)
 */

public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i : nums) {
            list.add(i);
        }
        return quickSelect(list, k);
    }

    private int quickSelect(List<Integer> list, int k) {
        int pivotIndex = new Random().nextInt(list.size());
        int pivot = list.get(pivotIndex);

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> mid = new ArrayList<>();

        for(int i : list) {
            /**
             * if Kth smallest is to be found, left should contain all elements lower than pivot
             * if Kth largest is to be found, left should contain all elements greater than pivot
             */
            if( i > pivot) {
                left.add(i);
            } else if (i < pivot) {
                right.add(i);
            } else {
                mid.add(i);
            }
        }

        if(left.size() >= k) {
            return quickSelect(left, k);
        }
        if(left.size() + mid.size() < k) {
            return quickSelect(right, k - (left.size() + mid.size()));
        }
        return pivot;
    }
}
