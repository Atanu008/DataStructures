package org.atanu.java.ds.binarysearch;

// https://leetcode.com/problems/arranging-coins/description/
// Leetcode 441
public class ArrangingCoins {

    // Brute Force
    // We can start with most obvious solution which is to start with row 1
    // and keep filling the next rows till we have remaining coins.
    public int arrangeCoins(int n) {

        int currentCounts = 1; //This default for first row
        int row = 0;

        while(n >= currentCounts){
            n -= currentCounts;
            currentCounts++;
            row++;
        }
        return row;
    }

    // Binary Search Version
    // for 1st Row , the number of coins  is 1
    // for 2nd Row , the number of coins  is 2 , Total : 1 + 2 = 3
    // for 3rd Row , the number of coins  is 3 , Total : 1 + 2 + 3 = 6
    // for 4th Row , the number of coins  is 4 , Total : 1 + 2 + 3 + 4 = 10

    // So for Kth row total number of coins are : K * (K + 1) / 2

    //We can solve this problem using binary search over the possible answer range. But how do we get that we could solve this problem using binary search?
    //
    //We can observe that our answer range is sorted from l = 0 to r = n.
    // We need to find some value rows = (l+r)/2 such that the coins needed , basically mid row
    // coinsNeeded = row*(row + 1) / 2 to form rows is less than or equal to available coins n.

    // If coinsNeeded > n,
    // meaning we have less coins than required to form rows,
    // we know that any number of row greater than rows is impossible to form with given number of coins,
    // so we can safely eliminate the half greater rows by doing r = rows-1.
    //
    // If coinsNeeded < n, meaning we have coins greater than coinsNeeded to form rows,
    // then the current number of rows is formable.
    // We mark this as a possible answer and search if a higher number of rows can be formed by doing l = rows + 1.

    // Now we need to find the last completely filled row.
    // so, we start with mid row, check till that row if all the total from 1... mid_row == n
    //    If yes -> return mid row
    //    if < n -> we increment low by 1
    //    else    decrement high by 1

    // TC : o(logn)
    // SC : o(1)

    public int arrangeCoins_v2(int n) {
        long low = 1;
        long high = n;
        int ans = 0;
        while(low <= high){
            long midRow = low + (high - low) / 2;
            long coinsTillMidRow = midRow * (midRow + 1) /2;

            if(coinsTillMidRow == n){
                return (int)midRow;
            }
            else if(coinsTillMidRow < n){
                low = midRow + 1;
            }
            else{
                high = midRow - 1;
            }
        }

        // When our "left" is greater than our "right",
        // our "left" will be set to a incomplete row and our "right" will be set to a complete row,
        // so we return "right"
        // left = low, right = high :)
        return (int)high;
    }

    public static void main(String[] args) {
        ArrangingCoins arrangingCoins = new ArrangingCoins();
        System.out.println(arrangingCoins.arrangeCoins(5));
        System.out.println(arrangingCoins.arrangeCoins_v2(5));
    }
}
