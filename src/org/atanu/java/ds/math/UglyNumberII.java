package org.atanu.java.ds.math;

//https://leetcode.com/problems/ugly-number-ii/
//LeetCode 264
//Video : https://www.youtube.com/watch?v=Lj68VJ1wu84&t=669s
public class UglyNumberII {
    public int nthUglyNumber(int n) {

        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0 , p3 = 0, p5 = 0;

        for(int i = 1; i < n; i++){

            int p2Val = dp[p2]*2;
            int p3Val = dp[p3]*3;
            int p5Val = dp[p5]*5;

            int currentUglyNumber = Math.min(p2Val, Math.min(p3Val, p5Val));
            dp[i] = currentUglyNumber;
            if(currentUglyNumber == p2Val) p2++;
            if(currentUglyNumber == p3Val) p3++;
            if(currentUglyNumber == p5Val) p5++;
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        UglyNumberII uglyNumberII = new UglyNumberII();
        int n = 10;
        System.out.println(n+"th Ugly Number is "+ uglyNumberII.nthUglyNumber(n));
    }
}
