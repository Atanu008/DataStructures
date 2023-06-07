package org.atanu.java.ds.binarysearch;

//https://leetcode.com/problems/guess-number-higher-or-lower/
//LeetCode 374
public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {

        int low = 1;
        int high =  n;

        while(low <= high){

            int mid = low + (high - low)/2;
            int gussed = guess(mid);
            // Correct Guess
            if(gussed == 0){
                return mid;
            }
            // Guess is Higher , Need to search left
            else if(guess(mid) == -1){
                high = mid -1;
            }
            else{ //Guess is Lower , Need to search Right
                low = mid +1;
            }
        }
        return -1;

    }

    private int guess(int mid) {
        return 0;
    }
}
