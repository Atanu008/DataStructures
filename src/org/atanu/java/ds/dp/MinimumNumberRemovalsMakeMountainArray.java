package org.atanu.java.ds.dp;

import java.util.Arrays;

// Variation Of Longest Increasing Subsequence
//https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/
// LeetCode 1671
//https://www.youtube.com/watch?v=nW4Kx41G7XE
public class MinimumNumberRemovalsMakeMountainArray {

    // Calculate teh LIS and LDS
    // check for each element and take the length where LIS + LDS is max .
    // Suppose M element is part of increasing sequence and N is element is part of decreasing sequence
    // Max = M + N - 1 // because ith item is part of increasing as well decreasing sequence
    // So if we remove the remaining elements then we are left the max i.e the mountain array
    // So the answer is nums.length - Max
    public int minimumMountainRemovals(int[] nums) {
        int n=nums.length;
        int []LIS=new int [n]; // Longest Increasing Sequencing
        int []LDS=new int [n]; // Longest Decreasing Sequencing

        //Initialize DP Arrays
        Arrays.fill(LIS, 1);
        Arrays.fill(LDS, 1);
        // calculating maximum increasing subsequence for the left of an index.
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i])
                    LIS[i]=Math.max(LIS[i], LIS[j]+1);
            }
        }

        // calculating maximum increasing subsequence for the right of an index.
        for(int i=n-2;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(nums[j]<nums[i])
                    LDS[i]=Math.max(LDS[i], LDS[j]+1);
            }
        }

        // calculating the maximum number of elements that can be involved in a mountain array.
        int max=0;
        for(int i=0;i<n;i++){
		   /*
		       If the below conditional statement is not given, then strictly increasing or strictly
			   decreasing sequences will also be considered. It will hence fail in,
			   Test case: [10, 9, 8, 7, 6, 5, 4, 5, 4].
					---Thanks to @chejianchao for suggesting the test case.
				We need to make sure both the LIS on the left and right, ending at index i,
				has length > 1.
		   */
            if(LIS[i]>1&&LDS[i]>1) // if element nums[i] is a valid peak,
                max=Math.max(max,LIS[i]+LDS[i]-1); // -1 becuse ith Element counted twice(LIS and LDS)
        }

        //System.out.println(Arrays.toString(LIS));
        //System.out.println(Arrays.toString(LDS));

        // we need to delete the rest of the elements.
        return n-max;
    }

    public static void main(String[] args) {
        MinimumNumberRemovalsMakeMountainArray makeMountainArray = new MinimumNumberRemovalsMakeMountainArray();
        int[] nums = {2,1,1,5,6,2,3,1};
        /*
        Output: 3
        Explanation:
        One solution is to remove the elements at indices 0, 1, and 5, making the array nums = [1,5,6,3,1].
         */
        System.out.println("Minumum Deletion required is "+ makeMountainArray.minimumMountainRemovals(nums));
    }
}
