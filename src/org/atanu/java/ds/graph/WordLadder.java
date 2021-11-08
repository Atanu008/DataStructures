package org.atanu.java.ds.graph;

import java.util.*;

//https://leetcode.com/problems/word-ladder/
//LeetCode 127
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictionary = new HashSet<>(wordList); // Set is faster than List to check
        Set<String> visited = new HashSet<>(); // For BFS Track
        Queue<String> queue = new LinkedList<>(); // Standard BFS Queue
        queue.offer(beginWord);
        visited.add(beginWord);

        int len = 1; // already one item in Queue. we need to return the items Not Path length

        while (!queue.isEmpty()) {

            int size = queue.size();
            while (size-- > 0) {
                String currentNode = queue.poll();
                if (currentNode.equals(endWord)) {
                    return len;
                }

                for (int i = 0; i < currentNode.length(); i++) {
                    char[] newStringChar = currentNode.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == currentNode.charAt(i)) {
                            continue;
                        }
                        newStringChar[i] = ch;
                        String newString = new String(newStringChar);

                        if (!visited.contains(newString) && dictionary.contains(newString)) {
                            visited.add(newString);
                            queue.offer(newString);
                        }
                    }
                }
            }

            len++; // Processed Next level

        }

        return 0;

    }

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println("One shortest transformation sequence is "+wordLadder.ladderLength(beginWord,endWord,wordList) );
    }
}
