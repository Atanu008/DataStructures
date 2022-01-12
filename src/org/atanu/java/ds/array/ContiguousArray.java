package org.atanu.java.ds.array;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/contiguous-array/
//LeetCode 525
//Video : https://www.youtube.com/watch?v=9ZyLjjk536U
public class ContiguousArray {

    public int findMaxLength(int[] nums) {

        int maxLength = 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int sum = 0;
        //This if the resulting sub array start with first index
        prefixSumMap.put(0,-1);

        for(int i = 0; i < nums.length; i++){
            sum += (nums[i] == 0) ? -1 : 1;

            //If the sum has been found that means from that point where it occured first . No contribition
            //made after that . sum from that point to current i is zero only
            if(prefixSumMap.containsKey(sum)){
                maxLength = Math.max(maxLength, i - prefixSumMap.get(sum));
            }
            //This is Important. record the index for the first time the sum appears
            //As we want the left boundary as left as possible
            //If we update every time we wont get the maximum length
            //--store cumulative sum in map, only if it is not seen
            //--because only the earlier (thus shorter) subarray is valuable, when we want to get the maxLen
            else{
                prefixSumMap.put(sum, i);
            }

        }
        return maxLength;
    }

    //Same as Above
    //Just we are storing prefixSumMap.put(0,-1);
    public int findMaxLengthV2(int[] nums) {

        int maxLength = 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum += (nums[i] == 0) ? -1 : 1;

            if(sum == 0){
                maxLength = i+1;
            }
            //If the sum has been found that means from that point where it occured first . No contribition
            //made after that . sum from that point to current i is zero only
            else if(prefixSumMap.containsKey(sum)){
                maxLength = Math.max(maxLength, i - prefixSumMap.get(sum));
            }
            //This is Important. record the index for the first time the sum appears
            //As we want the left boundary as left as possible
            //If we update every time we wont get the maximum length

            prefixSumMap.putIfAbsent(sum, i);

        }
        return maxLength;
    }

    //Brute Force
    public int findMaxLengthV3(int[] nums) {

        int maxLength = 0;
        int zeros = 0;
        int ones = 0;

        for(int i = 0; i < nums.length; i++){
            zeros = 0;
            ones = 0;
            for(int j = i; j < nums.length; j++){
                if(nums[j] == 0){
                    zeros++;
                }
                if(nums[j] == 1){
                    ones++;
                }
                if(zeros == ones){
                    maxLength = Math.max(maxLength, j-i+1);
                }

            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

    }
}
