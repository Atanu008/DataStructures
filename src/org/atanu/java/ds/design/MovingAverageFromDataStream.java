package org.atanu.java.ds.design;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/moving-average-from-data-stream/
//LeetCode 346
public class MovingAverageFromDataStream {
    Queue<Integer> queue;
    int maxSize;
    int sum;
    public MovingAverageFromDataStream(int size) {
        maxSize = size;
        sum = 0;
        queue = new LinkedList<>();
    }

    public double next(int val) {

        queue.add(val);
        sum += val;
        if(queue.size() > maxSize){
            sum -= queue.poll();
        }

        return (double)sum / queue.size();
    }
}
