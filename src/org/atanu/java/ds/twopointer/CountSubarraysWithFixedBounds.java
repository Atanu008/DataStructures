package org.atanu.java.ds.twopointer;

//https://leetcode.com/problems/count-subarrays-with-fixed-bounds/description/
//LeetCode 2444
//Video : https://www.youtube.com/watch?v=n71-w2Hc-mg
public class CountSubarraysWithFixedBounds {
    public long countSubarrays(int[] nums, int minK, int maxK) {

        // startOfSubArrayIndex will always point to start of a valid sub array
        // leftMinKIndex Or leftMaxKIndex will pooint to the minK and maxK indexes
        // Now we need to take the first/minumum of leftMinKIndex, leftMaxKIndex
        //There are min(leftMinKIndex, leftMaxKIndex) - startOfSubArrayIndex + 1 choices
        // suppose minK = 2 maxK = 8
        // muns = 9 6 3 4 2 7 8 9
        // for the sub array {6 3 4 2 7 8} - its valid minK = 2 , maxK = 8
        // startOfSubArrayIndex = 1;
        // leftMinKIndex = 4
        // leftMaxKIndex = 6
        // so the number of sub array can be formed like
        // 6 3 4 2 7 8
        // 3 4 2 7 8
        // 4 2 7 8
        // 2 7 8
        // so Total 4 . i.e  4 - 1 + 1 = 4(min(leftMinKIndex, leftMaxKIndex) - startOfSubArrayIndex + 1 )
        int startOfSubArrayIndex = 0;
        int leftMinKIndex = -1;
        int leftMaxKIndex = -1;
        long count = 0;
        for(int i = 0; i < nums.length; i++){
            // invalid sub array, start over
            if(nums[i] < minK || nums[i] > maxK){
                startOfSubArrayIndex = i+1;
                leftMinKIndex = -1;
                leftMaxKIndex = -1;
            }

            if(nums[i] == minK){
                leftMinKIndex = i;
            }
            if(nums[i] == maxK){
                leftMaxKIndex = i;
            }

            count += Math.max(0, Math.min(leftMinKIndex, leftMaxKIndex) - startOfSubArrayIndex + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        CountSubarraysWithFixedBounds countSubarraysWithFixedBounds = new CountSubarraysWithFixedBounds();
        int[] nums = {1,3,5,2,7,5};
        int minK = 1;
        int maxK = 5;
        long count = countSubarraysWithFixedBounds.countSubarrays(nums, minK, maxK);
        //Output: 2
        //Explanation: The fixed-bound subarrays are [1,3,5] and [1,3,5,2].
        System.out.println(count);
    }
}
