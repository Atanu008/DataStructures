package org.atanu.java.ds.string;

//https://leetcode.com/problems/reverse-vowels-of-a-string/
//LeetCode 345
public class ReverseVowelsOfAString {

    public String reverseVowels(String s) {

        char[] ca = s.toCharArray();
        String vowels = "aeiouAEIOU"; // Set of vowel characters would be more appropiate
        int start = 0;
        int end = ca.length -1;

        while(start < end) {

            while(start < end && vowels.indexOf(ca[start]) == -1){
                start++;
            }

            while(start < end && vowels.indexOf(ca[end]) == -1){
                end--;
            }

            swap(ca, start, end);
            start++;
            end--;
        }

        return new String(ca);
    }

    public void swap(char[] ca, int a, int b){
        char temp = ca[a];
        ca[a] = ca[b];
        ca[b] = temp;
    }
}
