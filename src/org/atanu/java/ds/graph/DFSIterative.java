package org.atanu.java.ds.graph;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DFSIterative {

	public static void iterativeDFS(Graph graph, int v, boolean[] discovered) {

		// create a stack used to do iterative DFS
		Stack<Integer> stack = new Stack<>();

		// push the source node into stack
		stack.push(v);

		// run till stack is not empty
		while (!stack.empty())
		{

			v = stack.pop();

			if(discovered[v])
				continue;

			discovered[v] = true;
			System.out.print(v + " ");

			for(int u : graph.adjList.get(v)) {
				if(!discovered[u]) {
					stack.push(u);

				}
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

		iterativeDFS(graph, 1, discovered);

	}

}
