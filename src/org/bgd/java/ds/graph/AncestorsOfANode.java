package org.bgd.java.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/description/?envType=daily-question&envId=2024-06-29">...</a>
 *
 * You are given a positive integer n representing the number of nodes of a Directed Acyclic Graph (DAG). The nodes are numbered from 0 to n - 1 (inclusive).
 *
 * You are also given a 2D integer array edges, where edges[i] = [fromi, toi] denotes that there is a unidirectional edge from fromi to toi in the graph.
 *
 * Return a list answer, where answer[i] is the list of ancestors of the ith node, sorted in ascending order.
 *
 * A node u is an ancestor of another node v if u can reach v via a set of edges.
 *
 * Input: n = 8, edgeList = [[0,3],[0,4],[1,3],[2,4],[2,7],[3,5],[3,6],[3,7],[4,6]]
 * Output: [[],[],[],[0,1],[0,2],[0,1,3],[0,1,2,3,4],[0,1,2,3]]
 * Explanation:
 * The above diagram represents the input graph.
 * - Nodes 0, 1, and 2 do not have any ancestors.
 * - Node 3 has two ancestors 0 and 1.
 * - Node 4 has two ancestors 0 and 2.
 * - Node 5 has three ancestors 0, 1, and 3.
 * - Node 6 has five ancestors 0, 1, 2, 3, and 4.
 * - Node 7 has four ancestors 0, 1, 2, and 3.
 *
 *
 *
 */
public class AncestorsOfANode {

    Map<Integer, List<Integer>> map;
    List<List<Integer>> ancestors;

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        map = new HashMap<>(); // adjancency list
        ancestors = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
            ancestors.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            map.get(parent)
              .add(child);
        }

        for (int i = 0; i < n; i++) {
            ancestorUtil(i, i);
        }
        return ancestors;
    }

    private void ancestorUtil(int current, int ancestor) {
        for (int child : map.get(current)) {
            if (ancestors.get(child)
              .isEmpty() || ancestors.get(child)
              .getLast() != ancestor) {
                ancestors.get(child)
                  .add(ancestor);
                ancestorUtil(child, ancestor);
            }
        }
    }

    /** Topological Ordering solution
     *
     */

    private void topologicalUtil(int n, int[][] edges) {
        map = new HashMap<>(); // adjancency list
        Map<Integer, Integer> indegree = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
            ancestors.add(new ArrayList<>());
            indegree.put(i, 0);
        }

        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            map.get(parent)
              .add(child);
            indegree.put(child, indegree.get(child) + 1);
        }
        Queue<Integer> q = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : indegree.entrySet()) {
            if (entry.getValue() == 0) {
                q.offer(entry.getKey());
            }
        }

        List<Integer> topo = new ArrayList<>();

        while (!q.isEmpty()) {
            int top = q.poll();
            topo.add(top);
            for (int neighbour : map.get(top)) {
                indegree.put(neighbour, indegree.get(neighbour) - 1);
                if (indegree.get(neighbour) == 0) {
                    q.offer(neighbour);
                }
            }
        }
        for (int node : topo) {

        }
    }
}
