package org.atanu.java.ds.string;

//https://leetcode.com/problems/remove-vowels-from-a-string/
//LeetCode 1119
public class RemoveVowelsFromAString {

    public String removeVowels(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if(!isVowel(ch)){
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
