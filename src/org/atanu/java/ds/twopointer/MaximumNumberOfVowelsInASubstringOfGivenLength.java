package org.atanu.java.ds.twopointer;

// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
// Leetcode 1456

public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public int maxVowels(String s, int k) {
        int windowEnd = 0;
        int windowStart = 0;
        int vowelCount = 0;
        int result = 0;
        while(windowEnd < s.length()){
            char end = s.charAt(windowEnd);
            if(isVowel(end)){
                vowelCount++;
            }
            while(windowEnd - windowStart + 1 > k){
                char start = s.charAt(windowStart);
                if(isVowel(start)){
                    vowelCount--;
                }
                // Shrink the window
                windowStart++;
            }
            result = Math.max(result, vowelCount);
            windowEnd++;
        }
        return result;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' ||c == 'i' ||c == 'o' ||c == 'u';
    }

    public static void main(String[] args) {
        MaximumNumberOfVowelsInASubstringOfGivenLength maximumNumberOfVowelsInASubstringOfGivenLength = new MaximumNumberOfVowelsInASubstringOfGivenLength();
        String s = "abciiidef";
        int k = 3;
        //Output: 3
        //Explanation: The substring "iii" contains 3 vowel letters.
        int result = maximumNumberOfVowelsInASubstringOfGivenLength.maxVowels(s, k);
        System.out.println(result);
    }
}
