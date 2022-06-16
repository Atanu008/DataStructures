package org.atanu.java.ds.array;

//https://leetcode.com/problems/bulls-and-cows/
//LeetCode 299
//https://www.youtube.com/watch?v=sEGa8F2pMS8
public class BullsAndCows {

    public String getHint(String secret, String guess) {

        int bulls = 0;
        //Arrays to get the frequency of digit in each String
        int[] secretFreq = new int[10];
        int[] guessFreq = new int[10];

        for(int i = 0; i < secret.length(); i++){
            char secretChar = secret.charAt(i);
            char guessChar = guess.charAt(i);

            if(secretChar == guessChar){
                bulls++; //which are digits in the guess that are in the correct position.
            }
            else{
                secretFreq[secretChar - '0']++;
                guessFreq[guessChar - '0']++;
            }
        }

        int cows = 0;
        for(int i = 0; i < 10; i++){
            //Take the Minimum because thats common
            //Suppose in secret we have 5 occurances of 9
            // In Guess we have 3 occurances of 9
            // so cows we have 3 only , as 3 only common .
            //So take the minumum
            cows += Math.min(secretFreq[i], guessFreq[i]);
        }

        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {

        BullsAndCows bullsAndCows = new BullsAndCows();
        String hint = bullsAndCows.getHint("1807", "7810");
        System.out.println(hint);

        hint = bullsAndCows.getHint("1123", "0111");
        System.out.println(hint);

    }
}
