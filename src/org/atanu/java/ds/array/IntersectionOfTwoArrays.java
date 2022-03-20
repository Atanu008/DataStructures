package org.atanu.java.ds.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/intersection-of-two-arrays/
//LeetCode 349
public class IntersectionOfTwoArrays {

    //Using Two Set
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

    //Two Pointer
    public int[] intersectionV2(int[] nums1, int[] nums2) {
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

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};

        IntersectionOfTwoArrays intersectionOfTwoArrays = new IntersectionOfTwoArrays();
        int[] result = intersectionOfTwoArrays.intersection(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }
}
