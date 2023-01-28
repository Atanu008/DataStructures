package org.atanu.java.ds.binarysearch;

//https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/description/
//Leetcode 1760

//Minimum possible penalty can be 1,
//and max possible penalty can be eq to max element. This is the possible range of our answer.
//If we have a helper function which tells if it is possible to get a certain penalty considering
//the max number of operations allowed, we can perform binary search on above range to minimize the possible penalty.
//helper functon
//It calculates the total number of operations required to make every number less than or eq to the current assumed penalty.
//If the total ops required is less than or equal to the given limit of maxOperations, it is possible.
//TC : o(nlogn)
//SC: o(1)
public class MinimumLimitOfBallsInABag {

    public int minimumSize(int[] nums, int maxOperations) {

        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int a : nums){
            high = Math.max(high, a);
        }

        while(low < high){

            int mid = low + (high - low) / 2;
            if(isPossible(nums, maxOperations, mid)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }

        return high;
    }

    private boolean isPossible(int[] nums, int maxOperations, int penalty){

        int requiredOperations = 0;
        for(int num : nums){
            int minCut = num / penalty;
            if(num % penalty == 0){
                minCut--;
            }

            requiredOperations += minCut;
        }

        return requiredOperations <= maxOperations;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,4,8,2};
        System.out.println(new MinimumLimitOfBallsInABag().minimumSize(nums,4));
    }
}
