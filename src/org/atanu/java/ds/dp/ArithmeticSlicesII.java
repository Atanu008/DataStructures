package org.atanu.java.ds.dp;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/arithmetic-slices-ii-subsequence/
//LeetCode 446
// Video : https://www.youtube.com/watch?v=XjLT4TaXsgw&t=1983s
public class ArithmeticSlicesII {

    public int numberOfArithmeticSlices(int[] nums) {

        Map<Integer, Integer>[] maps = new HashMap[nums.length];
        int ans = 0;

        maps[0] = new HashMap<>();
        for(int i = 1; i < nums.length; i++){
            maps[i] = new HashMap<>();

            for(int j = 0; j < i; j++){
                long delta = (long)nums[i] - nums[j];
                if(delta <= Integer.MIN_VALUE || delta >= Integer.MAX_VALUE){
                    continue;
                }
                int difference = (int)delta;
                int apEndingAtJ = maps[j].getOrDefault(difference, 0);
                int apEndingAti = maps[i].getOrDefault(difference, 0);

                ans += apEndingAtJ;
                maps[i].put(difference, apEndingAtJ + apEndingAti + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        ArithmeticSlicesII arithmeticSlicesII = new ArithmeticSlicesII();
        int nums[] = {2,4,6,8,10};
        //Output: 7
        //Explanation: All arithmetic subsequence slices are:
        //[2,4,6]
        //[4,6,8]
        //[6,8,10]
        //[2,4,6,8]
        //[4,6,8,10]
        //[2,4,6,8,10]
        //[2,6,10]
        System.out.println("arithmetic subsequences is "+arithmeticSlicesII.numberOfArithmeticSlices(nums));

    }
}
