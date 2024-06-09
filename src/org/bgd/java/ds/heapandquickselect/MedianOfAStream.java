package org.bgd.java.ds.heapandquickselect;

import java.util.PriorityQueue;
import java.util.Queue;

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

            if (smallerHalf.size() > 1) {
                int top = smallerHalf.poll();
                largerHalf.offer(top);
            }

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
