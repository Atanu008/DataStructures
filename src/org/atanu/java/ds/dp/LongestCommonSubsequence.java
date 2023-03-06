package org.atanu.java.ds.dp;

//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/myN8WB67XYE
//https://leetcode.com/problems/longest-common-subsequence/
//Leetcode 1143
public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {

        Integer[][] dp = new Integer[text1.length()][text2.length()];
        return longestCommonSubsequence(0, 0, text1, text2, dp);
    }

    private int longestCommonSubsequence(int i, int j, String text1, String text2, Integer[][] dp){
        // base case
        //we reach the end of either of the two strings, we return 0
        if(i == text1.length() || j == text2.length()){
            return 0;
        }
        //Its already calculated for i and j position. return memoized ans
        if(dp[i][j] != null){
            return dp[i][j];
        }
        //If the current characters of both strings match,
        // Add 1 and move one position ahead in both strings
        if(text1.charAt(i) == text2.charAt(j)){
            return dp[i][j] =  1 + longestCommonSubsequence(i+1, j+1, text1, text2, dp);
        }
        //If the current characters of both strings do not match, we recursively calculate the maximum length of moving one character forward in any one of the two strings
        //i.e., we check if moving a character forward in either the first string or the second will give us a longer subsequence.
        dp[i][j] = Math.max(longestCommonSubsequence(i+1, j, text1, text2, dp),
                                longestCommonSubsequence(i, j+1, text1, text2, dp));
        return dp[i][j];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String[] firstStrings = {"qstw", "setter", "abcde", "partner", "freedom"};
        String[] secondStrings = {"gofvn", "bat", "apple", "park", "redeem"};

        // You can uncomment the lines below and check how this recursive solution causes a time-out
        // String temp[] = Arrays.copyOf(firstStrings, firstStrings.length + 1);
        // temp[firstStrings.length] = "sjcneiurutvmpdkapbrcapjru";
        // firstStrings = temp;

        // String temp2[] = Arrays.copyOf(secondStrings, secondStrings.length + 1);
        // temp2[secondStrings.length] = "oidhfwepkxwebyurtunvidqlscmjbg";
        // secondStrings = temp2;

        for (int i = 0; i < firstStrings.length; i++){
            System.out.println("\n"+i + 1 + ".\tstr1: " + firstStrings[i] + "\n\tstr2: " + secondStrings[i]
                    + "\n\n\tThe length of the longest common subsequence is: " + lcs.longestCommonSubsequence(firstStrings[i], secondStrings[i]));

            //System.out.println(PrintHyphens.repeat("-", 100));
        }
    }
}
