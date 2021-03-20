package org.atanu.java.ds.queue;

import java.util.Deque;
import java.util.LinkedList;

public class MaximumInKSlidingWindow {

    public static void findMaximuminKSlidingWindow(int[] arr, int k) {


        Deque<Integer> queue = new LinkedList<Integer>();
        int n = arr.length;

        int i = 0;
        /* Process first k (or first window) elements of array */
        for (i = 0; i < k; ++i) {
            // For every element, the previous smaller elements are useless so
            // remove them from Qi 
            while (!queue.isEmpty() && arr[queue.peekLast()] <= arr[i])
                queue.removeLast();

            // Add new element at rear of queue
            queue.addLast(i);
        }

        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for (; i < n; ++i) {
            // The element at the front of the queue is the largest element of
            // previous window, so print it 
            if (!queue.isEmpty())
                System.out.print(arr[queue.peekFirst()] + " ");

            // Remove the elements which are out of this window
            while (!queue.isEmpty() && queue.peekFirst() <= i - k)
                queue.removeFirst();

            // Remove all elements smaller than the currently
            // being added element (remove useless elements) 
            while (!queue.isEmpty() && arr[queue.peekLast()] <= arr[i])
                queue.removeLast();

            // Add current element at the rear of Qi
            queue.addLast(i);
        }

        // Print the maximum element of last window
        System.out.print(arr[queue.peekFirst()] + " ");


    }

    public static void main(String[] args) {


        int arr[] = {12, 1, 78, 90, 57, 89, 56, 100};
        int k = 3;

        findMaximuminKSlidingWindow(arr, k);


    }

}
