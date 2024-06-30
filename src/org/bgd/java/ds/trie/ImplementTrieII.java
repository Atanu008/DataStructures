package org.bgd.java.ds.trie;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.naukri.com/code360/problems/implement-trie_1387095?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos
 *
 * oblem statement
 * Ninja has to implement a data structure ”TRIE” from scratch. Ninja has to complete some functions.
 * 1) Trie(): Ninja has to initialize the object of this “TRIE” data structure.
 *
 * 2) insert(“WORD”): Ninja has to insert the string “WORD”  into this “TRIE” data structure.
 *
 * 3) countWordsEqualTo(“WORD”): Ninja has to return how many times this “WORD” is present in this “TRIE”.
 *
 * 4) countWordsStartingWith(“PREFIX”): Ninjas have to return how many words are there in this “TRIE” that have the string “PREFIX” as a prefix.
 *
 * 5) erase(“WORD”): Ninja has to delete one occurrence of the string “WORD” from the “TRIE”.
 * Note:
 * 1. If erase(“WORD”) function is called then it is guaranteed that the “WORD” is present in the “TRIE”.
 *
 * 2. If you are going to use variables with dynamic memory allocation then you need to release the memory associated with them at the end of your solution.
 * Can you help Ninja implement the "TRIE" data structure?
 *
 */
public class ImplementTrieII {

    class TrieNode {
        int count;
        int countWord;
        boolean isWord;
        Map<Character, TrieNode> children;

        TrieNode() {
            this.children = new HashMap<>();
            this.isWord = false;
            this.count = 0;
            this.countWord = 0;
        }
    }

    public class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode head = root;
            for (Character c : word.toCharArray()) {
                if (head.children.containsKey(c)) {
                    head = head.children.get(c);
                } else {
                    head.children.put(c, new TrieNode());
                    head = head.children.get(c);
                }
                head.count += 1;
            }
            head.isWord = true;
            head.countWord += 1;
        }

        public int countWordsEqualTo(String word) {
            TrieNode head = root;
            for (Character c : word.toCharArray()) {
                if (head.children.containsKey(c)) {
                    head = head.children.get(c);
                } else {
                    return 0;
                }
            }
            if (head.isWord) {
                return head.countWord;
            }
            return 0;
        }

        public int countWordsStartingWith(String word) {
            TrieNode head = root;

            for (Character c : word.toCharArray()) {
                if (head.children.containsKey(c)) {
                    head = head.children.get(c);
                } else {
                    return 0;
                }
            }
            return head.count;
        }

        public void erase(String word) {
            TrieNode head = root;

            for (Character c : word.toCharArray()) {
                if (head.children.containsKey(c)) {
                    head = head.children.get(c);
                    head.count -= 1;
                }
            }

            head.countWord -= 1;
            if (head.countWord == 0) {
                head.isWord = false;
            }
        }

    }

}
