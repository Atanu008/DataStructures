package org.atanu.java.ds.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

//This is similar kind of Emplementation of KthSmallestInMSortedArrays
//We are only storing arrayIndex and elementIndex of that Array
public class MergeKSortedArrayV2 {

    public int[] mergeKSortedArray(int[][] arrays){

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) ->
                arrays[a.arrayIndex][a.elementIndex] - arrays[b.arrayIndex][b.elementIndex]
                );

        int resultLength = 0;

        for(int i = 0; i < arrays.length; i++){
            minHeap.add(new Node(i,0));
            resultLength += arrays[i].length;
        }

        int[] result = new int[resultLength];
        int i = 0;

        while(!minHeap.isEmpty()){
            Node node = minHeap.poll();
            result[i] = arrays[node.arrayIndex][node.elementIndex];
            i++;
            if(node.elementIndex < arrays[node.arrayIndex].length - 1){
                minHeap.offer(new Node(node.arrayIndex, node.elementIndex + 1));
               // node.elementIndex++;
               // minHeap.offer(node);
            }

        }

        return result;
    }

    private static class Node{

        int arrayIndex;
        int elementIndex;

        public Node(int arrayIndex, int elementIndex) {
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
        }
    }

    public static void main(String[] args) {
        int[][] array = {{1, 3, 4}, {5, 6, 11}, {2, 9, 10}};
        int [] result = new MergeKSortedArrayV2().mergeKSortedArray(array);
        System.out.println(Arrays.toString(result));
    }
}

