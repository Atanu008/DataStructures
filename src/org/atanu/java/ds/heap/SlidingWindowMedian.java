package org.atanu.java.ds.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/sliding-window-median/
//LeetCode 480
//Video : https://www.youtube.com/watch?v=aIEf_SJcyVY&t=1792s
//Check Educative https://www.educative.io/courses/grokking-the-coding-interview/3Y9jm7XRrXO
public class SlidingWindowMedian {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a.compareTo(b));
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b.compareTo(a));

    //PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    //PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public double[] medianSlidingWindow(int[] nums, int k) {

        double[] result = new double[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {

            if (maxHeap.isEmpty() || nums[i] <= maxHeap.peek()) {
                maxHeap.offer(nums[i]);
            } else {
                minHeap.offer(nums[i]);
            }
            //ReBalance as new elements added
            reBalance();

            // if we have at least 'k' elements in the sliding window
            // add the median to the the result array
            if (i - k + 1 >= 0) {
                // we have even number of elements, take the average of middle two elements
                if (maxHeap.size() == minHeap.size()) {
                    result[i - k + 1] = maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
                } else { // because max-heap will have one more element than the min-heap
                    result[i - k + 1] = maxHeap.peek();
                }

                // remove the element going out of the sliding window
                int ElementToBeRemoved = nums[i - k + 1];

                if (ElementToBeRemoved <= maxHeap.peek()) {
                    maxHeap.remove(ElementToBeRemoved);
                } else {
                    minHeap.remove(ElementToBeRemoved);
                }

                reBalance();
            }


        }
        return result;
    }

    private void reBalance() {
        // either both the heaps will have equal number of elements or max-heap will have
        // one more element than the min-heap
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public static void main(String[] args) {
        SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        //Output: [1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]
        //Explanation:
        //Window position                Median
        //---------------                -----
        //[1  3  -1] -3  5  3  6  7        1
        // 1 [3  -1  -3] 5  3  6  7       -1
        // 1  3 [-1  -3  5] 3  6  7       -1
        // 1  3  -1 [-3  5  3] 6  7        3
        // 1  3  -1  -3 [5  3  6] 7        5
        // 1  3  -1  -3  5 [3  6  7]       6

        double[] result = slidingWindowMedian.medianSlidingWindow(nums,k);
        System.out.println(Arrays.toString(result));
    }
}
