package org.atanu.java.ds.heap;

//https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
//LeetCide 373

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//Similar solution as LeetCode 378(Min Heap): https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
//Min Heap Approach
public class FindKPairsWithSmallestSums {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();
        //Min heap of Pair
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> (a.getFirst() + a.getSecond()) - (b.getFirst() + b.getSecond()));

        int N1 = nums1.length;
        //Take all the elements or K elements from Firsy array and make a pair with First Element from the sorted Array
        //As the array is sorted those combinations will have the smallest sums
        //Top Node of the Heap will have the smallest sum(first, second)
        for(int i = 0; i < Math.min(N1,k); i++){
            pq.add(new Node(nums1[i], nums2[0], 0));
        }

        //Everytime we pop element we add it to the result;
        //if possible we offer potential better pair
        //by adding next element from the second array to form more combination
        for(int i = 0; i < k && !pq.isEmpty(); i++){
            List<Integer> currentSmallestPair = new ArrayList<>();
            Node smallestPopped = pq.poll();
            int first = smallestPopped.getFirst();
            int second = smallestPopped.getSecond();
            int secondElementArrayIndex = smallestPopped.getSecondElementArrayIndex();
            currentSmallestPair.add(first);
            currentSmallestPair.add(second);
            result.add(currentSmallestPair);

            if(secondElementArrayIndex < nums2.length -1){
                pq.add(new Node(first, nums2[secondElementArrayIndex + 1], secondElementArrayIndex + 1));
            }

        }

        return result;
    }

    static class Node{
        int first;
        int second;
        int secondElementArrayIndex;

        public Node(int first, int second, int secondElementArrayIndex){
            this.first = first;
            this.second = second;
            this.secondElementArrayIndex = secondElementArrayIndex;
        }

        public int getFirst(){
            return first;
        }
        public int getSecond(){
            return second;
        }
        public int getSecondElementArrayIndex(){
            return secondElementArrayIndex;
        }
    }

    public static void main(String[] args) {
        FindKPairsWithSmallestSums findKPairsWithSmallestSums = new FindKPairsWithSmallestSums();
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        int k = 3;
        //Output: [[1,2],[1,4],[1,6]]
        //Explanation: The first 3 pairs are returned from the sequence:
        // [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

        List<List<Integer>> result = findKPairsWithSmallestSums.kSmallestPairs(nums1, nums2, k);
        result.forEach(System.out::println);
    }
}
