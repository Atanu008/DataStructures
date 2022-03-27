package org.atanu.java.ds.string;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/verifying-an-alien-dictionary/
//LeetCode 953
//https://www.educative.io/courses/decode-coding-interview-java/my1vP9DGOPr
public class VerifyingAnAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {

        Map<Character, Integer> alienDictionaryMap = new HashMap<>();

        for(int i = 0; i < order.length(); i++) {
            alienDictionaryMap.put(order.charAt(i), i);
        }

        for(int i = 0; i < words.length -1; i++) {
            String wordA = words[i];
            String wordB = words[i+1];
            //Check each Character of first
            for(int j = 0; j < wordA.length(); j++) {
                // If we do not find a mismatch letter between messages[i] and messages[i + 1],
                // we need to examine the case when messages are like ("educated", "educate").
                // If the second word is prefix of first word return false
                if(j >= wordB.length()) {
                    return false;
                }

                char charInWordA = wordA.charAt(j);
                char charInWordB = wordB.charAt(j);

                if(charInWordA != charInWordB) {
                    if(alienDictionaryMap.get(charInWordA) > alienDictionaryMap.get(charInWordB)) {
                        return false;
                    }
                    // if we find the first different character and they are sorted,
                    // then there's no need to check remaining letters
                    else {
                        break;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        VerifyingAnAlienDictionary alienDictionary = new VerifyingAnAlienDictionary();
        String[] words = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        boolean result = alienDictionary.isAlienSorted(words, order);
        System.out.println(result);

        words = new String[]{"word", "world", "row"};
        order = "worldabcefghijkmnpqstuvxyz";
        result = alienDictionary.isAlienSorted(words, order);
        System.out.println(result);

        words = new String[]{"apple","app"};
        order = "abcdefghijklmnopqrstuvwxyz";
        result = alienDictionary.isAlienSorted(words, order);
        System.out.println(result);
    }
}
