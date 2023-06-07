package org.atanu.java.ds.binarysearch;

// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/
// Leetcode 1283
// Exactly sane as Koko Eating Banana https://leetcode.com/problems/koko-eating-bananas/
public class FindTheSmallestDivisorGivenAThreshold {

    public int smallestDivisor(int[] nums, int threshold) {

        int low = 1;
        int high = nums[0];

        for(int num : nums){
            high = Math.max(high, num);
        }

        while(low < high){
            int mid = low + (high - low) / 2;
            if(isPossible(nums, mid, threshold)){
                high = mid; // Need to go Left as , Need to find smallest
            }
            else{
                low = mid + 1;
            }
        }

        return high;
    }

    private boolean isPossible(int[] nums, int mid, int threshold){

        int divisionSum = 0;

        for(int num : nums){
            divisionSum += num / mid;
            if(num % mid != 0){
                divisionSum++;
            }
        }

        return divisionSum <= threshold;
    }

    public static void main(String[] args) {

        FindTheSmallestDivisorGivenAThreshold smallestDivisorGivenThreshold = new FindTheSmallestDivisorGivenAThreshold();
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;
        int result = smallestDivisorGivenThreshold.smallestDivisor(nums, threshold);
        System.out.println(result);
    }
}