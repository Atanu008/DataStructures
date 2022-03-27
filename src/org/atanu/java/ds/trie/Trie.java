package org.atanu.java.ds.trie;

//https://leetcode.com/problems/implement-trie-prefix-tree/
//LeetCode 208
//Video : https://www.youtube.com/watch?v=giiaIofn31A
public class Trie {
    private final TrieNode root;

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
            TrieNode node = current.children.get(ch);
            if(node == null) {
                return null;
            }
            current = node;
        }
        return current;
    }
}
