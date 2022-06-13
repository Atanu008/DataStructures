package org.atanu.java.ds.string;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/reverse-words-in-a-string/
//LeetCode 151
//Can refer : https://www.youtube.com/watch?v=q6l2d6EXB-s&t=452s
public class ReverseWordsInAString {

    public String reverseWords(String s) {

        Deque<String> stack = new LinkedList<>();

        int i = 0;

        while(i < s.length()){

            //Ignore the leading spaces
            while(i < s.length() && s.charAt(i) == ' '){
                i++;
            }

            StringBuilder sb = new StringBuilder();
            //take out the word
            while(i < s.length() && s.charAt(i) != ' '){
                sb.append(s.charAt(i++));
            }
            //push it to satck if a valid word
            if(sb.length() > 0){
                stack.addLast(sb.toString());
            }

        }

        String result = "";
        int count = 0;
        //Build result String
        while(!stack.isEmpty()){

            result += count++ != 0 ? " "+stack.pollLast() : stack.pollLast(); // dont add space first . also we can use trim at last before resturn
        }

        return result;
    }

    public static void main(String[] args) {
        ReverseWordsInAString reverseWordsInAString = new ReverseWordsInAString();
        String s = "the sky is blue";
        //Output: "blue is sky the"
        System.out.println(reverseWordsInAString.reverseWords(s));

        s = "  hello world  ";
        //Output: "world hello"
        System.out.println(reverseWordsInAString.reverseWords(s));
    }
}
