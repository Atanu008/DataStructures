package org.atanu.java.ds.heap;

import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/
//LeetCode 632
//https://www.educative.io/courses/grokking-the-coding-interview/JPGWDNRx3w2
public class SmallestRangeCoveringElementsfromKLists {

    public int[] smallestRange(List<List<Integer>> nums) {

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) ->
                nums.get(a.arrayIndex).get(a.elementIndex) - nums.get(b.arrayIndex).get(b.elementIndex)
        );
        // put the 1st element of each array in the min heap
        // Calculate Max
        int currentMax = Integer.MIN_VALUE;
        for(int i = 0; i < nums.size(); i++) {
            minHeap.offer(new Node(i, 0));
            currentMax = Math.max(currentMax, nums.get(i).get(0));
        }

        int rangeStart = 0;
        int rangeEnd = Integer.MAX_VALUE;

        // take the smallest (top) element form the min heap, if it gives us smaller range, update the ranges
        // if the array of the top element has more elements, insert the next element in the heap
        while(minHeap.size() == nums.size()) {

            Node curretMinNode = minHeap.poll();
            if(currentMax - nums.get(curretMinNode.arrayIndex).get(curretMinNode.elementIndex) < rangeEnd - rangeStart) {
                rangeStart = nums.get(curretMinNode.arrayIndex).get(curretMinNode.elementIndex);
                rangeEnd = currentMax;
            }

            if(curretMinNode.elementIndex < nums.get(curretMinNode.arrayIndex).size() -1){
                curretMinNode.elementIndex++;
                minHeap.offer(curretMinNode);
                currentMax = Math.max(currentMax, nums.get(curretMinNode.arrayIndex).get(curretMinNode.elementIndex));
            }
        }

        return new int[]{rangeStart, rangeEnd};
    }

    private static class Node{

        int arrayIndex;
        int elementIndex;

        public Node(int arrayIndex, int elementIndex) {
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
        }
    }
}
