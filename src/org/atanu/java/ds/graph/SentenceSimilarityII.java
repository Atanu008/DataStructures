package org.atanu.java.ds.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/sentence-similarity-ii/
//LeetCode 737
//Video : https://www.youtube.com/watch?v=Oj4pnHx_piQ
public class SentenceSimilarityII {

    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {

        //Base case
        if (sentence1.length != sentence2.length) {
            return false;
        }

        UnionFind unionFind = new UnionFind();
        //Put similar words in same set.
        for (List<String> pair : similarPairs) {
            String stringA = pair.get(0);
            String stringB = pair.get(1);

            unionFind.union(stringA, stringB); // Build the Union On Similar Pairs
        }

        for (int i = 0; i < sentence1.length; i++) {
            String wordA = sentence1[i];
            String wordB = sentence2[i];
            // If the words are different and also they dont belong to the same disjoint set i.e their root is differnet then they are not similar. Return false
            if (!wordA.equals(wordB) && !unionFind.find(wordA).equals(unionFind.find(wordB))) {
                return false;
            }
        }

        return true;
    }

    static class UnionFind {

        Map<String, String> root;
        Map<String, Integer> rank;

        public UnionFind() {
            root = new HashMap<>();
            rank = new HashMap<>();
        }

        public String find(String x) {
            //Initialize if first time
            if (!root.containsKey(x)) {
                root.put(x, x);
                rank.put(x, 1);
            }

            // if `x` is not the root
            if (!x.equals(root.get(x))) {
                root.put(x, find(root.get(x))); //Path Compression
            }

            return root.get(x);
        }

        public void union(String x, String y) {

            String rootX = find(x);
            String rootY = find(y);

            if (!rootX.equals(rootY)) {

                if (rank.get(rootX) > rank.get(rootY)) {
                    root.put(rootY, rootX);
                } else if (rank.get(rootX) < rank.get(rootY)) {
                    root.put(rootX, rootY);
                } else {
                    root.put(rootY, rootX);
                    rank.put(rootX, rank.get(rootX) + 1);
                }
            }
        }

    }
}
