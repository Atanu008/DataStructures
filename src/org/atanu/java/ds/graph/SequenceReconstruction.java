package org.atanu.java.ds.graph;

import java.util.*;
import java.util.stream.Stream;

//https://leetcode.com/problems/sequence-reconstruction/
//LeetCode 444
//https://www.educative.io/courses/grokking-the-coding-interview/m7VAO5OrQr3
public class SequenceReconstruction {

    public boolean sequenceReconstruction(int[] originalSeq, List<List<Integer>> sequences) {
        List<Integer> sortedOrder = new ArrayList<>();
        if (originalSeq.length <= 0)
            return false;

        // a. Initialize the graph
        HashMap<Integer, Integer> inDegree = new HashMap<>(); // count of incoming edges for every vertex
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); // adjacency list graph

        for (int vertex : originalSeq) {
            graph.putIfAbsent(vertex, new ArrayList<Integer>());
            inDegree.putIfAbsent(vertex, 0);
        }

        // b. Build the graph
        for (List<Integer> sequence : sequences) {

            for(int i = 0; i < sequence.size() -1; i++) {

                int parent = sequence.get(i);
                int child = sequence.get(i+1);
                graph.get(parent).add(child);
                inDegree.put(child, inDegree.get(child) + 1);
            }
        }

        // if we don't have ordering rules for all the numbers we'll not able to uniquely construct the sequence
        if (inDegree.size() != originalSeq.length)
            return false;

        // c. Find all sources i.e., all vertices with 0 in-degrees
        Queue<Integer> sources = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0)
                sources.add(entry.getKey());
        }

        // d. For each source, add it to the sortedOrder and subtract one from all of its children's in-degrees
        // if a child's in-degree becomes zero, add it to the sources queue
        while (!sources.isEmpty()) {
            if (sources.size() > 1)
                return false; // more than one sources mean, there is more than one way to reconstruct the sequence
            if (originalSeq[sortedOrder.size()] != sources.peek())
                return false; // the next source (or number) is different from the original sequence
            int vertex = sources.poll();
            sortedOrder.add(vertex);
            List<Integer> children = graph.get(vertex); // get the node's children to decrement their in-degrees
            for (int child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0)
                    sources.add(child);
            }
        }

        // if sortedOrder's size is not equal to original sequence's size, there is no unique way to construct
        return sortedOrder.size() == originalSeq.length;
    }

    public static void main(String[] args) {

        SequenceReconstruction sequenceReconstruction = new SequenceReconstruction();
        int[] originalSequence = {3, 1, 4, 2, 5};
        List<List<Integer>> sequences = new ArrayList<>();
        List<Integer> seq1 = List.of(3, 1, 5);
        List<Integer> seq2 = List.of(1, 4, 2, 5);
        sequences.add(seq1);
        sequences.add(seq2);

        boolean result = sequenceReconstruction.sequenceReconstruction(originalSequence, sequences);
        System.out.println(result);

        originalSequence = new int[]{1, 2, 3, 4};
        List<List<Integer>> sequences2 = new ArrayList<>();
        List<Integer> seq2a = List.of(1, 2);
        List<Integer> seq2b = List.of(2, 3);
        List<Integer> seq2c = List.of(2, 4);
        sequences2.add(seq2a);
        sequences2.add(seq2b);
        sequences2.add(seq2c);

        result = sequenceReconstruction.sequenceReconstruction(originalSequence, sequences2);
        System.out.println(result);
    }
}
