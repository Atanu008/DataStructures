package org.atanu.java.ds.heap;

import java.util.PriorityQueue;

//Leetcode 215
//https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KthLargest {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int a : nums){

            pq.offer(a);

            if(pq.size() > k){
                pq.poll();
            }
        }

        return pq.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest();
        int[] nums = new int[] {3,2,1,5,6,4};
        int k =2;
        int result = kthLargest.findKthLargest(nums,k);
        System.out.println("Kth Largest Element "+ result);
    }
}
