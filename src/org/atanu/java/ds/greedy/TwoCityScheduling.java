package org.atanu.java.ds.greedy;

//https://leetcode.com/problems/two-city-scheduling/
//Leetcode 1029

import java.util.Arrays;

//Video : https://www.youtube.com/watch?v=vtNoP43hGJA&t=495s
//Video : https://www.youtube.com/watch?v=d-B_gk_gJtQ&t=481s
public class TwoCityScheduling {

    public int twoCitySchedCost(int[][] costs) {

        int n = costs.length;
        //[0] will store the Cost if we chosee to Go B insetadt of A i.e (B - A)
        //[1] cost of A
        //[2] cost of B
        int[][] diffs = new int[n][3];
        for(int i = 0; i < costs.length; i++){
            diffs[i] = new int[]{costs[i][1] - costs[i][0], costs[i][0], costs[i][1]};
        }

        //Sort in ascending order
        //minim
        Arrays.sort(diffs, (a, b) -> a[0] - b[0]);
        int minCost = 0;

        //we can choose greedily first N/2 elements as that will have minimum cost if we go to B
        //Other way to look at it is if we take the the first N/2 elements if we sort in descending order
        //That means we if we go to A insteadt of B , it will make mor eprofit
        for(int i = 0; i < n; i++){
            if(i < n/2){
                minCost += diffs[i][2];
            }
            else{
                minCost += diffs[i][1];
            }
        }

        return minCost;
    }
}
