package org.atanu.java.ds.greedy;

public class BreakAPalindrome {

    //Explanation : https://leetcode.com/problems/break-a-palindrome/solutions/1428647/break-a-palindrome/?orderBy=most_votes

    //Case A : we can change a non-empty palindromic string into a non-palindromic string
    //by changing one character only if the length of the string is greater than one.

    //Case B :
    // Replace the first character that is not 'a' to 'a' . That would make it lexicographically smallest

    //Case C : When all a Or all a except middle
    //case when we cannot change any of the characters to aaa?
    //For the strings made up of only character aaa like aaaaaaaaa
    //or strings made up of exactly N - 1 aaa's (where N is the string length)
    //and one different character in the middle, like aazaaaazaaaazaa,
    //we need to discover another way. In the first case,
    //there is no point in substituting aaa for another aaa. In the second case,
    //we cannot replace zzz with some other character between aaa and yyy because the string will remain a palindrome.
    //In this case, we must replace aaa,
    //and the optimal character choice is bbb because that's the smallest among all other letters.
    //Since the character that we are replacing the existing character with is not the smallest,
    //we should do the swap in the rightmost position.

    //Algorithm
    //
    //Step 1: If the length of the string is 111, return an empty string since we cannot create a non-palindromic string in this case.
    //Step 2 :Iterate over the string from left to the middle of the string: if the character is not aaa,
    //change it to aaa and return the string.
    //Step 3 :If we traversed over the whole left part of the string and still haven't got a non-palindromic string,
    //it means the string has only aaa's. Hence, change the last character to bbb and return the obtained string.
    public String breakPalindrome(String palindrome) {

        if(palindrome.length() == 1){
            return "";
        }

        char[] p = palindrome.toCharArray();
        for(int i = 0; i < p.length/2; i++){
            if(p[i] != 'a'){
                //replace the first character that is not "a"
                p[i] = 'a';
                return new String(p);
            }
        }

        // if we reach here,
        //there are ONLY 'a' in palindrome string, so we should change the last character to a b
        p[p.length -1 ] = 'b';
        return new String(p);
    }
}
