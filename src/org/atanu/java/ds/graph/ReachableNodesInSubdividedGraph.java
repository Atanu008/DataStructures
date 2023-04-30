package org.atanu.java.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/reachable-nodes-in-subdivided-graph/description/
// Leetcode 882

// Since we have nodes in between, and want to calculate the reachable ones.
// The first thing that comes to mind is how many nodes we can actually reach?
// We know, edges=nodes+1
// So now if we take 0->1 with 10 nodes in between
// We can deduce that distance from 0 to 1 is 11.
//
// Using this, we can initially calculate the minimum distance to reach each node from source , assuming the nodes in between as weights => Djikstra Algorithm
//
// Once calculated minimum distance to reach each node, simply check if this distance<=maxMoves allowed
//
// Now comes the tricky part - How to check how many nodes in between can be visited?
//
// Count the number of nodes reachable on edge e from e[0] and from e[1]
// using Extra Distance left=maxMoves-Dist covered by e[1] or e[0]

public class ReachableNodesInSubdividedGraph {

    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<int[]>());
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.get(u).add(new int[]{v, w + 1}); // w+1 is because source is included
            graph.get(v).add(new int[]{u, w + 1});
        }

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{0, 0});
        // this is a count to get how many nodes acn be visited uder said condition
        int total = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visited[cur[0]])
                continue;
            // incase if the distance is less than the maxMoves,
            //we are counting this node in
            if (distance[cur[0]] <= maxMoves)
                total++;
            visited[cur[0]] = true;
            for (int[] neighbour : graph.get(cur[0])) {
                int next = neighbour[0], nextWeight = neighbour[1];
                if (!visited[next] && distance[next] > distance[cur[0]] + nextWeight) {
                    distance[next] = distance[cur[0]] + nextWeight;
                    pq.offer(new int[]{next, distance[next]});
                }
            }
        }

        //now we have minimum distances to reach each node, so check how many reachable with minMoves
        int ans = 0;
        for (int i = 0; i < n; ++i) { // add 1 for nodes that can be visited
            if (distance[i] <= maxMoves)
                ans++;
        }

         /*
  Now add for intermediate newly added nodes
  Eg. 0->1 and 10 in between

  Visitable from 0 -> maxMoves-(dist/moves already covered by 0 (from source))
  Visitable from 1 -> maxMoves-(dist/moves already covered by 1 (from source))

  To calculate Extra nodes I can visit we follow above
  */
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            int between = edge[2];
            int x = Math.max(0, (maxMoves - distance[src])); // nodes visited using edge e[0]->e[1]
            int y = Math.max(0, (maxMoves - distance[dest])); // nodes visited using edge e[1]->e[0]
            ans += Math.min(between, x + y); //minimum to avoid overlapping in counting
        }
        return ans;

    }

    public static void main(String[] args) {

    }
}
