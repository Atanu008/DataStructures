package org.atanu.java.ds.graph;

import java.util.*;

//https://leetcode.com/problems/course-schedule/
//LeetCode 207
public class CourseSchedule {

    //BFS Approach. Kahns Algorithm
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        //Build Graph
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i = 0; i < numCourses; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for(int[] prerequisite : prerequisites) {
            adjList.get(prerequisite[0]).add(prerequisite[1]);
        }

        int[] inDegree = new int[numCourses];
        for(int node = 0; node < numCourses; node++) {
            for(int neighbour : adjList.get(node)) {
                inDegree[neighbour]++;
            }
        }

        //Find all sources i.e., all vertices with 0 in-degrees
        Queue<Integer> queue = new LinkedList<>();
        for(int node = 0; node < numCourses; node++) {
            if(inDegree[node] == 0){
                queue.offer(node);
            }
        }

        int count = 0;
        while(!queue.isEmpty()) {
            int currentNode = queue.poll();
            count++;
            //iterate over the nbrs of this node and reduce their indegree by 1
            for(int neighbour : adjList.get(currentNode)){
                inDegree[neighbour]--;
                if(inDegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        //This means numCourses == count that means it has No Cycle.
        // So courses can be finished. return true
        return numCourses == count;
    }

    //DFS version
    //Check cycle in directed graph. If cycle present then , courses can not completed
    //Otherwise all courses can be completed
    public boolean canFinishV2(int numCourses, int[][] prerequisites) {

        //Build Graph
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i = 0; i < numCourses; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for(int[] prerequisite : prerequisites) {
            adjList.get(prerequisite[0]).add(prerequisite[1]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] inRecursion = new boolean[numCourses];

        for(int node = 0; node < numCourses; node++) {
            //Graph has Cycle . Its not possible to complete the course
            if(!visited[node] && hasCycle(node, adjList, visited, inRecursion)){
                return false;
            }
        }
        //No Cycle in the graph. All courses can be completed
        return true;
    }

    private boolean hasCycle(int node, Map<Integer, List<Integer>> adjList, boolean[] visited, boolean[] inRecursion) {

        visited[node] = true;
        inRecursion[node] = true;

        for(int neighbour : adjList.get(node)) {
            //Return True if the neighbour is in recursion
            if(inRecursion[neighbour]) {
                return true;
            }
            //Deep In Recursion if one has cycle
            else if(!visited[neighbour] && hasCycle(neighbour, adjList, visited, inRecursion)){
                return true;
            }
        }

        inRecursion[node] = false;
        return false;
    }
}
