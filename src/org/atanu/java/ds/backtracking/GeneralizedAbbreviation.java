package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/generalized-abbreviation/
//LeetCode 320

//https://www.educative.io/courses/grokking-the-coding-interview/NEOZDEg5PlN
public class GeneralizedAbbreviation {

    public List<String> generateAbbreviations(String word) {

        List<String> result = new ArrayList<>();
        backtrack(word, new StringBuilder(), result, 0, 0);

        return result;
    }

    private void backtrack(String word, StringBuilder abWord, List<String> result, int index, int count) {

        if(index == word.length()) {
            if(count != 0) {
                abWord.append(count);
            }

            result.add(abWord.toString());
            return;
        }

        //Abbreviate, i.e dont take the charracter, just increment the count
        backtrack(word, new StringBuilder(abWord), result, index + 1, count +1);

        //restart abbreviating, append the count and the current character to the string
        if(count != 0) {
            abWord.append(count);
        }
        backtrack(word, new StringBuilder(abWord).append(word.charAt(index)), result, index + 1, 0);
    }

    public static void main(String[] args) {
        String word = "word";
        GeneralizedAbbreviation generalizedAbbreviation = new GeneralizedAbbreviation();
        List<String> result = generalizedAbbreviation.generateAbbreviations(word);
        System.out.println(result);
    }
}


