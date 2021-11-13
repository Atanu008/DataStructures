package org.atanu.java.ds.dp;

import java.util.HashMap;
import java.util.Map;

//https://www.techiedelight.com/probability-alive-after-taking-n-steps-island/
// Same As KnightProbabilityInChessboard LeetCode 688
public class ManAliveProbability {

    public double manAliveProbability(int n, int k, int row, int column) {

        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
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
                                nextDPBoard[nextRow][nextColumn] += currentDPBoard[i][j] / 4.0;
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

    //Top Down DP . Recurssive Approach
    public  double aliveProbability(int N, int k, int x, int y, Map<String, Double> dp){

        if(k == 0){
            return 1.0;
        }

        String key = x + "" + y+ "n";
        if(!dp.containsKey(key)){

            double ans = 0;
            //Move Up
            if(x > 0){
               ans += 0.25 * aliveProbability(N, k-1, x-1, y, dp);
            }

            //Move left
            if(y > 0){
                ans += 0.25 * aliveProbability(N,k-1, x, y-1, dp);
            }

            //Move Down
            if(x < N-1){
                ans += 0.25 * aliveProbability(N, k-1, x+1, y, dp);
            }

            //Move Right
            if(y < N-1){
                ans += 0.25 * aliveProbability(N,k-1 ,x, y+1, dp);
            }

            dp.put(key, ans);
        }

        return dp.get(key);
    }

    public static void main(String[] args) {
        ManAliveProbability probability = new ManAliveProbability();
        double prob = probability.manAliveProbability(3,3,0,0);
        System.out.println(prob);

        System.out.println("Using Recursion");
        prob = probability.aliveProbability(3,3, 0, 0, new HashMap<>());
        System.out.println(prob);
    }
}
