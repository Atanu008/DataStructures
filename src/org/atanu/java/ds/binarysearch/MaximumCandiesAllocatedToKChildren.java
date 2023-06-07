package org.atanu.java.ds.binarysearch;

// https://leetcode.com/problems/maximum-candies-allocated-to-k-children/description/
// Leetcode 2226

public class MaximumCandiesAllocatedToKChildren {

    public int maximumCandies(int[] candies, long k) {

        int low = 0;
        int high = Integer.MIN_VALUE;

        for(int candy : candies){
            high = Math.max(candy, high);
        }

        while(low < high) {

            int mid = low + (high - low) / 2 + 1;

            if(isPossibleToDivide(candies, mid, k)) {
                low = mid;
            }
            else{
                high = mid - 1;
            }
        }

        return low;
    }

    private boolean isPossibleToDivide(int[] candies, int mid, long k){

        long split = 0;
        for(int candy : candies) {
            split += candy / mid; // split with mid number of candies
        }

        return split >= k;
    }

    public static void main(String[] args) {
        MaximumCandiesAllocatedToKChildren maximumCandiesAllocatedToKChildren = new MaximumCandiesAllocatedToKChildren();
        //Input: candies = [5,8,6], k = 3
        //Output: 5
        // Explanation: We can divide candies[1] into 2 piles of size 5 and 3, and candies[2] into 2 piles of size 5 and 1.
        // We now have five piles of candies of sizes 5, 5, 3, 5, and 1. We can allocate the 3 piles of size 5 to 3 children.
        // It can be proven that each child cannot receive more than 5 candies.

        int[] candies = {5,8,6};
        int k = 3;
        int maxNumberOfCandies = maximumCandiesAllocatedToKChildren.maximumCandies(candies, k);
        System.out.println(maxNumberOfCandies);
    }
}
