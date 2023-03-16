package org.atanu.java.ds.heap;


import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/k-closest-points-to-origin/
//LeetCode 973
//Video : https://www.youtube.com/watch?v=XC4EotTewro : Formula
public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1]));

        for(int[] point: points){
            pq.offer(point);
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[][] kClosest = new int[k][2];
        int i = 0;
        while(!pq.isEmpty()){
            int[] popped = pq.poll();
            kClosest[i][0] = popped[0];
            kClosest[i][1] = popped[1];
            i++;
        }

        return kClosest;
    }

    public static void main(String[] args) {
        KClosestPointsToOrigin kClosestPointsToOrigin = new KClosestPointsToOrigin();
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;

        int[][] kClosestPoints = kClosestPointsToOrigin.kClosest(points,k);
        System.out.println(Arrays.deepToString(kClosestPoints));

        points = new int[][]{{1, 3}, {-2, 2}};
        k = 1;
        //Output: [[-2,2]]
        //Explanation:
        //The distance between (1, 3) and the origin is sqrt(10).
        //The distance between (-2, 2) and the origin is sqrt(8).
        //Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
        //We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
        kClosestPoints = kClosestPointsToOrigin.kClosest(points,k);
        System.out.println(Arrays.deepToString(kClosestPoints));

    }
}
