package org.atanu.java.ds.graph;

// Connected Component Problem . No of connected component
//https://leetcode.com/problems/number-of-provinces/
//LeetCode 547
public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        int connectedComponent = 0;
        boolean[] visited = new boolean[isConnected.length];
        for(int city = 0; city < isConnected.length; city++){
            if(!visited[city]){
                dfs(city, isConnected, visited);
                connectedComponent++;
            }
        }
        return connectedComponent;
    }

    public void dfs(int city, int[][] isConnected, boolean[] visited){

        visited[city] = true;

        for(int neighbour = 0; neighbour < isConnected.length; neighbour++){
            if(neighbour == city){
                continue;
            }
            if(isConnected[city][neighbour] == 1 && !visited[neighbour]){
                visited[neighbour] = true;
                dfs(neighbour, isConnected, visited);
            }
        }
    }

    public static void main(String[] args) {
        NumberOfProvinces numberOfProvinces = new NumberOfProvinces();
        int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
        int numberOfProvince = numberOfProvinces.findCircleNum(isConnected);
        System.out.println("Number of Province is "+ numberOfProvince);

        isConnected = new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        numberOfProvince = numberOfProvinces.findCircleNum(isConnected);
        System.out.println("Number of Province is "+ numberOfProvince);
    }
}
