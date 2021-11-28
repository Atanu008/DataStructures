package org.atanu.java.ds.dp;

//https://leetcode.com/problems/decode-ways/
//LeetCode 91
//Video : https://www.youtube.com/watch?v=W4rYz-kd-cY&t=683s
//Video : https://www.youtube.com/watch?v=cQX3yHS0cLo&t=389s
public class DecodeWays {

    public int numDecodings(String s) {

        int n = s.length();
        int[] dp = new int[s.length()+1];
        //Base case . For empty case. How ever its Hypothetical
        dp[0] = 1;
        //if First Char is zero then no way we can build
        // If its Non Zero then there is one way
        dp[1] = s.charAt(0) != '0' ? 1: 0;

        for(int i = 2; i <= s.length(); i++){
            int lastOneDigit = Integer.parseInt(s.substring(i-1,i));
            int lastTwoDigit = Integer.parseInt(s.substring(i-2,i));

            if(lastOneDigit >=1){
                dp[i] += dp[i-1];
            }

            if(lastTwoDigit >=10 && lastTwoDigit <= 26){
                dp[i] += dp[i-2];
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        DecodeWays decodeWays = new DecodeWays();
        String s = "12";
        //Output: 2
        //Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
        System.out.println(s+" can be decoded in "+decodeWays.numDecodings(s));

        s = "226";
        //Output: 3
        //Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
        System.out.println(s+" can be decoded in "+decodeWays.numDecodings(s));
    }
}
