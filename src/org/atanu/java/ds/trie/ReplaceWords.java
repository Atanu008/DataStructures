package org.atanu.java.ds.trie;

//https://leetcode.com/problems/replace-words/
//LeetCode 648

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaceWords {

    public String replaceWords(List<String> dictionary, String sentence) {

        Trie trie = new Trie();
        for(String word: dictionary){
            trie.insert(word);
        }

        String[] wordInSentence = sentence.split(" ");
        List<String> result = new ArrayList<>();

        for(String word : wordInSentence) {
            result.add(getShortestLengthRoot(word, trie));
        }

        return String.join(" ", result);
    }

    public String getShortestLengthRoot(String token, Trie trie) {
        TrieNode current = trie.root;
        StringBuilder shortestRoot = new StringBuilder();
        for(int i = 0; i < token.length(); i++) {
            char ch = token.charAt(i);
            shortestRoot.append(ch);
            TrieNode node = current.children.get(ch);
            //Not found in Trie. Can not be replaced. return the input token only;
            if(node == null) {
                return token;
            }
            //Word has been found if isEndOfWord . return immediatly as this is shortest
            if(node.isEndOfWord){
                return shortestRoot.toString();
            }

            current = node;
        }

        return token;
    }

    private static class Trie{

        final TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode current = root;
            for(int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                TrieNode node = current.children.get(ch);
                if(node == null) {
                    node = new TrieNode();
                    current.children.put(ch, node);
                }
                current = node;
            }

            current.isEndOfWord = true;
        }
    }

    private static class TrieNode{
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }
}
