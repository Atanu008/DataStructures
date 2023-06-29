package org.atanu.java.ds.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/find-common-characters/
//LeetCode 1002

// 1 - You need to create a main Frequency Array for 26 Alphabets,
// No need to use hashmap here and initialize it with max value because we need to find characters
// that are common inevery string.
//
// 2 - Iterate through the array of strings and create one more array of frequencies
// that would store frequencies for individual strings and every time we update our main array with
// minimum so we have an idea what would be common elements
//
// 3 - Keep an idea how we are indexing our array,
// their index(plus ord('a')) actually reflects what elements are common.
//
// 4 - Now we come out of this loop and inside our main array
// we have the indexes of elements that are actually common.
// Also if the value at that index is greater than 1, it means that
// that particular character is duplicate and is present in all strings value number of times.
//
// 5 - You iterate through this and keep track and value
// and run another while loop inside to take care of appending duplicate characters multiple times.

public class FindCommonCharacters {

    public List<String> commonChars(String[] words) {

        int[] commonCount = new int[26];
        Arrays.fill(commonCount, Integer.MAX_VALUE);

        for(String word : words) {

            int[] charCountInEachWord = new int[26];
            for(char ch : word.toCharArray()){
                charCountInEachWord[ch -'a']++;
            }
            for(int i = 0; i < 26; i++) {
                commonCount[i] = Math.min(commonCount[i], charCountInEachWord[i]);
            }
        }

        List<String> result = new ArrayList<>();
        for(char ch = 'a'; ch <= 'z'; ch++) {
            while(commonCount[ch - 'a'] --> 0){
                String a = ""+ch;
                result.add(a);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FindCommonCharacters findCommonCharacters = new FindCommonCharacters();
        String[] words = {"bellab","labelb","rbollerb"};
        System.out.println(findCommonCharacters.commonChars(words)); // Two b common in all words

    }
}
