package org.atanu.java.ds.array;

//https://leetcode.com/problems/minimum-average-difference/description/
//LeetCode 2256
public class MinimumAverageDifference {
    public int minimumAverageDifference(int[] nums) {
        //long for overflow
        long totalSum = 0;
        long currentPrefixSum = 0;
        //int currDifference = 0;
        int minimumAverageDifference = Integer.MAX_VALUE;
        int ans = -1;
        int n = nums.length;
        for(int num : nums){
            totalSum += num;
        }

        for(int i = 0; i < nums.length; i++){

            currentPrefixSum += nums[i];
            //long for overflow
            long leftPartAverage = currentPrefixSum / (i+1);
            long rightPartAverage = totalSum - currentPrefixSum;

            if(i != n - 1){
                rightPartAverage = rightPartAverage / (n - 1 - i);
            }

            int currDifference = (int) Math.abs(leftPartAverage - rightPartAverage);
            // If current difference of averages is smaller,
            // then current index can be our answer.
            if (currDifference < minimumAverageDifference) {
                minimumAverageDifference = currDifference;
                ans = i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,5,3,9,5,3};
        int index = new MinimumAverageDifference().minimumAverageDifference(nums);
        //Explanation:
        //- The average difference of index 0 is: |2 / 1 - (5 + 3 + 9 + 5 + 3) / 5| = |2 / 1 - 25 / 5| = |2 - 5| = 3.
        //- The average difference of index 1 is: |(2 + 5) / 2 - (3 + 9 + 5 + 3) / 4| = |7 / 2 - 20 / 4| = |3 - 5| = 2.
        //- The average difference of index 2 is: |(2 + 5 + 3) / 3 - (9 + 5 + 3) / 3| = |10 / 3 - 17 / 3| = |3 - 5| = 2.
        //- The average difference of index 3 is: |(2 + 5 + 3 + 9) / 4 - (5 + 3) / 2| = |19 / 4 - 8 / 2| = |4 - 4| = 0.
        //- The average difference of index 4 is: |(2 + 5 + 3 + 9 + 5) / 5 - 3 / 1| = |24 / 5 - 3 / 1| = |4 - 3| = 1.
        //- The average difference of index 5 is: |(2 + 5 + 3 + 9 + 5 + 3) / 6 - 0| = |27 / 6 - 0| = |4 - 0| = 4.
        //The average difference of index 3 is the minimum average difference so return 3.
        System.out.println(index);
    }
}
