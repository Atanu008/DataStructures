package org.atanu.java.ds.string;

import java.util.Arrays;

//https://leetcode.com/problems/reverse-words-in-a-string-ii/
//LeetCode 186
//Exactly Same solution as ReverseWordsInAString III .
// Here we just need to reverse it first and then apply the same algorithm
public class ReverseWordsInAStringII {

    public void reverseWords(char[] ca) {
        reverse(ca, 0, ca.length -1);
        int start = 0;
        int end = 0;
        while(start < ca.length) {
            end = start;
            while (end < ca.length && ca[end] != ' ') {
                end++;
            }
            //Now end either points to Blank Or End of array
            //So the end of the word would be pointed by (end -1)
            //Reverse strat , end - 1;
            reverse(ca, start, end-1);
            start = end+1;  // Move Start to the next word
        }

    }

    private void reverse(char[] ca, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = ca[i];
            ca[i] = ca[j];
            ca[j] = tmp;
        }
    }

    public static void main(String[] args) {
        ReverseWordsInAStringII reverseWordsInAString = new ReverseWordsInAStringII();
        char[] ca = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        reverseWordsInAString.reverseWords(ca);
        System.out.println(Arrays.toString(ca));

    }
}
