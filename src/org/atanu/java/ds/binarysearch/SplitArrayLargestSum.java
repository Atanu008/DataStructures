package org.atanu.java.ds.binarysearch;

////Same as Book Allocation and CapacityToShipPackagesWithinDDays
//https://leetcode.com/problems/split-array-largest-sum/
//LeetCode 410
public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int m) {

        int sum = 0;
        int max = 0;
        for (int a : nums) {
            sum += a;
            max = Math.max(max, a);
        }

        // Low can not be less than the maximum elemnt of the Array
        // Can be set to zero
        int low = max;
        // If one day then the max range would be summation of all the elements
        int high = sum;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(nums, mid, m)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private boolean isPossible(int[] nums, int mid, int m) {

        int requiredSubArray = 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > mid) {
                //we need more days to accomodate the mid
                //Add this weight to sum
                requiredSubArray++;
                sum = nums[i];
            }
        }
        return requiredSubArray <= m;
    }

    // Template (low < high) is being used
    // We need to move left as we need minimum ; so we need to rely upon high
    // similar to First Position Or firstbadversion
    public int splitArrayV2(int[] nums, int m) {

        int sum = 0;
        int max = 0;
        for (int a : nums) {
            sum += a;
            max = Math.max(max, a);
        }

        // Low can not be less than the maximum elemnt of the Array
        // Can be set to zero
        int low = max;
        // If one day then the max range would be summation of all the elements
        int high = sum;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (ok(nums, mid, m)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return high;
    }

    private boolean ok(int[] nums, int mid, int m) {

        int requiredSubArray = 1;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            if(sum + nums[i] > mid){
                requiredSubArray++;
                sum = 0;
            }

            sum += nums[i];
        }
        return requiredSubArray <= m;
    }

    public static void main(String[] args) {
        SplitArrayLargestSum splitArrayLargestSum = new SplitArrayLargestSum();
        int[] nums = {7,2,5,10,8};
        int m = 2;
        System.out.println("largest sum among the "+  m +"subarrays is " + splitArrayLargestSum.splitArray(nums,m));
        System.out.println("largest sum among the "+  m +"subarrays is " + splitArrayLargestSum.splitArrayV2(nums,m));
    }
}
