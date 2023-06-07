package org.atanu.java.ds.twopointer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/intersection-of-two-arrays/
//LeetCode 349
public class IntersectionOfTwoArrays {

    //Using Two Set
    //Use two hash sets
    //Time complexity: O(n)
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();

        for(int a : nums1) {
            set.add(a);
        }

        for(int b : nums2) {
            if(set.contains(b)){
                intersection.add(b);
            }
        }

        int[] result_intersection = new int[intersection.size()];
        int index = 0;
        for(int num : intersection){
            result_intersection[index++] = num;
        }

        return result_intersection;
    }

    // Two Pointer
    // Time complexity: O(nlogn)
    public int[] intersection_v2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        Set<Integer> set = new HashSet<>();
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]){
                set.add(nums1[i]);
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

        return set.stream().mapToInt(a ->a).toArray();
    }

    // Binary search
    // Sort one array .
    // check element from one array and sear in sorted array
    // If Found add in result
    // A little optimization for the binary search solutions can be done.
    // Compare the length of two arrays, and sort the shorter one.
    // Time complexity: O(nlogn)
    public int[] intersection_v3(int[] nums1, int[] nums2) {
        Set<Integer> intersection = new HashSet<>();
        Arrays.sort(nums2);

        for(int num : nums1){
            if(binarySearch(nums2, num)){
                intersection.add(num);
            }
        }

        int[] result = new int[intersection.size()];
        int index = 0;

        for(int num : intersection){
            result[index++] = num;
        }

        return result;
    }

    private boolean binarySearch(int[] nums, int target){

        int low = 0;
        int high = nums.length - 1;

        while(low <= high){

            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                return true;
            }else if(target < nums[mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};

        IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
        int[] result = intersectionOfTwoArrays.intersection(nums1, nums2);
        System.out.println(Arrays.toString(result));
        result = intersectionOfTwoArrays.intersection_v2(nums1, nums2);
        System.out.println(Arrays.toString(result));
        result = intersectionOfTwoArrays.intersection_v3(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}
