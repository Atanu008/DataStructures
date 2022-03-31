package org.atanu.java.ds.string;

//https://leetcode.com/problems/is-subsequence/
//LeetCode 392
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {

        if(s == null || s.isEmpty()) {
            return true;
        }

        if(t == null || t.isEmpty()){
            return false;
        }

        int i = 0;
        for(char ch : t.toCharArray()) {

            if(ch == s.charAt(i)){
                i++;
            }
            if(i == s.length()){
                return true;
            }
        }

        return i == s.length();
    }

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        String s = "abc", t = "ahbgdc";
        boolean result = isSubsequence.isSubsequence(s, t);
        //True
        System.out.println(result);

        s = "axc";
        t = "ahbgdc";
        result = isSubsequence.isSubsequence(s, t);
        //False
        System.out.println(result);
    }
}
