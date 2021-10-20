package org.atanu.java.ds.dp;

//https://leetcode.com/problems/best-sightseeing-pair/
//LeetCode 1014
public class BestSightseeingPair {
    //Variation of best time to buy and sell stock . Here we need to keep track of Maximum
    //Update maximumLeft(values[i] + i) at each point, then use the current element value & its position to calculate the current maximum score.
    public int maxScoreSightseeingPair(int[] values) {

        int maxLeft = values[0] + 0 ;// values[i] + i //i is starting from 0
        int maxScore = Integer.MIN_VALUE;
        for(int j = 1; j < values.length; j++){
            maxScore = Math.max(maxScore, maxLeft + values[j] - j);
            //Update maxLeft at Each Step
            maxLeft = Math.max(maxLeft, values[j] + j);
        }

        return maxScore;
    }

    public static void main(String[] args) {
        BestSightseeingPair bestSightseeingPair = new BestSightseeingPair();
        int[] values = {8,1,5,2,6};
        //Explanation: i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
        System.out.println("Best Sightseeing Pair "+ bestSightseeingPair.maxScoreSightseeingPair(values));
    }
}
