package org.atanu.java.ds.dp;

import java.util.Arrays;

//https://leetcode.com/problems/longest-mountain-in-array/
//LeetCode 845
public class LongestMountainInArray {



    //3 Pass Solution
    public int longestMountain(int[] arr) {
        //Base case .
        //It rquires atleast 3 element to be mountain array
        if(arr.length < 3){
            return 0;
        }

        int[] LIS = lis(arr);
        int[] LDS = lds(arr);

        int longestMountain = 0;
        for(int i = 0; i < arr.length; i++){
            //if LIS and LDS is 1 then there is no Mountain
            if(LIS[i] != 1 && LDS[i] != 1){
                longestMountain = Math.max(longestMountain, LIS[i] + LDS[i] - 1);
            }
        }

        return longestMountain;
    }

    //One Pass
    //Same kinda intuition
    public int longestMountainV2(int[] arr) {
        //Base case .
        //It rquires atleast 3 element to be mountain array
        if(arr.length < 3){
            return 0;
        }

        int longestMountain = 0;
        int i = 1;

        while(i < arr.length){

            //Skip the same elements
            while(i < arr.length && arr[i] == arr[i-1]){
                i++;
            }

            //count Up Hill
            int up = 0;
            while(i < arr.length && arr[i] > arr[i-1]){
                i++;
                up++;
            }
            //Count Down Hill
            int down = 0;
            while(i < arr.length && arr[i] < arr[i-1]){
                i++;
                down++;
            }

            //Consider if a valid Mountain.
            //there should be an up hill and down hill
            if(up > 0 && down > 0){
                longestMountain = Math.max(longestMountain, up + down + 1);
            }

        }

        return longestMountain;
    }

    private int[] lis(int[] arr){

        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        //Here Longest Inceasing seqeunce is just for consecutive elements
        //So we dont need another loop . O(n) is fine
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > arr[i-1]){
                dp[i] = dp[i-1] + 1;
            }
        }

        return dp;
    }

    private int[] lds(int[] arr){

        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        //Here Longest Inceasing seqeunce is just for consecutive elements
        //So we dont need another loop . O(n) is fine
        for(int i = n-2; i >= 0; i--){
            if(arr[i] > arr[i+1]){
                dp[i] = dp[i+1] + 1;
            }
        }

        return dp;
    }



}
