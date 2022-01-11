package org.atanu.java.ds.graph;

//https://leetcode.com/problems/find-the-town-judge/
//LeetCode 997
public class FindTheTownJudge {

    public int findJudge(int n, int[][] trust) {

        int[] inDegree = new int[n+1];
        int[] outDegree = new int[n+1];

        for(int i = 0; i < trust.length; i++){

            outDegree[trust[i][0]]++;
            inDegree[trust[i][1]]++;

        }

        for(int i = 1 ; i <= n; i++){
            if(inDegree[i] == n-1 && outDegree[i] == 0){
                return i;
            }
        }

        return -1;
    }

    //Maintaining One Array
    public int findJudgeV2(int n, int[][] trust) {

        int[] trusted = new int[n+1];

        for(int i = 0; i < trust.length; i++){

            trusted[trust[i][0]]--;
            trusted[trust[i][1]]++;

        }

        for(int i = 1 ; i <= n; i++){
            if(trusted[i] == n-1){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FindTheTownJudge findTheTownJudge = new FindTheTownJudge();
        int n = 3;
        int[][] trust = {{1,3},{2,3}};
        System.out.println("Judge is "+ findTheTownJudge.findJudge(n,trust));
    }
}
