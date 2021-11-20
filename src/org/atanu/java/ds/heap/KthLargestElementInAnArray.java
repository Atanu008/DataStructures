package org.atanu.java.ds.heap;

import java.util.Collections;
import java.util.PriorityQueue;

//Leetcode 215
//https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KthLargestElementInAnArray {

    //Time complexity : O(Nlogk).
    //Space complexity :O(k) to store the heap elements.
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int a : nums){

            pq.offer(a);

            if(pq.size() > k){
                pq.poll();
            }
        }

        return pq.poll();
    }

    //Using Max heap
    //We need to insert all teh elements in the Queue
    //return the element after removing k -1 largest elements
    public int findKthLargestV2(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int a : nums){
            pq.offer(a);
        }

        for(int i = 0; i < k -1; i++){
            pq.poll();
        }

        return pq.poll();

    }



    public static void main(String[] args) {
        KthLargestElementInAnArray kthLargest = new KthLargestElementInAnArray();
        int[] nums = new int[] {3,2,1,5,6,4};
        int k =2;
        int result = kthLargest.findKthLargest(nums,k);
        System.out.println("Kth Largest Element "+ result);
    }
}
