package org.atanu.java.ds.graph;

import java.util.*;

//https://leetcode.com/problems/course-schedule-ii/
//LeetCode 210
public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        if (numCourses == 0) return null;
        // Convert graph presentation from edges to indegree of adjacent list.
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] courseOrder = new int[numCourses];
        int index = 0;
        // Create the adjacency list representation of the graph
        for(int i = 0; i < numCourses; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for(int[] prerequisite : prerequisites) {

            int parentCourse = prerequisite[1];
            int childCourse = prerequisite[0];

            adjList.get(parentCourse).add(childCourse);
            inDegree[childCourse]++; // Record in-degree of each vertex
        }
        // Add all vertices with 0 in-degree to the queue
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;
        // Process until the Q becomes empty
        while(!queue.isEmpty()) {
            count++;
            int course = queue.poll();
            courseOrder[index++] = course;
            for(int neighbour : adjList.get(course)) {
                inDegree[neighbour]--; // Reduce the in-degree of each neighbor by 1
                if(inDegree[neighbour] == 0) {  // If in-degree of a neighbor becomes 0, add it to the Q
                    queue.add(neighbour);
                }
            }
        }

        // Check to see if topological sort is possible or not.
        return count == numCourses ? courseOrder : new int[0];
    }
}
