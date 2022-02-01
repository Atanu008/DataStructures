package org.atanu.java.ds.cyclicsort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/kth-missing-positive-number/
//LeetCode 1539
//https://www.educative.io/courses/grokking-the-coding-interview/g286M2Gk3YY
public class KthMissingPositiveNumber {
    //The time complexity of the above algorithm is O(n + k)O(n+k),
    //as the last two for loops will run for O(n)O(n) and O(k)O(k) times respectively.
    public int findKthPositive(int[] nums, int k) {
        int i = 0;
        while(i < nums.length) {
            //int j = nums[i] -1;
            if(nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] -1]) {
                swap(nums, i, nums[i] -1);
            }
            else{
                i++;
            }
        }

        List<Integer> missingNumbers = new ArrayList<>();
        Set<Integer> validPresentNumbers = new HashSet<>();

        for(int j = 0; j < nums.length && missingNumbers.size() < k ; j++) {
            if(nums[j] != j+1){
                missingNumbers.add(j+1);
                validPresentNumbers.add(nums[j]);
            }
        }

        // add the remaining missing numbers
        for(int l = 1; missingNumbers.size() < k; l++) {
            int candidate = l + nums.length;
            //ignore if the array contains the candidate number . This is tricky part
            if(!validPresentNumbers.contains(candidate)) {
                missingNumbers.add(candidate);
            }
        }
        System.out.println(missingNumbers);
        return missingNumbers.get(missingNumbers.size() -1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        KthMissingPositiveNumber kthMissingPositiveNumberUtil  = new KthMissingPositiveNumber();
        int[] nums = {2,3,4,7,11};
        int k = 5;
        //Output: 9
        //Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
        int kthMissingPositiveNumber = kthMissingPositiveNumberUtil.findKthPositive(nums, k);
        System.out.println("kthMissingPositiveNumber is "+ kthMissingPositiveNumber);
    }
}
