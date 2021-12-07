package org.atanu.java.ds.heap;

import java.util.PriorityQueue;

//https://leetcode.com/problems/find-median-from-data-stream/
//LeetCode 295

//https://leetcode.com/problems/find-median-from-data-stream/discuss/1330646/C%2B%2BJavaPython-MinHeap-MaxHeap-Solution-Picture-explain-Clean-and-Concise

//The idea is to divide numbers into 2 balanced halves, one half low stores low numbers, the other half high stores high numbers. To access the median in O(1), we need a data structure that give us the maximum of low half and the minimum of high half in O(1). That's where maxHeap and minHeap come into play.
//We use maxHeap to store a half of low numbers, top of the maxHeap is the highest number among low numbers.
//We use minHeap to store a half of high numbers, top of the minHeap is the lowest number among high numbers.
//We need to balance the size between maxHeap and minHeap while processing. Hence after adding k elements,
//If k = 2 * i then maxHeap.size = minHeap.size = i
//If k = 2 * i + 1, let maxHeap store 1 element more than minHeap, then maxHeap.size = minHeap.size + 1.
//When adding a new number num into our MedianFinder:
//Firstly, add num to the maxHeap, now maxHeap may contain the big element (which should belong to minHeap). So we need to balance, by removing the highest element from maxHeap, and offer it to minHeap.
//Now, the minHeap might hold more elements than maxHeap, in that case, we need to balance the size, by removing the lowest element from minHeap and offer it back to maxHeap.
//When doing findMedian():
//If maxHeap.size > minHeap.size return top of the maxHeap, which is the highest number amongs low numbers.
//Else if maxHeap.size == minHeap return the (maxHeap.top() + minHeap.top()) / 2.
public class FindMedianFromDataStream {

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public FindMedianFromDataStream() {
        //minHeap = new PriorityQueue<>();
        //maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        minHeap = new PriorityQueue<>((a,b) -> a - b);
        maxHeap = new PriorityQueue<>((a,b) -> b - a);
    }

    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {

        if(maxHeap.size() == minHeap.size()){
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }
        else{
            return maxHeap.peek();
        }
    }
}
