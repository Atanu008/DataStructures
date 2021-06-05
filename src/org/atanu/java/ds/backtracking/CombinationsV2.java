package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

//LeetCode 77
//https://leetcode.com/problems/combinations/
//This is using String
public class CombinationsV2 {
    List<String> result = new ArrayList<>();
    public void combinations(String s, int combinationLength, StringBuilder sb, int index){
        if(combinationLength == 0){
            result.add(sb.toString());
            return;
        }

        for(int i = index; i < s.length() ; i++){
            sb.append(s.charAt(i));
            combinations(s, combinationLength -1, sb, i+1);
            sb.deleteCharAt(sb.length() -1);
        }
    }
    public static void main(String[] args) {
        String s = "abc";
        int combunationLingth = 2;
        CombinationsV2 combinationsV2 = new CombinationsV2();
        combinationsV2.combinations(s,combunationLingth,new StringBuilder(), 0);
        combinationsV2.result.forEach(System.out::println);
    }
}
