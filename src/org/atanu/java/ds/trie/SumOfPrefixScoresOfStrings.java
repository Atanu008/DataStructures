package org.atanu.java.ds.trie;

public class SumOfPrefixScoresOfStrings {
    TrieNode root = new TrieNode();

    public int[] sumPrefixScores(String[] words) {

        for(String word : words){
            add(word);
        }

        int[] sumPrefixScores = new int[words.length];
        int index= 0;
        for(String word : words){
            sumPrefixScores[index++] = calculateScore(word);
        }
        return sumPrefixScores;
    }

    public void add(String word){
        TrieNode temp = root;
        for(char ch : word.toCharArray()){
            int eachChar = ch - 'a';
            if(temp.children[eachChar] == null){
                temp.children[eachChar] = new TrieNode();
            }
            temp.children[eachChar].score++;
            temp = temp.children[eachChar];
        }
    }


    public int calculateScore(String word){
        TrieNode temp = root;
        int score = 0;
        for(char ch : word.toCharArray()){
            int eachChar = ch - 'a';
            score += temp.children[eachChar].score;
            temp = temp.children[eachChar];
        }
        return  score;
    }

    private static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        int score = 0;
    }
}
