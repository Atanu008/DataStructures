package org.atanu.java.ds.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//LeetCode 1079
//https://leetcode.com/problems/letter-tile-possibilities/

//Duplicate removal is the same as 47. Permutations II
//where we need to sort the array first and judge whether current element is equal to the previous one.
//Number counting is the same as 90. Subsets II where we count the number at the beginning of each round of traversal.
public class LetterTilePossibilities {
    int count = 0;
    List<List<String>> result = new ArrayList<>(); // We dont need result. but to debug

    public int numTilePossibilities(String tiles) {
        List<String> permutation = new ArrayList<>();
        char[] tileschar = tiles.toCharArray();
        Arrays.sort(tileschar);
        boolean[] visited = new boolean[tiles.length()];
        backtrack(tileschar, permutation, visited);
        return count -1;
    }

    public void backtrack(char[] tileschar, List<String> permutation,boolean[] visited){
        //Add permute to Result and increment the counter
        result.add(new ArrayList<>(permutation));
        count++;

        //when a number has the same value with its previous, we can use this number only if his previous is used
        //i > 0 && tileschar[i] == tileschar[i-1] && !tileschar[i-1]
        //i > 0 && tileschar[i] == tileschar[i-1] && tileschar[i-1]
        //Both will work
        for(int i = 0; i < tileschar.length; i++){
            if(visited[i])
                continue;
            if(i > 0 && tileschar[i] == tileschar[i -1] && !visited[i-1])
                continue;
            visited[i] = true;
            permutation.add(new String(String.valueOf(tileschar[i])));
            backtrack(tileschar, permutation, visited);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }

    public static void main(String[] args) {
        LetterTilePossibilities letterTilePossibilities = new LetterTilePossibilities();
        String s = "aab";
        letterTilePossibilities.numTilePossibilities(s);
        letterTilePossibilities.result.forEach(System.out::println);
    }
}
