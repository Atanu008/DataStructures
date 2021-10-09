package org.atanu.java.ds.binarysearch;


//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
//LeetCode 1011
public class CapacityToShipPackagesWithinDDays {

    public int shipWithinDays(int[] weights, int days) {

        int sum = 0;
        int maxWeight = 0;

        for (int a : weights) {
            sum += a;
            maxWeight = Math.max(maxWeight, a);
        }

        // Low can not be less than the maximum elemnt of the Array
        // Can be set to zero
        int low = maxWeight;
        // If one day then the max range would be summation of all the elements
        int high = sum;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(weights, mid, days)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean isPossible(int[] weights, int mid, int days) {

        int requiredDays = 1;
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            if (sum > mid) {
                //we need more days to accomodate the mid
                //Add this weight to sum
                requiredDays++;
                sum = weights[i];
            }
        }
        return requiredDays <= days;
    }

    // Template (low < high) is being used
    // We need to move left as we need minimum ; so we need to rely upon high
    // similar to First Position Or firstbadversion
    public int shipWithinDaysV2(int[] weights, int days) {

        int sum = 0;
        int maxWeight = 0;

        for(int a: weights){
            sum += a;
            maxWeight = Math.max(maxWeight, a);
        }

        // Low can not be less than the maximum elemnt of the Array
        // Can be set to zero
        int low = maxWeight;
        // If one day then the max range would be summation of all the elements
        int high = sum;

        while(low < high){

            int mid = low + (high - low)/2;
            if(ok(weights, mid, days)){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }

        return high;
    }

    //Can we ship all the packages within time if each ship can carry 'mid' weight
    //FFFF'T'TTTTT
    private boolean ok(int[] weights, int mid, int days) {
        int requiredDays = 1, curr = 0;
        for (int w : weights) {
            // if a single weight itself is bigger than the overall capacity, we can't ship
            if (w > mid) {
                return false;
            }
            if (curr + w > mid) {
                requiredDays++;
                curr = 0;
            }
            curr += w;
        }
        return requiredDays <= days;
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int days = 5;
        CapacityToShipPackagesWithinDDays capacity = new CapacityToShipPackagesWithinDDays();
        System.out.println("Capacity To Ship Packages Within D Days "+ capacity.shipWithinDays(weights,days));
        System.out.println("Capacity To Ship Packages Within D Days "+ capacity.shipWithinDaysV2(weights,days));
    }
}
