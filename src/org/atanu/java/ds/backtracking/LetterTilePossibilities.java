package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterTilePossibilities {
    int count= 0;
    List<List<String>> result = new ArrayList<>();
    public void traverse(char theArray[], boolean used[], List<String> current) {
        result.add(new ArrayList<>(current));
        count++; // count the number of sub-permutation
        for(int i = 0; i < theArray.length; i++) {
            if( used[i] || (i > 0 && theArray[i] == theArray[i - 1] && !used[i - 1]) ) // duplicate removal
                continue;
            used[i] = true;
            current.add(String.valueOf(theArray[i]));
            traverse(theArray, used, current);
            used[i] = false;
            current.remove(current.size() -1);
        }
    }

    public int numTilePossibilities(String tiles) {
        char theArray[] = tiles.toCharArray();
        Arrays.sort(theArray); // sort the array for duplicate removal
        traverse(theArray, new boolean[theArray.length], new ArrayList<>());
        return count - 1;
    }

    public static void main(String[] args) {
        LetterTilePossibilities letterTilePossibilities = new LetterTilePossibilities();
        String s = "aab";
        letterTilePossibilities.numTilePossibilities(s);
        letterTilePossibilities.result.forEach(System.out::println);
    }
}
