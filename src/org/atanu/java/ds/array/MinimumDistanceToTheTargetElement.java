package org.atanu.java.ds.array;

//https://leetcode.com/problems/minimum-distance-to-the-target-element/
//LeetCode 1848
public class MinimumDistanceToTheTargetElement {

    public int getMinDistance(int[] nums, int target, int start) {

        int minDistance = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){

            if(nums[i] == target){
                minDistance = Math.min(minDistance, Math.abs(start - i));
            }
        }

        return minDistance;
    }
}
