package org.atanu.java.ds.array;

import java.util.PriorityQueue;

//https://leetcode.com/problems/maximum-product-of-three-numbers/
//LeetCode 628
public class MaximumProductOfThreeNumbers {

    public int maximumProduct(int[] nums) {
        //Min Heap(Positive) to have Three large positive number
        PriorityQueue<Integer> positiveHeap = new PriorityQueue<>();
        //Max Heap To Get Two smallest numbers(Negative)
        PriorityQueue<Integer> negativeHeap = new PriorityQueue<>((a,b) -> Integer.compare(b, a));

        for(int a : nums){

            positiveHeap.offer(a);
            negativeHeap.offer(a);

            if(positiveHeap.size() > 3){
                positiveHeap.poll();
            }

            if(negativeHeap.size() > 2){
                negativeHeap.poll();
            }
        }

        int max1 = 1;
        int max = 1;

        //max1 will record the result of multiplication three large number
        while(!positiveHeap.isEmpty()){

            max = positiveHeap.poll();
            max1 *= max;
        }

        //Now max have the largest number. we need to multiply with Two negative numbers from negative
        //That will give another possibility
        while(!negativeHeap.isEmpty()){

            max *= negativeHeap.poll();
        }

        return Math.max(max1, max);
    }
}
