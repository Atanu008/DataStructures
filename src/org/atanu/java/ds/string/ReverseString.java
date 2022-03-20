package org.atanu.java.ds.string;

//https://leetcode.com/problems/reverse-string/
//LeetCode 344
public class ReverseString {

    public void reverseString(char[] s) {
        int end = s.length -1;
        int start = 0;
        int length = s.length;
        while(start < end)
        {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }
    }

    public void reverseStringV2(char[] s) {
        reverse(s,0,s.length -1);
    }

    public void reverse(char[] s, int start , int end)
    {

        if(start >= end){
            return;
        }

        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;

        start++;
        end--;
        reverse(s,start++ , end--);
    }
}
