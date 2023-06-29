package org.atanu.java.ds.twopointer;

import java.util.Deque;
import java.util.LinkedList;

// https://leetcode.com/problems/sliding-window-maximum/
// LeetCode 239
// Video : https://www.youtube.com/watch?v=CZQGRp93K4k

public class SlidingWindowMaximum {

    // we will introduce an interesting data structure

    // i.e. monotonic doubly-ended queue. Don't get afraid of the name,
    // it is just a doubly ended queue in which elements from head to tail is in decreasing order (hence it is named monotonic).

    // You want to ensure the deque window only has Decreasing elements to the last (peeklast).
    // Decreasing Deque : Largest value at first and smallest value at last

    // To transform a simple doubly-ended queue into a monotonic doubly ended queue,
    // we will modify the push operation so that -
    // "Before we push x in the queue, we pop out all elements less than x".

    public int[] maxSlidingWindow(int[] arr, int k) {

        Deque<Integer> queue = new LinkedList<>();
        int n = arr.length;
        int[] result = new int[n-k+1];
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            // remove numbers out of range k
            if(!queue.isEmpty() && queue.peekFirst() == i-k){
                queue.pollFirst();
            }
            // remove smaller numbers in k range as they are useless
            // This will ensure we have only largest value at the first Head
            while(!queue.isEmpty() && arr[queue.peekLast()] < arr[i]){
                queue.pollLast();
            }
            // Store Index . Not the value
            queue.addLast(i);

            if(i >= k-1){
                result[index++] = arr[queue.peekFirst()];
            }
        }

        return result;
    }
}
