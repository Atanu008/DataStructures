package org.atanu.java.ds.trie;

//https://leetcode.com/problems/implement-trie-prefix-tree/
//LeetCode 208
//Video : https://www.youtube.com/watch?v=giiaIofn31A
//An Array Implementation considering only 26 char.
public class TrieV2 {

    private TrieNode root;

    public TrieV2() {
        root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children[ch - 'a'];
            if(node == null) {
                node = new TrieNode();
                current.children[ch - 'a'] = node;
            }
            current = node;
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {

        TrieNode lastNode = getLastNode(word);
        return lastNode != null && lastNode.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode lastNode = getLastNode(prefix);
        return lastNode != null;
    }

    public TrieNode getLastNode(String word) {

        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children[ch - 'a'];
            if(node == null) {
                return null;
            }
            current = node;
        }
        return current;
    }

    static class TrieNode {

        public TrieNode[] children;
        public boolean isEndOfWord;

        public TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }
}
