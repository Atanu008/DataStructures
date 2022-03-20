package org.atanu.java.ds.string;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/text-justification/
//LeetCode 68
// Awesome Explanation https://www.youtube.com/watch?v=GqXlEbFVTXY :
// some wrong code in while loop condition in video.
// Fixed it here
public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {

        int i = 0;
        int j = 0;
        int n = words.length;
        List<String> result = new ArrayList<>();
        while(i < words.length) {

            int lineLength = words[i].length();
            j = i + 1;
            while(j < n && lineLength + words[j].length() + (j - i) <= maxWidth){ // If we include j then (j - i) would be the no spaces required between words
                lineLength += words[j].length();
                j++;
            }
            //Point to note J will point to either end of String Or the invalid word
            // j - 1 will point to the last word in the string;
            // j - i will give the no of word
            int noOfWords = j - i;
            int placesToFillWithSpaces = maxWidth - lineLength;

            if(noOfWords == 1 || j >= n){
                result.add(leftJustify(words, placesToFillWithSpaces, i , j));
            }
            else {
                result.add(middleJustify(words, placesToFillWithSpaces, i , j));
            }

            i = j;
        }

        return result;
    }

    public String leftJustify(String[] words, int placesToFillWithSpaces, int i , int j) {

        int spacesToAppendAtRight = placesToFillWithSpaces - (j - i - 1);//(j - i - 1) represents the no of spaces needed between word
        StringBuilder sb = new StringBuilder(words[i]);
        for(int k = i +1; k < j; k++) {
            sb.append(" "+words[k]);
        }
        sb.append(" ".repeat(spacesToAppendAtRight));
        return sb.toString();
    }

    public String middleJustify(String[] words, int placesToFillWithSpaces, int i , int j) {
        int totalgGapBtweenWords = j - i - 1;
        int spacesToAppendBtweenWords = placesToFillWithSpaces / totalgGapBtweenWords;
        int remainingSpaces = placesToFillWithSpaces % totalgGapBtweenWords;

        StringBuilder sb = new StringBuilder(words[i]);
        for(int k = i +1; k < j; k++) {
            int spacesToAppend = spacesToAppendBtweenWords + (remainingSpaces --> 0 ? 1 : 0);
            sb.append(" ".repeat(spacesToAppend)+words[k]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        TextJustification textJustification = new TextJustification();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> result = textJustification.fullJustify(words, maxWidth);
        System.out.println(result);

        words = new String[]{"What","must","be","acknowledgment","shall","be"};
        maxWidth = 15;
        result = textJustification.fullJustify(words, maxWidth);
        System.out.println(result);
    }
}
