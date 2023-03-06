package org.atanu.java.ds.dp;

import java.util.stream.Stream;

public class LongestCommonSubString {

    //We have two conditions:
    //
    //if(S1[i-1] != S2[j-1]), the characters don’t match, therefore the consecutiveness of characters is broken.
    //So we set the cell value (dp[i][j]) as 0. we dont need to explicitly do that as all sp elemnsts are zero only

    //if(S1[i-1] == S2[j-1]), then the characters match
    //we simply set its value to 1+dp[i-1][j-1].
    //We have done so because dp[i-1][j-1] gives us the longest common substring till the last cell character
    //(current strings -{matching character}). As the current cell’s character is matching we are adding 1 to the consecutive chain.

    //Note: dp[n][m] will not give us the answer; rather the maximum value in the entire dp array will give us the length of the longest common substring. This is because there is no restriction that the longest common substring is present at the end of both the strings.

    //Video Can refer : https://www.youtube.com/watch?v=_wP9mWNPL5w

    public int findLength(String str1, String str2) {

        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    max = Math.max(dp[i][j], max); // We need to take the maximum length
                }
            }
        }

        return max;
    }

    // Driver code
    public static void main(String[] args) {
        LongestCommonSubString longestCommonSubString = new LongestCommonSubString();
        String[] s1 = {
                "educative",
                "bcdcdcd",
                "arefun",
                "yourocks",
                "abc"
        };
        String[] s2 = {
                "education",
                "aacdcdcd",
                "isfun",
                "youawesome",
                "def"
        };

        // Let's uncomment this to see the benefit of using dynamic programming with tabulation
        // String temp1[] = Arrays.copyOf(s1, s1.length + 1);
        // temp1[s1.length] = "ypzrvyigwdiqrnbglvviozqzruvmwivgvqvrfhqi";
        // s1 = temp1;

        // String temp2[] = Arrays.copyOf(s2, s2.length + 1);
        // temp2[s2.length] = "wdiqrnbglvviozqzruvmwivgvqvrfhqiypzrvyigwdiqrn";
        // s2 = temp2;

        for (int i = 0; i < s1.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tInput string 1: \"" + s1[i] + "\"");
            System.out.println("\tInput string 2: \"" + s2[i] + "\"");
            System.out.println("\n\tThe Length of Longest Common Substring is: " + longestCommonSubString.findLength(s1[i], s2[i]));
            Stream.generate(() -> "-").limit(100).forEach(System.out::print);
            System.out.println();
        }

    }
}
