package org.atanu.java.ds.dp;

//https://takeuforward.org/data-structure/minimum-insertions-deletions-to-convert-string-dp-30/
//https://www.educative.io/courses/grokking-dynamic-programming-a-deep-dive-using-java/Y5O2n6n5Gy2


//Problem Statement: Minimum Insertions/Deletions to Convert String A to String B
//
//We are given two strings, str1 and str2. We are allowed the following operations:
//
//Delete any number of characters from string str1.
//Insert any number of characters in string str1.
//We need to tell the minimum operations required to convert str1 to str2.

public class MinimumNumberOfDeletionsAndInsertionsToConvertString {

    //To minimize the operations, we will first try to refrain from deleting those characters which are already present in str2. More extensively, we refrain from deleting those characters which are common and come in the same order. To minimize the operations, we would like to keep the maximum common characters coming in the same order intact. These maximum characters are the characters of the longest common subsequence.
    //We will first keep the longest common subsequence of the str1 and str2 intact in str1 and delete all other characters from str1.
    //Next, we will insert all the remaining characters of str2 to str1.
    //The algorithm is stated as follows:
    //
    //Let n and m be the length of str1 and str2 respectively.
    //Find the length of the longest common subsequence ( say k) of str1 and str2 as discussed in  Longest Common Subsequence.
    //Return (n-k) + (m-k) as answer.

    public int minDelIns(String str1, String str2){
        int lcs = lcs(str1, str2);
        // calculating number of deletions required from str1 to transform it into str2
        int deletions = str1.length() - lcs;
        // calculating number of insertions required in str1 to transform it into str2
        int insertions = str2.length() - lcs;

        return deletions + insertions;
    }

    private int lcs(String str1, String str2){
        int m = str1.length() + 1;
        int n = str2.length() + 1;

        int[][] dp = new int[m][n];
        //Dont need to full DP with some values for empty string and other combination its zero only

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                // If the characters at this position match,
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    // add 1 to the previous diagonal and store it in this diagonal
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    // If the characters don't match, fill this entry with the max of the
                    // left and top elements
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }

    public static void main(String[] args) {
        MinimumNumberOfDeletionsAndInsertionsToConvertString minInsDel = new MinimumNumberOfDeletionsAndInsertionsToConvertString();
        String str1= "abcd";
        String str2= "anc";
        System.out.println("The Minimum operations required to convert str1 to str2: "
                +minInsDel.minDelIns(str1,str2));
    }
}
