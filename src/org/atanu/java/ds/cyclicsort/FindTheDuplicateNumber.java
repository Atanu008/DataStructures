package org.atanu.java.ds.cyclicsort;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/find-the-duplicate-number/
//LeetCode 287
public class FindTheDuplicateNumber {

    //This Solution works only of the array in mutable and all teh elements are non negative and the ranges between 1 To n+1
    public int findDuplicate(int[] nums) {
        int duplicate = -1;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.abs(nums[i]);
            if (nums[cur-1] < 0) {
                duplicate = cur;
                return duplicate;
            }
            nums[cur-1] *= -1;
        }

        // Restore numbers
        for (int i = 0; i < nums.length; i++)
            nums[i] = Math.abs(nums[i]);

        return duplicate;
    }

    //Simple Hashing. space O(n)
    public int findDuplicateV2(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i< nums.length; i++){
            if(set.contains(nums[i])){
                return nums[i];
            }
            set.add(nums[i]);
        }

        return -1;
    }

    //Floyd's Tortoise and Hare Algorithm
    public int findDuplicateV3(int[] nums) {
        int slowPointer = nums[0];
        int fastPointer = nums[0];

        // We need do while because as we need to enter the loop although now
        //slowPointer and fastPointer is pointing to same element
        do{
            slowPointer = nums[slowPointer];
            fastPointer = nums[nums[fastPointer]];
        }while(slowPointer != fastPointer);

        slowPointer = nums[0];

        while(slowPointer != fastPointer){
            slowPointer = nums[slowPointer];
            fastPointer = nums[fastPointer];
        }

        return slowPointer;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        FindTheDuplicateNumber findTheDuplicateNumber = new FindTheDuplicateNumber();
        System.out.println("Duplicate Number "+ findTheDuplicateNumber.findDuplicateV3(nums));
        System.out.println("Duplicate Number "+ findTheDuplicateNumber.findDuplicateV2(nums));
        System.out.println("Duplicate Number "+ findTheDuplicateNumber.findDuplicate(nums));
    }
}
