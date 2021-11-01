package org.atanu.java.ds.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Similar Solution as Longest Increasing Subsequence
//https://leetcode.com/problems/find-the-longest-valid-obstacle-course-at-each-position/
//LeetCode 1964
//https://leetcode.com/problems/find-the-longest-valid-obstacle-course-at-each-position/discuss/1390159/C%2B%2BPython-Same-with-Longest-Increasing-Subsequence-problem-Clean-and-Concise
public class LongestValidObstacleCourseAtEachPosition {

    //Binary Search Solution - O(NlogN)
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {

        List<Integer> lisSub = new ArrayList<>();
        int[] result = new int[obstacles.length];
        for(int i = 0; i < obstacles.length; i++){
            int curr = obstacles[i];
            if(lisSub.isEmpty() || curr >= lisSub.get(lisSub.size() -1)){
                lisSub.add(curr);
                result[i] = lisSub.size();
            }
            else{
                int insertIndex = upperBoundBinarySearch(lisSub, curr);
                lisSub.set(insertIndex, curr);
                result[i] = insertIndex + 1;
            }
        }
        return result;
    }

    private int upperBoundBinarySearch(List<Integer> nums, int target) {
        int low = 0;
        int high = nums.size() - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums.get(mid) <= target) {
                low = mid + 1;
            } else {
                high = mid; //To Go left High has to move(help) left
            }
        }
        return high;
    }

    //O(N^2)
    //TLE for two Test cases in LeetCode
    public int[] longestObstacleCourseAtEachPositionV2(int[] obstacles) {

        int n = obstacles.length;
        int[] dp = new int[n];
        //Base Case. For one element Subsequence is always one
        
        int maxLength = 1;
        for(int i = 1; i < n; i++){
            //Base Case. For one element Subsequence is always one
            dp[i] = 1;
            //Check for all previous elements.
            //If (nums[i] > nums[j] then take the length of jth element(i.e dp[j]) + 1(means teh ith element)
            //Take the maximum while evluating all js
            for(int j = 0; j < i; j++){
                if(obstacles[i] >= obstacles[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                    maxLength = Math.max(maxLength, dp[i]);
                }

            }
        }
        return dp;
    }

    public static void main(String[] args) {
        LongestValidObstacleCourseAtEachPosition obstacleCourseAtEachPosition = new LongestValidObstacleCourseAtEachPosition();
        int[] obstacles = {1,2,3,2};
        System.out.println(Arrays.toString(obstacleCourseAtEachPosition.longestObstacleCourseAtEachPosition(obstacles)));
        System.out.println(Arrays.toString(obstacleCourseAtEachPosition.longestObstacleCourseAtEachPositionV2(obstacles)));
    }
}
