package org.atanu.java.ds.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-string-chain/
//LeetCode 1048
//Video : https://www.youtube.com/watch?v=HX3xggriPTo
//Same Idea as Longest Increasing Subsequence
public class LongestStringChain {

    public int longestStrChain(String[] words) {

        Arrays.sort(words, (a, b) -> a.length() - b.length());

        Map<String, Integer> map = new HashMap<>();
        int maxLength = 0;

        for(String word: words){
            int currentSubSequenceLength = 1;
            for(int i = 0; i < word.length(); i++){
                String predecessor = word.substring(0,i) + word.substring(i+1,word.length());
                currentSubSequenceLength = Math.max(currentSubSequenceLength, map.getOrDefault(predecessor, 0) +1);
            }
            maxLength = Math.max(maxLength, currentSubSequenceLength);
            map.put(word, currentSubSequenceLength);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestStringChain longestStringChain = new LongestStringChain();
        String[] words = {"a","b","ba","bca","bda","bdca"};
        //Output: 4
        //Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
        System.out.println("Longest String Chain is "+ longestStringChain.longestStrChain(words));

        words = new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"};
        //Output: 5
        //Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
        System.out.println("Longest String Chain is "+ longestStringChain.longestStrChain(words));

    }
}
