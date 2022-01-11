package org.atanu.java.ds.twopointer;

//https://leetcode.com/problems/max-consecutive-ones/
//LeetCode 485
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {

        int countMaxConsecutiveOnes = 0;
        int runningCount = 0;

        for(int a : nums){
            if(a == 1){
                runningCount++;
                countMaxConsecutiveOnes = Math.max(countMaxConsecutiveOnes, runningCount);
            }
            else{
                runningCount = 0;
            }
        }

        return countMaxConsecutiveOnes;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes maxConsecutiveOnes = new MaxConsecutiveOnes();
        int[] nums = {1,1,0,1,1,1};
        System.out.println("Max Consecutive Ones "+ maxConsecutiveOnes.findMaxConsecutiveOnes(nums));
    }
}
