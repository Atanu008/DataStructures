package org.atanu.java.ds.binarysearch;

//https://leetcode.com/problems/valid-perfect-square/
//LeetCode 367
public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        // For num > 2 the square root a is always less than num/2
        if (num < 2) {
            return true;
        }
        //Set the left boundary to 2, and the right boundary to num / 2.
        long low = 1;
        long high = num/2; // Could assign num . then you dont need the first of

        while(low <= high) {
            long mid = low + (high - low)/2;

            long  probableSquare = mid * mid;
            if(probableSquare == num) return true;

            if(probableSquare < num){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return false;
    }

    public boolean isPerfectSquareV2(int num) {

        long i = 1;
        while(i * i < num){
            i++;
        }
        return i*i == num;
    }

    public boolean isPerfectSquareV3(int num) {

        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    public static void main(String[] args) {
        ValidPerfectSquare validPerfectSquare = new ValidPerfectSquare();
        int n = 16;
        boolean isPerfectSquare = validPerfectSquare.isPerfectSquare(n);
        System.out.println(isPerfectSquare);

        n = 14;
        isPerfectSquare = validPerfectSquare.isPerfectSquare(n);
        System.out.println(isPerfectSquare);
    }

}
