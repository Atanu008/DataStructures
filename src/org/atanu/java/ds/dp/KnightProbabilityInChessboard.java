package org.atanu.java.ds.dp;

//https://leetcode.com/problems/knight-probability-in-chessboard/
//LeetCode 688
//Video : https://www.youtube.com/watch?v=54nJhM2AZv4
public class KnightProbabilityInChessboard {

    public double knightProbability(int n, int k, int row, int column) {

        int[][] dirs = {{2,1},{1,2},{-1,2},{-2,1},{-2,-1},{-1,-2},{1,-2},{2,-1}};
        double[][] currentDPBoard = new double[n][n];

        currentDPBoard[row][column] = 1.0;

        for(int move = 0; move < k; move++){
            double[][] nextDPBoard = new double[n][n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(currentDPBoard[i][j] != 0){
                        for(int[] dir : dirs){
                            int nextRow = i+dir[0];
                            //System.out.println(dir[0] + " "+ dir[1]);
                            int nextColumn = j+dir[1];

                            if(nextRow >= 0 && nextRow < n && nextColumn >= 0 && nextColumn < n){
                                nextDPBoard[nextRow][nextColumn] += currentDPBoard[i][j] / 8.0;
                            }
                        }
                    }
                }
            }

            currentDPBoard = nextDPBoard;
        }

        double ans = 0;
        for(double[] currentrow : currentDPBoard){
            for(double a : currentrow){
                ans +=a;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        /*Input: n = 3, k = 2, row = 0, column = 0
        Output: 0.06250
        Explanation: There are two moves (to (1,2), (2,1)) that will keep the knight on the board.
        From each of those positions, there are also two moves that will keep the knight on the board.
        The total probability the knight stays on the board is 0.0625.
         */
        KnightProbabilityInChessboard probability = new KnightProbabilityInChessboard();
        double prob = probability.knightProbability(3,2,0,0);
        System.out.println(prob);
    }
}

/*
Time Complexity: O(N^2 K)O(N
2
 K) where N, KN,K are defined as in the problem. We do O(1)O(1) work on each layer dp of N^2N
2
  elements, and there are KK layers considered.

Space Complexity: O(N^2)O(N
2
 ), the size of dp and dp2.
 */
