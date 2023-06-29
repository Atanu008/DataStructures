package org.atanu.java.ds.array;

// https://leetcode.com/problems/find-pivot-index/description/
// Leetcode 724

// This problem is same as Equilibrium index of an array
// https://www.geeksforgeeks.org/equilibrium-index-of-an-array/
public class FindPivotIndex {
    // O(N)
    public int pivotIndex(int[] nums) {
        int sum = 0;

        for(int a : nums){
            sum += a;
        }
        int leftSum = 0;
        for(int i = 0; i < nums.length; i++){
            // deducting the current current element
            // Sum will point to right Sum
            sum -= nums[i];
            if(leftSum == sum){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    // Prefix Sum Solution
    public int pivotIndex_v2(int[] arr) {

        /* Check for indexes one by one until
           an equilibrium index is found */
        for (int i = 0; i < arr.length; i++) {

            int leftSum = 0;
            int rightSum = 0;

            /* get left sum */
            for (int j = 0; j < i; j++) {
                leftSum += arr[j];
            }

            /* get right sum */
            for (int k = i + 1; k < arr.length; k++) {

                rightSum += arr[k];
            }

			 /* if leftsum and rightsum are same,
            then we are done */
            if (leftSum == rightSum)
                return i;
        }

        /* return -1 if no equilibrium index is found */
        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex findPivotIndex = new FindPivotIndex();
        int[] nums = {1,7,3,6,5,6};
        //Output: 3
        //Explanation:
        //The pivot index is 3.
        //Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
        //Right sum = nums[4] + nums[5] = 5 + 6 = 11
        System.out.println(findPivotIndex.pivotIndex(nums));
        System.out.println(findPivotIndex.pivotIndex_v2(nums));
        nums = new int[]{1, -1, 4};
        //Input: nums = [1,-1,4]
        //Output: 2
        //Explanation: The sum of the numbers before index 2 is: 1 + -1 = 0
        //The sum of the numbers after index 2 is: 0
        System.out.println(findPivotIndex.pivotIndex(nums));
        System.out.println(findPivotIndex.pivotIndex_v2(nums));
    }
}
