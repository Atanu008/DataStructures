package org.atanu.java.ds.dp;

import java.util.Arrays;
import java.util.Comparator;

//Variation Of Longest Increasing Subsequence
//https://leetcode.com/problems/maximum-height-by-stacking-cuboids/
//LeetCode 1691
public class BoxStacking {

    public int maxHeight(int[][] cuboids) {
        //Sort the individual Boxes ascending order so that the max length become last(cubiod[2])
        //[[50,45,20],[95,37,53],[45,23,12]] becomes [[20,45,50],[37,53,95],[12,23,45]]
        for (int[] a : cuboids){
            Arrays.sort(a);
        }

        //Now sort the cuboids to apply LIS logic
        //First sort using height(last cubiod[2]).
        //If height same sort using length
        //if that is same then use width
        Arrays.sort(cuboids, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[2] != b[2])
                    return a[2] - b[2];
                if (a[1] != b[1])
                    return a[1] - b[1];
                return a[0] - b[0];
            }
        });
        int n = cuboids.length;

        int[] dp = new int[n];
        dp[0] = cuboids[0][2]; // Base Case. Store the height of 0th box

        int maxHeight = dp[0];
        for(int i = 1; i < n; i++){
            dp[i] = cuboids[i][2]; // Strore the height of ith box
            for(int j = 0; j < i; j++){
                if(cuboids[i][0] >= cuboids[j][0] && cuboids[i][1] >= cuboids[j][1] && cuboids[i][2] >= cuboids[j][2]){
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
            maxHeight = Math.max(maxHeight, dp[i]);
        }

        return maxHeight;
    }

    public static void main(String[] args) {

        BoxStacking boxStacking = new BoxStacking();
        int[][] cuboids = {{50,45,20},{95,37,53},{45,23,12}};
        //Output: 190
        //Explanation:
        //Cuboid 1 is placed on the bottom with the 53x37 side facing down with height 95.
        //Cuboid 0 is placed next with the 45x20 side facing down with height 50.
        //Cuboid 2 is placed next with the 23x12 side facing down with height 45.
        //The total height is 95 + 50 + 45 = 190.
        System.out.println("Max Boxes height "+ boxStacking.maxHeight(cuboids));

        cuboids = new int[][]{{7, 11, 17}, {7, 17, 11}, {11, 7, 17}, {11, 17, 7}, {17, 7, 11}, {17, 11, 7}};
        //Output: 102
        //Explanation:
        //After rearranging the cuboids, you can see that all cuboids have the same dimension.
        //You can place the 11x7 side down on all cuboids so their heights are 17.
        //The maximum height of stacked cuboids is 6 * 17 = 102.

        System.out.println("Max Boxes height "+ boxStacking.maxHeight(cuboids));
    }
}
