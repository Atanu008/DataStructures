package org.atanu.java.ds.graph;

import java.util.*;

// https://leetcode.com/problems/sliding-puzzle/description/
// Leetcode 773
// Video : https://www.youtube.com/watch?v=-7zxQzs3D2A&t=575s (just see from 8 - 11 minute max . to get intuition)

public class SlidingPuzzle {
    public int slidingPuzzle(int[][] board) {

        String target = "123450";
        String start = "";
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                start += board[i][j];
            }
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        //This is the crux of the problem
        // If 0 is is 0th cell it can go to right(cell 1) and down(cell 3)
        // 0 -> {1, 3} - can go to these directions
        // like if the 0 is in 1st cell it can go left(0th cell) , right(2nd cell), down(4th cell)
        // 1 -> {0, 2, 4}
        // We have mapped these information in Map , will be used in BFS
        Map<Integer, int[]> direction = new HashMap<>();
        direction.put(0, new int[]{1, 3});
        direction.put(1, new int[]{0, 2, 4});
        direction.put(2, new int[]{1, 5});
        direction.put(3, new int[]{0, 4});
        direction.put(4, new int[]{1, 3, 5});
        direction.put(5, new int[]{2, 4});
        int level = 0; // BFS level
        while(!queue.isEmpty()){

            int size = queue.size();

            while(size --> 0){
                String current = queue.poll();
                if(current.equals(target)){
                    return level;
                }

                int IndexOfZero = current.indexOf('0');

                for(int dir : direction.get(IndexOfZero)){

                    String movedString = swap(current, IndexOfZero, dir);

                    if(!visited.contains(movedString)){
                        queue.offer(movedString);
                        visited.add(movedString);
                    }
                }
            }

            level++; // layer ++
        }

        return -1; // Impossible to form
    }

    private String swap(String current, int a, int b){
        char[] strs = current.toCharArray();
        char temp = strs[a];
        strs[a] = strs[b];
        strs[b] = temp;
        return new String(strs);
    }

    public static void main(String[] args) {
        SlidingPuzzle slidingPuzzle = new SlidingPuzzle();
        int[][] board = {{1,2,3},{4,0,5}};
        int minStep = slidingPuzzle.slidingPuzzle(board);
        //Output: 1
        //Explanation: Swap the 0 and the 5 in one move.
        System.out.println("Minimum Step Required "+ minStep);

        board = new int[][]{{1,2,3},{5,4,0}};
        minStep = slidingPuzzle.slidingPuzzle(board);
        System.out.println("Minimum Step Required "+ minStep);
        //Output: -1
        //Explanation: No number of moves will make the board solved.

        board = new int[][]{{4,1,2},{5,0,3}};
        minStep = slidingPuzzle.slidingPuzzle(board);
        //Output: 5
        //Explanation: 5 is the smallest number of moves that solves the board.
        //An example path:
        //After move 0: [[4,1,2],[5,0,3]]
        //After move 1: [[4,1,2],[0,5,3]]
        //After move 2: [[0,1,2],[4,5,3]]
        //After move 3: [[1,0,2],[4,5,3]]
        //After move 4: [[1,2,0],[4,5,3]]
        //After move 5: [[1,2,3],[4,5,0]]
        System.out.println("Minimum Step Required "+ minStep);
    }
}
