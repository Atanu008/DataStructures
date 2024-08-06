package org.bgd.java.ds.heapandquickselect;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Two Heap Pattern
 * One max Heap and one min Heap is used to track median elements.
 *
 * - Always add new numbers from stream to the min heap(so that largest is at the top).
 * - Rebalance the min heap and add the top of min heap to the max heap
 * - Rebalance the min heap again by adding the top of the max heap to it, in case min heap size is lesser than
 * max heap
 *
 *
 * For finding median,
 * - if total elements processed is even :
 *  median is average of the min heap top and max heap top
 *  else
 *  median is the top of the min heap.
 *
 *
 */

public class MedianOfAStream {
    static class MedianFinder {
        Queue<Integer> smallerHalf;
        Queue<Integer> largerHalf;
        int size;

        public MedianFinder() {
            smallerHalf = new PriorityQueue<>((a, b) -> a - b);
            largerHalf = new PriorityQueue<>((a, b) -> b - a);
            size = 0;
        }

        public void addNum(int num) {
            smallerHalf.offer(num);

            largerHalf.offer(smallerHalf.poll());

            if (smallerHalf.size() < largerHalf.size()) {
                smallerHalf.offer(largerHalf.poll());
            }
            size++;
        }

        public double findMedian() {
            if (size % 2 == 0) {
                return (smallerHalf.peek() / 2.0 + largerHalf.peek() / 2.0);
            }
            return smallerHalf.peek();
        }
    }
}
