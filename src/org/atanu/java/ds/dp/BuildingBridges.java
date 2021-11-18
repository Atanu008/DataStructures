package org.atanu.java.ds.dp;

import java.util.Arrays;

//Another Variation as Longest Increasing Subsequence
//https://www.geeksforgeeks.org/dynamic-programming-building-bridges/
// Video : https://www.youtube.com/watch?v=o1h3aoeSTOU&t=1831s
public class BuildingBridges {

    // Sort On basis on North Bank
    // Apply LIS on South bank
    public int maxBridges(int[][] bridges){
        // Sort On basis on North Bank
        // If North Bank is equal , Sort on basis of South bank
        Arrays.sort(bridges, (a , b) -> { if(a[0] != b[0]) return a[0] - b[0]; else return a[1] - b[1];});
        int n = bridges.length;
        int[] dp = new int[n];

        dp[0] = 1;
        int maxBridges = 0;
        for(int i = 1; i < n; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(bridges[j][1] <= bridges[i][1]){
                    dp[i] = Math.max(dp[i], dp[j] +1);
                    maxBridges = Math.max(maxBridges, dp[i]);
                }
            }
        }

        return maxBridges;
    }

    public static void main(String[] args) {
        BuildingBridges buildingBridges = new BuildingBridges();
        int[][] bridges = {{6,2},{4,3},{2,6},{1,5}};
        System.out.println("Maximum number of bridges = " + buildingBridges.maxBridges(bridges));

        int[][] bridge = {{10,20},{2,7},{8,15},{17,3},{21,40},{50,4},{41,57},{60,80},{80,90},{1,30}};
        System.out.println("Maximum number of bridges = " + buildingBridges.maxBridges(bridge));
    }
}
