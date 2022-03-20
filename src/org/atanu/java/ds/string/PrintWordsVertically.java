package org.atanu.java.ds.string;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/print-words-vertically/
//LeetCode 1324
//Video : https://www.youtube.com/watch?v=mJYnmKJ_y44
public class PrintWordsVertically {

    public List<String> printVertically(String s) {

        List<String> result = new ArrayList<>();
        String[] arr = s.split(" ");
        int maxLength = getMaxLength(arr);

        for(int i = 0; i < maxLength; i++) {
            StringBuilder sb = new StringBuilder();
            for(String str: arr){
                if(i >= str.length()) {
                    sb.append(" ");
                }
                else {
                    sb.append(str.charAt(i));
                }
            }
            result.add(trimRight(sb.toString()));
        }

        return result;
    }

    public int getMaxLength(String[] arr) {
        int maxLength = 0;
        for(String str : arr) {
            maxLength = Math.max(maxLength, str.length());
        }
        return maxLength;
    }

    public String trimRight(String str) {
        int end = str.length() -1;
        while(end >= 0 && str.charAt(end) == ' ') {
            end--;
        }
        return str.substring(0, end + 1);
    }

    public static void main(String[] args) {
        PrintWordsVertically printWordsVertically = new PrintWordsVertically();
        String s = "TO BE OR NOT TO BE";
        List<String> result = printWordsVertically.printVertically(s);
        System.out.println(result);

        s = "HOW ARE YOU";
        result = printWordsVertically.printVertically(s);
        System.out.println(result);
    }
}
