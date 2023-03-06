package org.atanu.java.ds.dp;

//https://takeuforward.org/data-structure/print-longest-common-subsequence-dp-26/
public class LongestCommonSubsequencePrint {
    public String LongestCommonSubsequence(String str1, String str2) {

        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m+1][n+1];

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }

        StringBuilder lcs = new StringBuilder();
        int i = m;
        int j = n;

        while(i > 0 && j > 0){
            //System.out.println("KK");
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                //Take the element
                //(i-1 Or j-1) . Anything is fine
                //Go Diagonal
                //System.out.println("KK");
                lcs.append(str1.charAt(i-1));
                i--;
                j--;
            }else if(dp[i-1][j] > dp[i][j-1]){
                //Left Value is greater
                //Go Up one row. Dont need to consider the element
                i--;
            }
            else{
                //Upper value if greater
                j--;
            }
        }

        System.out.println(lcs.reverse().toString());
        return "";
    }

    public static void main(String[] args) {
        LongestCommonSubsequencePrint lcsPrint = new LongestCommonSubsequencePrint();
        String s1= "abcde";
        String s2= "bdgek";

        System.out.print("The Longest Common Subsequence is ");
        lcsPrint.LongestCommonSubsequence(s1,s2);

        s1= "abac";
        s2= "cab";

        System.out.print("The Longest Common Subsequence is ");
        lcsPrint.LongestCommonSubsequence(s1,s2);
    }

}
