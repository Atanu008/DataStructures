package org.atanu.java.ds.backtracking;

//LeetCode 1863
//https://leetcode.com/problems/sum-of-all-subset-xor-totals/
public class SumOfAllSubsetXORTotals {
    public int subsetXORSum(int[] nums) {
        return backtrack(nums, 0, 0);
    }

    private int backtrack(int[] nums, int index, int curXor){
        if(index == nums.length){
            return curXor;
        }

        int withCurrentIndex = backtrack(nums, index+1, curXor^nums[index]);
        int withoutCurrentIndex = backtrack(nums, index+1, curXor);

        return withCurrentIndex + withoutCurrentIndex;
    }

    public static void main(String[] args) {
        SumOfAllSubsetXORTotals sum = new SumOfAllSubsetXORTotals();
        int[] nums = {5,1,6};
        int xorSum = sum.subsetXORSum(nums);
        System.out.println("XOR Sum :"+ xorSum);
    }
}
