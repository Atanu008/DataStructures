package org.atanu.java.ds.graph;

import java.util.Arrays;
import java.util.List;

public class DFS {

	private static void dfs(Graph graph, int v, boolean[] discovered) {

		discovered[v] = true;

		System.out.print(v+ " ");

		for(int u : graph.adjList.get(v)) {

			if(!discovered[u]) {
				dfs(graph, u, discovered);
			}
		}

	}
	public static void main(String[] args) {

		// List of graph edges as per above diagram
		List<Edge> edges = Arrays.asList(
				// Notice that node 0 is unconnected node
				new Edge(1, 2), new Edge(1, 7), new Edge(1, 8),
				new Edge(2, 3), new Edge(2, 6), new Edge(3, 4),
				new Edge(3, 5), new Edge(8, 9), new Edge(8, 12),
				new Edge(9, 10), new Edge(9, 11)
				);

		// Set number of vertices in the graph (0-12)
		final int N = 13;

		// create a graph from edges
		Graph graph = new Graph(edges, N);

		// stores vertex is discovered or not
		boolean[] discovered = new boolean[N];

		//dfs(graph, 1, discovered);
		//System.out.println();

		// Do DFS traversal from all undiscovered nodes to
		// cover all unconnected components of graph
		for (int i = 0; i < N; i++) {
			if (!discovered[i]) {
				dfs(graph, i, discovered);
			}
		}

	}



}
