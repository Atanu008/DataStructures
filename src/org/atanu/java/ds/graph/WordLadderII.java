package org.atanu.java.ds.graph;

import java.util.*;

//https://leetcode.com/problems/word-ladder-ii/
//LeetCode 126
//Video : https://www.youtube.com/watch?v=mIZJIuMpI2M&t=649s
public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictionary = new HashSet<>(wordList);
        Map<String, List<String>> adjacencyList = new HashMap<>();
        buildGraph(beginWord, endWord, adjacencyList, dictionary);
        /*for(Map.Entry<String, ArrayList<String>> entry: adjacencyList.entrySet()){
            System.out.println("Key = " + entry.getKey() +
                             ", Value = " + entry.getValue());
        }*/

        List<String> currentPath = new ArrayList<>();
        currentPath.add(beginWord);
        List<List<String>> result = new ArrayList<>();
        dfs(beginWord, endWord, adjacencyList, currentPath, result);
        return result;
    }

    //Creation of Special Adjacency List is the key
    // Done connect previous edge and same level Node. connect only next leve edge
    // Next level node will have more distance/level
    // we are storing the level using Map<String, Integer> visited = new HashMap<>();
    // For Non visited Node conenct it with current
    // For Visited Node only connect next level Node
    private void buildGraph(String beginWord, String endWord, Map<String, List<String>> adjacencyList, Set<String> dictionary) {

        Queue<String> queue = new ArrayDeque<>();
        Map<String, Integer> visited = new HashMap<>();
        queue.offer(beginWord);
        visited.put(beginWord, 0);
        boolean isFound = false;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                String currentNode = queue.poll();
                adjacencyList.putIfAbsent(currentNode, new ArrayList<>());
                for (int i = 0; i < currentNode.length(); i++) {
                    char[] newStringChar = currentNode.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == currentNode.charAt(i)) {
                            continue;
                        }
                        newStringChar[i] = ch;
                        String newString = new String(newStringChar);
                        if (dictionary.contains(newString)) {

                            if (!visited.containsKey(newString)) {
                                queue.offer(newString);
                                visited.put(newString, visited.get(currentNode) + 1);
                                adjacencyList.get(currentNode).add(newString);
                            } else if (visited.get(newString) == visited.get(currentNode) + 1)
                                adjacencyList.get(currentNode).add(newString);
                        }

                    }
                }
            }
            //if(isFound) break;
        }
    }

    private void dfs(String beginWord, String endWord, Map<String, List<String>> adjacencyList, List<String> currentPath, List<List<String>> result) {

        if (beginWord.equals(endWord)) {
            result.add(new ArrayList<>(currentPath));
            return;
        }

        for (String next : adjacencyList.get(beginWord)) {
            currentPath.add(next);
            dfs(next, endWord, adjacencyList, currentPath, result);
            currentPath.remove(currentPath.size() - 1);
        }
    }

    public static void main(String[] args) {
        WordLadderII wordLadder = new WordLadderII();
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        List<List<String>> result = wordLadder.findLadders(beginWord, endWord, wordList);
        result.forEach(System.out::println);
    }
}
