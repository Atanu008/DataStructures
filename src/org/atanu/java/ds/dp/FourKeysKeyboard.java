package org.atanu.java.ds.dp;

//https://leetcode.com/problems/4-keys-keyboard/
//LeetCode 651
//Video : https://www.youtube.com/watch?v=c_y7H7qZJRU
//Video : https://www.youtube.com/watch?v=nyR8K63F2KY
// Also Logic Mojo
public class FourKeysKeyboard {

    public int maxA(int N){
        //Base case
        if(N <= 6){
            return N;
        }
        int[] dp = new int[N+1];

        for(int i = 1; i <=6; i++){
            dp[i] = i;
        }

        for(int i = 7; i <= N ; i++){

            for(int j = i-3 ; j >=1; j--){
                dp[i] = Math.max(dp[i], dp[j] * (i-j-1));
            }
        }

        return dp[N];
    }

    //Top Down Approach
    public int maxAV2(int N){
        //Base case
        if(N <= 6){
            return N;
        }

        int max = 0;
        for(int i = N - 3; i >= 1 ; i--){

            int current = (N - i - 1) * maxAV2(i);
            max = Math.max(max, current);
        }

        return max;
    }
    public static void main(String[] args) {
        FourKeysKeyboard fourKeysKeyboard = new FourKeysKeyboard();

        for (int N = 1; N <= 20; N++){
            System.out.println("Maximum Number of A's with "+  N +" keystrokes is "+  fourKeysKeyboard.maxA(N));
            System.out.println("Maximum Number of A's with "+  N +" keystrokes is "+  fourKeysKeyboard.maxAV2(N));
        }

    }
}
