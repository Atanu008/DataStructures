package org.atanu.java.ds.heap;

import java.util.Collections;
import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
//LeetCode 378

//Video Binary Search: https://www.youtube.com/watch?v=F22d27HJsxg
public class KthSmallestElementInASortedMatrix {

    //Max Heap keeps up to k elements
    //Time: O(M * N * logK)
    //Space: O(K), space for heap which stores up to k elements.
    public int kthSmallest(int[][] matrix, int k) {

        int row = matrix.length;
        int column = matrix[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                pq.offer(matrix[i][j]);
                if(pq.size() > k){
                    pq.poll();
                }
            }
        }

        return pq.poll();
    }

    //Time: O(K * logK)
    //Space: O(K)
    //Since each of the rows in matrix are already sorted,
    // we can understand the problem as finding the kth smallest element from amongst M sorted rows.
    public int kthSmallestV2(int[][] matrix, int k) {

        int row = matrix.length;
        int column = matrix[0].length;
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());

        //Push all the Elements from first Column of All Rows Or K rows whichever is smaller
        //Because we want to forward our pointer towards right in each row. Same as k sorted list
        for(int i = 0; i < Math.min(row,k); i++){
            pq.offer(new Node(i,0,matrix[i][0]));
        }

        //Poll  K-1 elements
        //We start the pointers to point to the beginning of each rows, then we iterate k times,
        //for each time ith, the top of the minHeap is the ith smallest element in the matrix.
        //We pop the top from the minHeap then add the next element which has the same row with that top to the minHeap.
        for(int i = 0; i < k-1; i++){
            Node node = pq.poll();
            int currentRow = node.getRow();
            int currentColumn = node.getColumn();
            if(currentColumn < column -1){
                pq.offer(new Node(currentRow,currentColumn+1,matrix[currentRow][currentColumn+1]));
            }
        }

        return pq.poll().getValue();
    }

    static class Node{
        int row;
        int column;
        int value;
        public Node(int row, int column, int value){
            this.row = row;
            this.column = column;
            this.value = value;
        }

        public int getRow(){
            return row;
        }
        public int getColumn(){
            return column;
        }
        public int getValue(){
            return value;
        }

    }

    //This is bit Tricky
    //Binary Search On Range
    //lets find An Element such that there are K less than Equal Number
    //Search as left as possible like first bad Number

    //Time Complexity:O(N×log(Max−Min))
    public int kthSmallestV3(int[][] matrix, int k) {

        int row = matrix.length;
        int column = matrix[0].length;
        int low = matrix[0][0];
        int high = matrix[row-1][column-1];

        while(low < high){

            int mid = low + (high - low)/2;
            int count = equalsOrLessthanK(matrix, mid);
            if(count < k){
                low = mid + 1;
            }
            else {
                high = mid;
            }
        }

        return high;
    }

    public int equalsOrLessthanK(int[][] matrix, int target){
        int row = matrix.length -1;
        int column = 0;
        int count = 0;
        //Start with last element in the first column i.e matrix[row -1][0]
        //and Move upwards
        //If the element is greater that target then No elemenet would be smaller. Just decrement the row
        //If the Element is smaller or equal than all the elements from all the rows above of that same column will be slammer
        // Thats why will add row+1 to the count
        while(row >= 0 && column < matrix[0].length){

            if(matrix[row][column] > target){
                row--;
            }
            else{
                count += row +1;
                column++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        KthSmallestElementInASortedMatrix kSortedMatrix = new KthSmallestElementInASortedMatrix();
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;
        // Output: 13
        //Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
        System.out.println(k+"th Smallest Number is "+kSortedMatrix.kthSmallest(matrix,k));
        System.out.println(k+"th Smallest Number is "+kSortedMatrix.kthSmallestV2(matrix,k));
        System.out.println(k+"th Smallest Number is "+kSortedMatrix.kthSmallestV3(matrix,k));
    }
}
