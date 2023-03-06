package org.atanu.java.ds.string;

//https://leetcode.com/problems/repeated-substring-pattern/description/
//Leetcode 459
public class RepeatedSubstringPattern {

    //The length of the repeating substring must be a divisor of the length of the input string
//Search for all possible divisor of str.length, starting for length/2
//If i is a divisor of length, repeat the substring from 0 to i the number of times i is contained in s.length
//If the repeated substring is equals to the input str return true
    public boolean repeatedSubstringPattern(String s) {

        int length = s.length();

        for(int i = length / 2; i >= 1; i--){
            if(length % i == 0){
                int numberOfRepetation = length / i;
                String substring = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < numberOfRepetation; j++){
                    sb.append(substring);
                }
                if(s.equals(sb.toString())){
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        RepeatedSubstringPattern repeatedSubstringPattern = new RepeatedSubstringPattern();
        String s = "abab";
        boolean result = repeatedSubstringPattern.repeatedSubstringPattern(s);
        System.out.println(result);
        s = "aba";
        result = repeatedSubstringPattern.repeatedSubstringPattern(s);
        System.out.println(result);
        s = "abcabcabcabc";
        result = repeatedSubstringPattern.repeatedSubstringPattern(s);
        System.out.println(result);
    }
}
