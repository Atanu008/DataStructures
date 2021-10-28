package org.atanu.java.ds.array;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-increment-to-make-array-unique/
//LeetCode 945
public class MinimumIncrementToMakeArrayUnique {

    public int minIncrementForUnique(int[] A) {
        if(A == null || A.length == 0){
            return 0;
        }
        Arrays.sort(A);
        int res = 0, prev = A[0];
        for(int i = 1; i < A.length; i++){
            int expect = prev + 1;
            res += A[i] > expect ? 0 : expect - A[i];
            prev = Math.max(expect, A[i]);
        }
        return res;
    }

    //same code . syntax change only
    public int minIncrementForUniqueV2(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        int prev = nums[0];
        for(int i = 1; i < nums.length; i++){
            int exepected = prev + 1;
            if(nums[i] <= exepected){
                result += exepected - nums[i];
            }
            prev = Math.max(nums[i], exepected);
        }

        return result;
    }

    public static void main(String[] args) {
        MinimumIncrementToMakeArrayUnique unique = new MinimumIncrementToMakeArrayUnique();
        int[] nums = {3,2,1,2,1,7};
        System.out.println("Minimum Increment needed is " +unique.minIncrementForUnique(nums));

    }
}
