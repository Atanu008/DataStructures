package org.atanu.java.ds.heap;

import java.util.PriorityQueue;

//https://www.educative.io/courses/grokking-the-coding-interview/gxxPGn8vE8G
//Time complexity#
//The time complexity of this algorithm is O(K*logK+(N-K)*logK)O(K∗logK+(N−K)∗logK),
//which is asymptotically equal to O(N*logK)O(N∗logK)
public class KthSmallestNumber {
    public static int findKthSmallestNumber(int[] nums, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for(int a : nums) {
            maxHeap.offer(a);
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 5 }, 3);
        System.out.println("Kth smallest number is: " + result);

        // since there are two 5s in the input array, our 3rd and 4th smallest numbers should be a '5'
        result = KthSmallestNumber.findKthSmallestNumber(new int[] { 1, 5, 12, 2, 11, 6 }, 4);
        System.out.println("Kth smallest number is: " + result);

        result = KthSmallestNumber.findKthSmallestNumber(new int[] { 5, 12, 11, -1, 12 }, 3);
        System.out.println("Kth smallest number is: " + result);
    }
}
