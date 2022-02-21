package org.atanu.java.ds.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//https://www.educative.io/courses/grokking-the-coding-interview/myAqDMyRXn3

//Similar Problem : Given ‘M’ sorted arrays, find the median number among all arrays.
//Solution: This problem is similar to our parent problem with K=Median.
//So if there are ‘N’ total numbers in all the arrays we need to find the K’th minimum number where K=N/2K=N/2.

//Similar Problem is MergeKSortedArray.java. We have the solution here.
//In that program we are storing the array reference itself ,
//But like this implementation we can store only the array indexes
public class KthSmallestInMSortedArrays {

    private static class Node {
        int arrayIndex;
        int elementIndex;

        public Node(int arrayIndex, int elementIndex) {
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
        }
    }

    public static int findKthSmallest(List<Integer[]> lists, int k) {

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) ->
            lists.get(a.arrayIndex)[a.elementIndex] - lists.get(b.arrayIndex)[b.elementIndex]
        );

        for(int i = 0; i < lists.size(); i++) {
            if(lists.get(i) != null){
                minHeap.offer(new Node(i, 0));
            }
        }

        int numberCount = 0;
        int result = 0;
        while(!minHeap.isEmpty()) {
            numberCount++;
            Node currentMinNode = minHeap.poll();
            result = lists.get(currentMinNode.arrayIndex)[currentMinNode.elementIndex];
            if(numberCount == k) {
                break;
            }

            if(currentMinNode.elementIndex < lists.get(currentMinNode.arrayIndex).length -1) {
                currentMinNode.elementIndex++;
                minHeap.offer(currentMinNode);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] l1 = new Integer[] { 2, 6, 8 };
        Integer[] l2 = new Integer[] { 3, 6, 7 };
        Integer[] l3 = new Integer[] { 1, 3, 4 };
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        int result = KthSmallestInMSortedArrays.findKthSmallest(lists, 5);
        System.out.print("Kth smallest number is: " + result);
    }
}
