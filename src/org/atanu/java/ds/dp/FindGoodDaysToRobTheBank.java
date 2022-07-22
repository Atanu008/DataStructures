package org.atanu.java.ds.dp;

//https://leetcode.com/problems/find-good-days-to-rob-the-bank/
//LeetCode 2100

import java.util.ArrayList;
import java.util.List;

public class FindGoodDaysToRobTheBank {

    //Same Idea as Longest Mountain in Array(LeetCode 845)
    //Instead here we have down Mountain Peak
    //So we first do Longest Decreasing Sequence
    public List<Integer> goodDaysToRobBank(int[] security, int time) {

        int[] LDS = lds(security);
        int[] LIS = lis(security);

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < security.length; i++){
            if(LDS[i] >= time && LIS[i] >= time){
                list.add(i);
            }
        }

        return list;
    }

    //Don't need two loop as we only consider consecutive elements
    private int[] lds(int[] security){
        int n = security.length;
        int[] dp = new int[n];
        for(int i = 1; i < n; i++){
            if(security[i] <= security[i-1]){
                dp[i] = dp[i-1] + 1;
            }
        }

        return dp;
    }

    private int[] lis(int[] security){
        int n = security.length;
        int[] dp = new int[n];

        for(int i = n-2; i >= 0; i--){
            if(security[i] <= security[i+1]){
                dp[i] = dp[i+1] + 1;
            }
        }

        return dp;
    }

    public static void main(String[] args) {
        FindGoodDaysToRobTheBank findGoodDaysToRobTheBank = new FindGoodDaysToRobTheBank();
        int[] arr = {5,3,3,3,5,6,2};
        int time = 2;
        List<Integer> goodDays = findGoodDaysToRobTheBank.goodDaysToRobBank(arr, time);
        System.out.println(goodDays);

    }
}
