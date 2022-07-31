package org.atanu.java.ds.binarysearch;

import java.util.Random;

//https://leetcode.com/problems/random-pick-with-weight/
//LeetCode 528
//Video Idea : https://www.youtube.com/watch?v=fWS0TCcr-lE&t=298s

//Use accumulated freq array to get idx.
//w[] = {2,5,3,4} => prefixSum[] = {2,7,10,14}
//then get random val random.nextInt(14)+1, idx is in range [1,14]
//
//idx in [1,2] return 0
//idx in [3,7] return 1
//idx in [8,10] return 2
//idx in [11,14] return 3
//then become LeetCode 35. Search Insert Position

//Also suppose two elements [2, 14] => prefixSum [2, 16]
//idx in [1,2] return 0
//idx in [3,16] return 1
public class RandomPickWithWeight {

    int[] prefixSum;
    Random random;
    public RandomPickWithWeight(int[] w) {
        random = new Random();
        prefixSum = new int[w.length];
        prefixSum[0] = w[0];
        for(int i = 1; i < w.length; i++){
            prefixSum[i] = prefixSum[i-1] + w[i];
        }
    }

    public int pickIndex() {
        int len = prefixSum.length;
        int target = random.nextInt(prefixSum[len - 1]) + 1;

        int low = 0;
        int high = len - 1;

        while(low < high){

            int mid = low + (high - low) / 2;
            if(prefixSum[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }

        return high;
    }
}
