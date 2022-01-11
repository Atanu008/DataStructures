package org.atanu.java.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/time-needed-to-inform-all-employees/
//LeetCode 1376
public class TimeNeededToInformAllEmployees {

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int i = 0 ; i < n; i++){
            graph.put(i, new ArrayList<>());
        }

        for(int i = 0; i < n; i++){
            if(manager[i] != -1){
                graph.get(manager[i]).add(i);
            }
        }

        return dfs(graph, informTime, headID);
    }

    private int dfs(Map<Integer, ArrayList<Integer>> graph, int[] informTime, int headId){

        int ans = 0;
        for(int employee : graph.get(headId)){
            ans = Math.max(ans,  dfs(graph, informTime, employee));
        }

        return ans + informTime[headId];
    }

    public int numOfMinutesV2(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) if (manager[i] != -1) graph[manager[i]].add(i);
        return dfsV2(graph, headID, informTime);
    }
    private int dfsV2(List<Integer>[] graph, int u, int[] informTime) {
        int ans = 0;
        for (int v : graph[u])
            ans = Math.max(ans, dfsV2(graph, v, informTime));
        return ans + informTime[u];
    }
}
