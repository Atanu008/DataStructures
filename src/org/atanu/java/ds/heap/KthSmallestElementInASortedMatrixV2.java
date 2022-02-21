package org.atanu.java.ds.heap;

import java.util.PriorityQueue;

//Same Implementation as kthSmallestV2 method.
// Here in the custom class we are not storing the value
// Only Row and Column
//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
//LeetCode 378
public class KthSmallestElementInASortedMatrixV2 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> minHeap = new PriorityQueue<Node>((a, b) -> matrix[a.row][a.col] - matrix[b.row][b.col]);

        // put the 1st element of each row in the min heap
        // we don't need to push more than 'k' elements in the heap
        for (int i = 0; i < matrix.length && i < k; i++)
            minHeap.add(new Node(i, 0));

        // take the smallest (top) element form the min heap, if the running count is equal to k return the number
        // if the row of the top element has more elements, add the next element to the heap
        int numberCount = 0, result = 0;
        while (!minHeap.isEmpty()) {
            numberCount++;
            Node node = minHeap.poll();
            result = matrix[node.row][node.col];

            if (numberCount == k)
                break;

            if (node.col < matrix[node.row].length -1){
                node.col++;
                minHeap.add(node);
            }
        }
        return result;
    }

    class Node {
        int row;
        int col;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        KthSmallestElementInASortedMatrixV2 kSortedMatrix = new KthSmallestElementInASortedMatrixV2();
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;
        // Output: 13
        //Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
        System.out.println(k+"th Smallest Number is "+kSortedMatrix.kthSmallest(matrix,k));
    }
}
