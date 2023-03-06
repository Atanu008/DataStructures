package org.atanu.java.ds.dp;

import java.util.Arrays;

//Variation Of Longest Increasing Subsequence
//https://leetcode.com/problems/longest-increasing-subsequence/
//LeetCode 300



//Video : https://www.youtube.com/watch?v=7kURH3btcV4 (same idea as the code , just the sort is different)

//Intuition :
//Idea is to first sort the players by their age
//so that we don't have to always check both the scores and the age
//to see whether these two players can be in the same team.
//
//We sort first in the descending order of the ages.
//Now we know that for any player i, we can choose any player from 0 to i-1
//as long as that player has higher score than this i-th player.
//
//dp[i] stores the maximum score that can be obtained when i-th player is included
//and all other players are between indices 0 and i-1.
//Once we get the answer for all indices, we can simply find the max and that will be the answer.
public class BestTeamWithNoConflicts {
    public int bestTeamScore(int[] scores, int[] ages) {

        int n = scores.length;
        int[][] ageScorePairs = new int[n][2];
        for(int i = 0; i < n; i++){
            ageScorePairs[i][0] = ages[i];
            ageScorePairs[i][1] = scores[i];
        }
        // Sort in ascending order of age if tie by score.
        // score sorting does not matter I guess.
        Arrays.sort(ageScorePairs, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int[] dp = new int[n];
        dp[0] = ageScorePairs[0][1];
        int max = dp[0];
        for(int i = 1; i < n; i++){
            dp[i] = ageScorePairs[i][1];
            for(int j = 0; j < i; j++){
                //We only need to check the score , ages are already sorted
                // i is greater we can take any j (j is smaller) if jis score is less
                if(ageScorePairs[i][1] >= ageScorePairs[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + ageScorePairs[i][1]);
                }
            }
            max = Math.max(max, dp[i]); // Max when ith Team is included
        }
        return max;
    }
}
