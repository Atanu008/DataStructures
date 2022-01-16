package org.atanu.java.ds.heap;

import java.util.PriorityQueue;

//https://leetcode.com/problems/find-median-from-data-stream/
//LeetCode 295
public class FindMedianFromDataStreamV2 {

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public FindMedianFromDataStreamV2() {
        //minHeap = new PriorityQueue<>();
        //maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        minHeap = new PriorityQueue<>((a,b) -> a - b);
        maxHeap = new PriorityQueue<>((a,b) -> b - a);
    }

    public void addNum(int num) {
        if(maxHeap.isEmpty() || num <= maxHeap.peek()){
            maxHeap.offer(num);
        }
        else{
            minHeap.offer(num);
        }

        rebalance();
    }

    public double findMedian() {

        if(maxHeap.size() == minHeap.size()){
            return ((double)maxHeap.peek() + (double)minHeap.peek())/2;
        }
        else{
            return maxHeap.peek();
        }
    }

    private void rebalance(){

        // either both the heaps will have equal number of elements or max-heap will have one
        // more element than the min-heap
        if(maxHeap.size() > minHeap.size() +1){
            minHeap.offer(maxHeap.poll());
        }
        else if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }
}
