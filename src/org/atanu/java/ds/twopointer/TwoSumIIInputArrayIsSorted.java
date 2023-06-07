package org.atanu.java.ds.twopointer;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
// Leetcode 167

public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {

        int low = 0;
        int high = numbers.length -1;

        while(low < high){

            int expectedTarget = numbers[low] + numbers[high];
            if(expectedTarget == target){
                return new int[]{low+1, high +1};
            }

            if(expectedTarget < target){
                low++;
            }
            else{
                high--;
            }
        }

        return new int[]{};
    }
}
