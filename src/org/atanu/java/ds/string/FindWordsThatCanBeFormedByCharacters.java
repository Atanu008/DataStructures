package org.atanu.java.ds.string;

//https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
//Leetcode 1160
public class FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {

        int[] charFreq = new int[26];
        for(char ch : chars.toCharArray()){
            charFreq[ch - 'a']++;
        }

        int count = 0;
        for(String word : words){
            int[] wordCharFreq = new int[26];
            for(char ch : word.toCharArray()){
                wordCharFreq[ch - 'a']++;
            }
            boolean isGood = true;
            for(int i = 0; i < 26; i++){
                if(wordCharFreq[i] > charFreq[i]){
                    isGood = false;
                    break;
                }
            }

            count += isGood ? word.length() : 0;
        }
        return count;
    }

    public static void main(String[] args) {
        FindWordsThatCanBeFormedByCharacters formed = new FindWordsThatCanBeFormedByCharacters();
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";
        System.out.println(formed.countCharacters(words, chars));
    }
}
