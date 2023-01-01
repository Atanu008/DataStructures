package org.atanu.java.ds.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode.com/problems/queue-reconstruction-by-height/
//LeetCode 406

//k is only determined by people with equal or larger height, so makes sense to insert in non-increasing order of height. Because when we insert some person with height h and count k, we know that we have found its correct position relative to people with equal and larger height. And when we later insert other people with equal or smaller height, we know that it will not affect this relative position. So the answer is right after we insert all people.

//https://leetcode.com/problems/queue-reconstruction-by-height/discuss/2211641/Visual-Explanation-or-JAVA-Greedy
public class QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (a , b) ->{
            if(a[0] == b[0]){
                return a[1] - b[1];
            }

            return b[0] - a[0];
        });

        System.out.println(Arrays.deepToString(people));

        List<int[]> result = new ArrayList<>();
        for(int[] a : people){
            result.add(a[1], a);
        }

        return result.toArray(new int[people.length][]);
    }

    public static void main(String[] args) {
        QueueReconstructionByHeight queueReconstructionByHeight = new QueueReconstructionByHeight();
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};

        int[][] result = queueReconstructionByHeight.reconstructQueue(people);
        System.out.println(Arrays.deepToString(result));
    }
}
