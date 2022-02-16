package org.atanu.java.ds.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//https://leetcode.com/problems/maximum-frequency-stack/
//LeetCode 895
//https://www.educative.io/courses/grokking-the-coding-interview/R8o6vV83DLY

//How can we keep track of the frequencies of numbers in the heap?
//When we are pushing a new number to the Max Heap,
//we don’t know how many times the number has already appeared in the Max Heap.
//To resolve this, we will maintain a HashMap to store the current frequency of each number.
//Thus whenever we push a new number in the heap,
//we will increment its frequency in the HashMap and when we pop, we will decrement its frequency.
//If two numbers have the same frequency, we will need to return the number which was pushed later while popping.
//To resolve this, we need to attach a sequence number to every number to know which number came first.
public class MaximumFrequencyStack {
    Map<Integer, Integer> frequencyMap;
    PriorityQueue<Node> maxHeap;
    int sequenceNumber;

    public MaximumFrequencyStack() {
        sequenceNumber = 0;
        frequencyMap = new HashMap<>();
        maxHeap = new PriorityQueue<>((a, b) -> {
            // if both elements have same frequency, return the one that was pushed later
            if(a.frequency == b.frequency){
                return b.sequenceNumber - a.sequenceNumber;
            }
            // Most frequent numver will top at the heap
            return b.frequency - a.frequency;
        });
    }

    public void push(int val) {
        frequencyMap.put(val, frequencyMap.getOrDefault(val, 0) + 1);
        maxHeap.offer(new Node(val, frequencyMap.get(val), sequenceNumber++));
    }

    public int pop() {
        Node maxFrequencyNode = maxHeap.poll();
        int number = maxFrequencyNode.number;

        //Decrement the frequency or remove if this is the last number
        //This is very important,
        //as the if we dont decrement and for next push of an element , it will take the wrong frquency
        if(frequencyMap.get(number) > 1) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) - 1);
        }
        else {
            frequencyMap.remove(number);
        }

        return number;
    }

    static class Node {
        int number;
        int frequency;
        int sequenceNumber;

        public Node(int number, int frequency, int sequenceNumber) {
            this.number = number;
            this.frequency = frequency;
            this.sequenceNumber = sequenceNumber;
        }
    }
}
