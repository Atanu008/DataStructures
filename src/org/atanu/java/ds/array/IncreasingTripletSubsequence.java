package org.atanu.java.ds.array;

//https://leetcode.com/problems/increasing-triplet-subsequence/
//LeetCode 334
public class IncreasingTripletSubsequence {
    // start with two largest values,
    // as soon as we find a number bigger than both, while both have been updated, return true.
    //For [1, 3, 0, 5] we will eventually arrive at big = 3 and small = 0 so big may come after small
    //However, the solution still works, because big only gets updated when there exists a small that comes before it.
    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for(int a : nums){
            // update small if n is smaller than both
           if(a <= small){
               small = a;
           }
           // update big only if greater than small but smaller than big
           else if(a <= mid){
               mid = a;
           }
           else return true; // return if you find a number bigger than both
        }
        return false;
    }

    //Brute Force O(n^3)
    public boolean increasingTripletV2(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n - 2; i++){
            for(int j = i+1; j < n - 1; j++){
                for(int k = j+1; k < n; k++){
                    if(nums[k] > nums[j] && nums[j] > nums[i]){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
