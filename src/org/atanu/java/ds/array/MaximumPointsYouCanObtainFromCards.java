package org.atanu.java.ds.array;

public class MaximumPointsYouCanObtainFromCards {

    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;
        int leftCardSum = 0;

        for(int i = 0; i < k ; i++){
            leftCardSum += cardPoints[i];
        }

        // take all k cards from the beginning
        int maxScore = leftCardSum;
        int rightCardSum = 0;

        for(int i = 0; i < k; i++){
            leftCardSum -= cardPoints[k-1-i];
            rightCardSum += cardPoints[n-1-i];
            maxScore = Math.max(maxScore, leftCardSum + rightCardSum);
        }

        /*
        //This also can be Done
        // take i from the beginning and k - i from the end
        for (int i = k - 1; i >= 0; i--) {
            rearScore += cardPoints[n - (k - i)];
            frontScore -= cardPoints[i];
            int currentScore = rearScore + frontScore;
            maxScore = Math.max(maxScore, currentScore);
        }
        */

        return maxScore;
    }
}
