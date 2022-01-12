package org.atanu.java.ds.twopointer;

//https://leetcode.com/problems/subarray-product-less-than-k/
//LeetCode 713
//Kind of similar solution as LeetCode 209 https://leetcode.com/problems/minimum-size-subarray-sum/
public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //Base case
        //Zero product is not possible
        //Strict Less than One product is also not possibe with all the positive number
        if(k <= 1){
            return 0;
        }
        int countSubArray = 0;
        int windowEnd = 0;
        int windowStart = 0;
        int product = 1;

        while(windowEnd < nums.length){

            product *= nums[windowEnd];

            while(product >= k){
                product /= nums[windowStart];
                windowStart++;
            }

            //Trick Part
            //Suppose we have an array 123 and we include 4 Now {1,2,3,4}
            //totatl sub Arrays {4}, {3,4} , {2,3,4}, {1,2,3,4} : Total 4
            // Right  = 4 , left = 1 here
            // Now the formula to derive no of sub arrays : Right - left + 1
            // 4 -1 + 1 = 4
            countSubArray +=  windowEnd - windowStart + 1;
            windowEnd++;
        }

        return countSubArray;
    }

    public static void main(String[] args) {
        SubarrayProductLessThanK subarrayProductLessThanK = new SubarrayProductLessThanK();
        int[] nums = {10,5,2,6};
        int k = 100;
        //Output: 8
        //Explanation: The 8 subarrays that have product less than 100 are:
        //[10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
        //Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
        System.out.println("subarrays that have product less than "+ k +" are: "
                + subarrayProductLessThanK.numSubarrayProductLessThanK(nums, k));
    }
}
