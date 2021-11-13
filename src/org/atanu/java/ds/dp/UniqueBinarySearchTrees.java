package org.atanu.java.ds.dp;

//https://leetcode.com/problems/unique-binary-search-trees/
//LeetCode 96
public class UniqueBinarySearchTrees {
    //Catalan Number
    //C0 = 0 and Cn+1 = Σ Ci Cn-i for n>=0 and n=>i>=0.
    //1 1 2 5 14 42 132 429 1430 4862
    public int numTrees(int n) {

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i ; j++){
                dp[i] += dp[j] * dp[i-j-1];
            }
        }

        return dp[n];
    }

    //Coding Minutes Explanation
    public int numTreesV2(int n) {

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            for(int j = 1; j <= i ; j++){
                //For jth Node
                // j-1 node at Left And i-j Node at Right
                dp[i] += dp[j-1] * dp[i-j];
            }
        }

        return dp[n];
    }

    //Recursion Top Down
    public int numTreesV3(int n) {

        int[] dp = new int[n+1];
        return numTreesV3(n, dp);
    }

    int numTreesV3(int n, int[] dp){
        if(n <= 1){
            return 1;
        }

        if(dp[n] != 0){
            return dp[n];
        }
        int result = 0;
        for(int i = 0; i < n; i++){
            result +=  numTreesV3(i, dp) * numTreesV3(n-i-1, dp);
        }
        dp[n] = result;
        return dp[n];
    }

    //Recursion Top Down
    public int numTreesV4(int n) {

        int[] dp = new int[n+1];
        return numTreesV4(n, dp);
    }

    int numTreesV4(int n, int[] dp){
        if(n <= 1){
            return 1;
        }

        if(dp[n] != 0){
            return dp[n];
        }
        int result = 0;
        for(int i = 1; i <= n; i++){
            result +=  numTreesV4(i-1, dp) * numTreesV4(n-i, dp);
        }
        dp[n] = result;
        return dp[n];
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees uniqueBinarySearchTrees = new UniqueBinarySearchTrees();
        int N = 3;
        System.out.println("Unique BSTs with "+ N +" node is "+ uniqueBinarySearchTrees.numTrees(N));
        System.out.println("Unique BSTs with "+ N +" node is "+ uniqueBinarySearchTrees.numTreesV2(N));
        System.out.println("Unique BSTs with "+ N +" node is "+ uniqueBinarySearchTrees.numTreesV3(N));
        System.out.println("Unique BSTs with "+ N +" node is "+ uniqueBinarySearchTrees.numTreesV4(N));
    }
}
