package org.atanu.java.ds.binarysearch;

// https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/description/
// Leetcode 1300

public class SumOfMutatedArrayClosestToTarget {
    public int findBestValue(int[] arr, int target) {

        int low = 0;
        int high = Integer.MIN_VALUE;
        int sum = 0;
        for(int a : arr){
            high = Math.max(a, high);
            sum += a;
        }

        if(sum == target){
            return high;
        }

        int res = 0;
        int diff = Integer.MAX_VALUE;
        // The answer would lie between 0 and maximum value in the array.
        while(low <= high){

            int mid = low + (high - low) / 2;
            int mutatedSum = getMutatedSum(arr, mid);

            if(target > mutatedSum){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
            // If current difference is less than diff || current difference==diff but mid < res.(choose the smaller one.)
            if((Math.abs(target - mutatedSum) < diff) || (Math.abs(target - mutatedSum) == diff && mid < res)){
                diff = Math.abs(target - mutatedSum);
                res = mid;
            }
        }

        return res;
    }

    private int getMutatedSum(int[] arr, int mid){

        int sum = 0;
        for(int a : arr){
            sum +=  Math.min(a, mid);
        }

        return sum;
    }

    public static void main(String[] args) {
        SumOfMutatedArrayClosestToTarget sumOfMutatedArrayClosestToTarget = new SumOfMutatedArrayClosestToTarget();
        int[] arr = {4,9,3};
        int target = 10;
        System.out.println(sumOfMutatedArrayClosestToTarget.findBestValue(arr, target));
    }
}
