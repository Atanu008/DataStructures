package org.atanu.java.ds.array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedArray {
    public int[] mergeKSortedArray(int[][] arrays){
        PriorityQueue<HeapNode> pq = new PriorityQueue<>();
        int resultLength = 0;

        for(int[] arr: arrays){
            pq.add(new HeapNode(arr,0));
            resultLength += arr.length;
        }

        int[] result = new int[resultLength];
        int i = 0;

        while(!pq.isEmpty()){
            HeapNode node = pq.poll();
            result[i] = node.arr[node.index];
            i++;

            if(node.hashNext()){
                pq.add(new HeapNode(node.arr, node.index +1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 3, 4}, {5, 6, 11}, {2, 9, 10}};
        int [] result = new MergeKSortedArray().mergeKSortedArray(array);
        System.out.println(Arrays.toString(result));
    }
}

class HeapNode implements Comparable<HeapNode>{

    int[] arr;
    int index;

    public HeapNode(int[] arr, int index) {
        this.arr = arr;
        this.index = index;
    }

    public boolean hashNext(){
        return this.index < this.arr.length -1;
    }

    @Override
    public int compareTo(HeapNode other) {
        return arr[index] - other.arr[other.index];
    }
}