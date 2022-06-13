package org.atanu.java.ds.twopointer;

import java.util.Arrays;

//https://leetcode.com/problems/bag-of-tokens/
//LeetCode 948
//Video : https://www.youtube.com/watch?v=1GubKefOabc
public class BagOfTokens {
    //Always aim for highest point
    //Sort the tokens so we can buy from lowest & sell from highest which means =>
    //If we have enough power, no worries. Just lose token[l(eft)], and increase score by 1.
    //Else If we have at least 1 score and we are not in the last processed token, gain token[r(ight)] and decrease score by 1.
    //Otherwise, we are finished.
    public int bagOfTokensScore(int[] tokens, int power) {

        Arrays.sort(tokens);
        int left = 0; //will point to the the smallest token as the toneks are sorted now
        int right = tokens.length - 1; //will point to the the largest token as the toneks are sorted now

        int points = 0;
        int maxPointsGained = 0;
        while (left <= right) {

            if (tokens[left] <= power) {

                points++;
                power -= tokens[left++]; //
                maxPointsGained = Math.max(maxPointsGained, points);
            } else if (points > 0) {
                points--;
                power += tokens[right--];
            } else {
                break; // basically return maxPointsGained;
            }
        }

        return maxPointsGained;
    }
}
