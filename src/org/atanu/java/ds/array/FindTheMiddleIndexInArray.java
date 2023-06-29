package org.atanu.java.ds.array;

// https://leetcode.com/problems/find-the-middle-index-in-array/description/
// Leetcode 1991
// This Question is exactly same as Find Pivot Index
// i.e https://leetcode.com/problems/find-pivot-index/

public class FindTheMiddleIndexInArray {

    public int findMiddleIndex(int[] nums) {

        int sum = 0;

        for(int a : nums){
            sum += a;
        }
        int leftSum = 0;
        for(int i = 0; i < nums.length; i++){
            //right sum at i = sum - leftSum - currentElement
            if(leftSum == sum - leftSum - nums[i]){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {

        FindTheMiddleIndexInArray findTheMiddleIndexInArray = new FindTheMiddleIndexInArray();
        int[] nums = {2,3,-1,8,4};
        //Output: 3
        //Explanation: The sum of the numbers before index 3 is: 2 + 3 + -1 = 4
        //The sum of the numbers after index 3 is: 4 = 4
        System.out.println(findTheMiddleIndexInArray.findMiddleIndex(nums));

        nums = new int[]{1, -1, 4};
        //Input: nums = [1,-1,4]
        //Output: 2
        //Explanation: The sum of the numbers before index 2 is: 1 + -1 = 0
        //The sum of the numbers after index 2 is: 0
        System.out.println(findTheMiddleIndexInArray.findMiddleIndex(nums));

    }
}
