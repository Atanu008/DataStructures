package org.atanu.java.ds.graph;

import java.util.*;

//https://leetcode.com/problems/alien-dictionary/
//LeetCode 269
//https://www.educative.io/courses/grokking-the-coding-interview/R8AJWOMxw2q
public class AlienDictionary {

    public String alienOrder(String[] words) {

        Map<Character, Integer> inDegree = new HashMap<>();
        Map<Character, List<Character>> adjList = new HashMap<>();

        for(String word : words) {
            for(char ch : word.toCharArray()) {
                inDegree.put(ch, 0);
                adjList.put(ch , new ArrayList<>());
            }
        }

        //Build the Graph
        for(int i = 0; i < words.length - 1; i++) {
            // find ordering of characters from adjacent words
            String word1 = words[i];
            String word2 = words[i+1];
            if(word1.length() > word2.length() && word1.startsWith(word2)) {
                return "";
            }
            for(int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                Character parent = word1.charAt(j);
                Character child = word2.charAt(j);
                if(parent != child) {// if the two characters are different
                    adjList.get(parent).add(child); // put the child into it's parent's list
                    inDegree.put(child, inDegree.get(child) +1);// increment child's inDegree
                    break; // only the first different character between the two words will help us find the order
                }
            }
        }

        //Find all sources i.e., all vertices with 0 in-degrees
        Queue<Character> queue = new LinkedList<>();
        for(Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if(entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }
        //For each source, add it to the sortedOrder and subtract one from all of its children's in-degrees
        // if a child's in-degree becomes zero, add it to the sources queue
        StringBuilder sortedOrderString = new StringBuilder();
        while(!queue.isEmpty()) {
            Character currentChar = queue.poll();
            sortedOrderString.append(currentChar);
            for(Character neighbour : adjList.get(currentChar)) {
                inDegree.put(neighbour, inDegree.get(neighbour) -1);
                if(inDegree.get(neighbour) == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        // if sortedOrder doesn't contain all characters, there is a cyclic dependency between characters, therefore, we
        // will not be able to find the correct ordering of the characters
        if (sortedOrderString.length() != inDegree.size()) {
            return "";
        }

        return sortedOrderString.toString();
    }

    public static void main(String[] args) {

        AlienDictionary alienDictionary = new AlienDictionary();
        String result = alienDictionary.alienOrder(new String[] { "ba", "bc", "ac", "cab" });
        System.out.println("Character order: " + result);

        result = alienDictionary.alienOrder(new String[] { "cab", "aaa", "aab" });
        System.out.println("Character order: " + result);

        result = alienDictionary.alienOrder(new String[] { "ywx", "wz", "xww", "xz", "zyy", "zwz" });
        System.out.println("Character order: " + result);

        result = alienDictionary.alienOrder(new String[] { "wrt","wrf","er","ett","rftt" });
        System.out.println("Character order: " + result);

        result = alienDictionary.alienOrder(new String[] { "z","x","z" }); //Cycle
        System.out.println("Character order: " + result);
    }
}
