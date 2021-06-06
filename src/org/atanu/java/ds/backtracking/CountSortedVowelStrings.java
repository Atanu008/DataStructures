package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

//LeetCode 1641
//https://leetcode.com/problems/count-sorted-vowel-strings/

//Not effecient solution. DP solution is fast .. Yet to implement
public class CountSortedVowelStrings {
    int count = 0;
    public int countVowelStrings(int n) {
        List<String> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("e");
        list.add("i");
        list.add("o");
        list.add("u");

        backtrack(list, result, new StringBuilder(), n, 0);
        return count;
    }

    private void backtrack(List<String> list, List<String> result, StringBuilder sb, int n, int startIdx) {
        if(sb.length() == n){
            count++;
            System.out.println(sb);
            result.add(new String(sb));
            return;
        }

        for(int i = startIdx; i < list.size(); i++){
            sb.append(new String(list.get(i)));
            // Here, it's important to pass in "i" as the new "startIdx,"
            // First two call would start wth a only as . when the length is reached it wil pick the next
            backtrack(list, result, sb, n, i);
            sb.deleteCharAt(sb.length() -1);
        }
    }

    public static void main(String[] args) {
        int n = 2;
        CountSortedVowelStrings countSortedVowelStrings = new CountSortedVowelStrings();
        System.out.println(countSortedVowelStrings.countVowelStrings(n));
    }
}
