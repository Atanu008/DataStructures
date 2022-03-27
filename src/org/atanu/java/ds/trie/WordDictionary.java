package org.atanu.java.ds.trie;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/design-add-and-search-words-data-structure/
//LeetCode 211
//Video: https://www.youtube.com/watch?v=BTf05gs_8iU
public class WordDictionary {

    private final TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
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

    public boolean search(String word) {
        return dfs(word, root);
    }

    public boolean dfs(String word, TrieNode current) {

        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(ch == '.') {
                for(TrieNode childTrieNode : current.children.values()) {
                    //i+1 because dont include "." . Do DFS from next characters
                    if(dfs(word.substring(i+1),childTrieNode)) {
                        return true;
                    }
                }
                return false;
            }
            else{
                TrieNode node = current.children.get(ch);
                if(node == null) {
                    return false;
                }
                current = node;
            }

        }
        return current != null && current.isEndOfWord;

    }

    public static class TrieNode {

        public Map<Character, TrieNode> children;
        public boolean isEndOfWord;

        public TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }
}
