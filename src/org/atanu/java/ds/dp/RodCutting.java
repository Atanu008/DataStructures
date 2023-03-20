package org.atanu.java.ds.dp;


public class RodCutting {
    // Function to find the best way to cut a rod of length `n`
    // where the rod of length `i` has a cost `price[i-1]`
    public int rodCut(int[] price, int length) {
        //Nothing to cut
        if(length == 0){
            return 0;
        }

        int maxProfit = Integer.MIN_VALUE;
        // one by one, partition the given rod of length `n` into two parts of
        // length (1, n-1), (2, n-2), (3, n-3), … ,(n-1, 1), (n, 0) and
        // take maximum

        // i.e try cutting the rod from cut 1 to current length.
        // had over the remaining length after cut to recursion
        for(int cut = 1; cut <= length; cut++){

            int profit = price[cut - 1] + rodCut(price, length - cut);
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        RodCutting rodCutting = new RodCutting();
        int[]  prices = new int[] { 1, 5, 8, 9, 10, 17, 17, 20 };
        int rodLength = prices.length;
        int maxProfit = rodCutting.rodCut(prices, rodLength);
        System.out.println("Top Down : ");
        System.out.println(maxProfit);

    }
}
