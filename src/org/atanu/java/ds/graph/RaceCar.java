package org.atanu.java.ds.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/race-car/description/
//LeetCode 818
//Video : https://www.youtube.com/watch?v=DBJPWJr5zZ4&t=78s
//Its kind of BFS where we need to find shortest distance
//Note at a time queue can have two nodes
public class RaceCar {
    public int racecar(int target) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 1, 0}); // position , speed, move
        Set<String> visited = new HashSet<>();

        while(!queue.isEmpty()){
            int[] carState = queue.poll();
            int position = carState[0];
            int speed = carState[1];
            int moves = carState[2];

            if(position == target){
                return moves;
            }
            String currentCarState = position+"+"+speed;
            if(visited.contains(currentCarState)){
                continue;
            }

            visited.add(currentCarState);
            //Accelerate , add a new node in BFS
            queue.offer(new int[]{position+speed, speed*2, moves+1});
            // Now we need to check if we need t ogo reverse
            // first accelerate is default as to go back we need to go beyond :)
            // Reverse if we are going to forward pr to backward to our target .
            if((position + speed > target && speed > 0 ) || (position + speed < target && speed < 0 )){
                speed = speed > 0 ? -1 : 1;
                queue.offer(new int[]{position, speed, moves+1});
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int target = 6;
        RaceCar raceCar = new RaceCar();
        int moves = raceCar.racecar(target);
        System.out.println("Moves "+ moves);
    }
}
