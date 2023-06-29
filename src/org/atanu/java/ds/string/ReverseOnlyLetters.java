package org.atanu.java.ds.string;

// https://leetcode.com/problems/reverse-only-letters/description/
// Leetcode 917

public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String s) {

        int start = 0;
        int end = s.length() -1;

        char[] input = s.toCharArray();

        while(start < end){

            while(start < end && !Character.isLetter(input[start])){
                start++;
            }
            while(start < end && !Character.isLetter(input[end])){
                end--;
            }
            if(start < end){
                swap(input, start, end);
                start++;
                end--;
            }

        }

        return new String(input);
    }

    private void swap(char[] input, int a , int b){
        char temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }

    public static void main(String[] args) {

    }
}
