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

    /*
    Let's say we have the first 3 ugly numbers 1, 2, 3. What would be the next number? Given the definition,
    the next number has to be the the smallest number among 2*(1,2,3), 3*(1,2,3), 5*(1,2,3).
    Obviously, the smallest number is 2 * 1 = 2. But wait, 2 is already in there.
    So precisely speaking, the next number has to be the the smallest number among all the existing numbers multiplied by 2, 3,5 that isn't in the list already.
    Now, we can traverse all numbers and maintain a hashset if we want, but it would become O(N^2).
    Good news is that we can solve this in a DP-like approach.
    First, we assume there is only one number in the list, which is 1. The next number is Min(2 * 1, 3 * 1, 5 * 1)=2 and it is not in the list.
    Because we have already considered 2*1 (we move the pointer to its next position, which is 2),
    now we only need to consider 2 * 2, 3 * 1, 5 * 1 in the next iteration. This way, we don't have to worry about finding a number that is already in the list.
     */
}
