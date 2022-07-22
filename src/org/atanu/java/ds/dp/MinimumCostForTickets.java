package org.atanu.java.ds.dp;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/minimum-cost-for-tickets/
//LeetCode 983
public class MinimumCostForTickets {

    //We track the minimum cost for all calendar days in dp. For non-travel days,
    //the cost stays the same as for the previous day.
    //For travel days, it's a minimum of yesterday's cost plus single-day ticket, dp[i-1] + cost[1]
    //or cost for 8 days ago plus 7-day pass, dp[i-7] + cost[1]
    //or cost 31 days ago plus 30-day pass. dp[i-30] + cost[2]
    public int mincostTickets(int[] days, int[] costs) {

        int[] dp = new int[366];
        Set<Integer> daySet = new HashSet<>();
        for(int d : days){
            daySet.add(d);
        }

        for(int i = 1; i < 366; i++){

            //The trick Math.max(0, i -7) is to avoid negative index .
            //suppose for day one we can not go to 1 -7 = -6 right . So lets take 0 . Math.max(0, -6) is 0 :)
            // So defult value of zeroth index will be taken and that is offcouurse zero.
            if(daySet.contains(i)){
                dp[i] = Math.min(dp[Math.max(0, i - 1)] + costs[0], dp[Math.max(0, i - 7)] + costs[1]);
                dp[i] = Math.min(dp[i], dp[Math.max(0, i - 30)] + costs[2]);
            }
            else{
                dp[i] = dp[i-1];
            }
        }

        return dp[365];
    }

    //Recur sive Solution
    public int mincostTicketsV2(int[] days, int[] costs) {

        Integer[] dp = new Integer[366];
        Set<Integer> daySet = new HashSet<>();
        for(int d : days){
            daySet.add(d);
        }
        return minCost(costs, daySet, dp, 1);
    }

    private int minCost(int[] costs, Set<Integer> daySet, Integer[] dp, int day){

        if(day > 365){
            return 0;
        }

        if(dp[day] != null){
            return dp[day];
        }

        int ans = 0;
        //You are travelling this day
        //Lets explore possibilities by bying passes for each type and take the munumum
        //dp(i)=min(dp(i+1)+costs[0],dp(i+7)+costs[1],dp(i+30)+costs[2])
        if(daySet.contains(day)){

            ans = Math.min( (costs[0] + minCost(costs, daySet, dp, day + 1)), (costs[1] + minCost(costs, daySet, dp, day + 7)));
            ans = Math.min(ans , costs[2] + minCost(costs, daySet, dp, day + 30));
        }
        else{
            ans = minCost(costs, daySet, dp, day + 1); // if you don't have to travel today, lets try to buy a pass next day
        }

        return dp[day] = ans;
    }


}
