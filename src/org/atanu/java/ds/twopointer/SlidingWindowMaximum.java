package org.atanu.java.ds.twopointer;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/sliding-window-maximum/
//LeetCode 239
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] arr, int k) {

        Deque<Integer> queue = new LinkedList<Integer>();
        int n = arr.length;
        int[] result = new int[n-k+1];
        int index = 0;
        for(int i = 0; i < arr.length; i++){
            // remove numbers out of range k
            if(!queue.isEmpty() && queue.peek() == i-k){
                queue.poll();
            }
            // remove smaller numbers in k range as they are useless
            while(!queue.isEmpty() && arr[queue.peekLast()] < arr[i]){
                queue.pollLast();
            }

            queue.offer(i);

            if(i >= k-1){
                result[index++] = arr[queue.peek()];
            }
        }

        return result;
    }
}
