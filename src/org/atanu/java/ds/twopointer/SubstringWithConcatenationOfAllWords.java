package org.atanu.java.ds.twopointer;

import java.util.*;

//https://leetcode.com/problems/substring-with-concatenation-of-all-words/
//LeetCode 30
//Video : https://www.youtube.com/watch?v=Bbu4Qjzf7A0&t=152s
public class SubstringWithConcatenationOfAllWords {

    //Keep the frequency of every word in a HashMap.
    //Starting from every index in the string, try to match all the words.
    //In each iteration, keep track of all the words that we have already seen in another HashMap.
    //If a word is not found or has a higher frequency than required, we can move on to the next character in the string.
    //Store the index if we have found all the words.
    public List<Integer> findSubstring(String str, String[] words) {

        List<Integer> resultIndices = new ArrayList<Integer>();

        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        for (String word : words) {
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }

        int wordCount = words.length;
        int wordLength = words[0].length();

        for (int i = 0; i <= str.length() - wordCount * wordLength; i++) {
            Map<String, Integer> wordSeenMap = new HashMap<>();
            for (int j = 0; j < words.length; j++) {
                int nextWordIndex = i + j * wordLength;
                // get the next word from the string
                String currentWord = str.substring(nextWordIndex, nextWordIndex + wordLength);

                // break if we don't have this word
                if (!wordFrequencyMap.containsKey(currentWord)) {
                    break;
                }
                // add the word to the 'wordsSeen' map
                wordSeenMap.put(currentWord, wordSeenMap.getOrDefault(currentWord, 0) + 1);
                // no need to process further if the word has higher frequency than required
                if (wordSeenMap.get(currentWord) > wordFrequencyMap.get(currentWord)) {
                    break;
                }

                if (j + 1 == wordCount) {
                    resultIndices.add(i);// store index if we have found all the words
                }
            }
        }

        return resultIndices;
    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords substringWithConcatenationOfAllWords = new SubstringWithConcatenationOfAllWords();
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        List<Integer> resultIndices = substringWithConcatenationOfAllWords.findSubstring(s, words);
        //Output: [0,9]
        //Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
        //The output order does not matter, returning [9,0] is fine too.
        System.out.println(resultIndices);

        s = "barfoofoobarthefoobarman";
        words = new String[]{"bar", "foo", "the"};
        //Output: [6,9,12]
        resultIndices = substringWithConcatenationOfAllWords.findSubstring(s, words);
        System.out.println(resultIndices);
    }
}
