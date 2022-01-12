package org.atanu.java.ds.array;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
//LeetCode 325
//Same solution as below
//https://leetcode.com/problems/contiguous-array/
//LeetCode 525
public class MaximumSizeSubarraySumEqualsk {
    public int maxSubArrayLen(int[] nums, int k) {

        // key: cumulative sum until index i, value: Minimum i
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        //Edge case if the resulting Array starts with first index
        prefixSumMap.put(0,-1);
        int sum = 0;
        int maxLength = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){

            sum += nums[i];
            int target = sum - k;

            // K is between current i and where sum appeared
            if(prefixSumMap.containsKey(target)){
                maxLength = Math.max(maxLength, i - prefixSumMap.get(target));
            }
            //store cumulative sum in map, only if it is not seen
            //because only the earlier (thus shorter) subarray is valuable
            prefixSumMap.putIfAbsent(sum, i);
        }

        return maxLength != Integer.MIN_VALUE ? maxLength : 0;
    }

    public int maxSubArrayLenV2(int[] nums, int k) {

        // key: cumulative sum until index i, value: Minimum i
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int sum = 0;
        int maxLength = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){

            sum += nums[i];
            int target = sum - k;

            //case 1: cumulative sum is k staring from first index
            if(sum == k){
                maxLength = i+1;
            }
            // K is between current i and where sum appeared
            else if(prefixSumMap.containsKey(target)){
                maxLength = Math.max(maxLength, i - prefixSumMap.get(target));
            }
            //store cumulative sum in map, only if it is not seen
            //because only the earlier (thus shorter) subarray is valuable
            if(!prefixSumMap.containsKey(sum)){
                prefixSumMap.put(sum, i);
            }

            //prefixSumMap.putIfAbsent(sum, i); same as above

        }

        return maxLength != Integer.MIN_VALUE ? maxLength : 0;
    }

    public static void main(String[] args) {

    }
}
