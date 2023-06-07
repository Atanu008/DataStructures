package org.atanu.java.ds.binarysearch;

//https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/description/
//LeetCode 668
//Video : https://www.youtube.com/watch?v=j2rFt1pDcVg
public class KthSmallestNumberInMultiplicationTable {

    public int findKthNumber(int m, int n, int k) {

        int low = 1;
        int high = m * n;

        while(low < high){

            int mid = low + (high - low) / 2;

            if(countNumberSmallerThanGuessedNumber(m, n, mid) < k){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        return high;
    }

    //For ith Row the number of elements lesser than equal to the Number is (Number/ithRow)
    //Edge case where the number is really high then take the number of column instead
    private int countNumberSmallerThanGuessedNumber(int row, int column, int guessedNumber){

        int count = 0;

        for(int currentRow = 1; currentRow <= row; currentRow++){
            count += Math.min(guessedNumber/currentRow, column);
        }
        return count;
    }

    public static void main(String[] args) {
        KthSmallestNumberInMultiplicationTable kthSmallestNumberInMultiplicationTable = new KthSmallestNumberInMultiplicationTable();
        int row = 3;
        int coulmn = 3;
        int k = 5;
        int kthSamllestNumber = kthSmallestNumberInMultiplicationTable.findKthNumber(row, coulmn, k);
        System.out.println("The 5th smallest number is "+ kthSamllestNumber);

        row = 2;
        coulmn = 3;
        k = 6;
        kthSamllestNumber = kthSmallestNumberInMultiplicationTable.findKthNumber(row, coulmn, k);
        System.out.println("The 5th smallest number is "+ kthSamllestNumber);
    }
}
