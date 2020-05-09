package org.atanu.java.ds.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class BFSRecursive {

	// Perform BFS recursively on graph
	public static void recursiveBFS(Graph graph, Queue<Integer> queue, boolean[] discovered) {

		//Base condition
		if(queue.isEmpty())
			return;

		// pop front node from queue and print it
		int curr = queue.poll();

		System.out.print(curr+ " ");
		// do for every edge (v -> u)
		for(int u : graph.adjList.get(curr)) {

			if(!discovered[u]) {
				// mark it discovered and push it into queue
				discovered[u] = true;
				queue.add(u);

			}
		}

		recursiveBFS(graph, queue, discovered);

	}

	public static void main(String[] args) {

		// List of graph edges as per above diagram
		List<Edge> edges = Arrays.asList(
				new Edge(1, 2), new Edge(1, 3), new Edge(1, 4),
				new Edge(2, 5), new Edge(2, 6), new Edge(5, 9),
				new Edge(5, 10), new Edge(4, 7), new Edge(4, 8),
				new Edge(7, 11), new Edge(7, 12)
				// vertex 0, 13 and 14 are single nodes
				);

		// Set number of vertices in the graph
		final int N = 15;

		// create a graph from edges
		Graph graph = new Graph(edges, N);

		// stores vertex is discovered or not
		boolean[] discovered = new boolean[N];

		Queue<Integer> queue = new ArrayDeque<>();

		for(int i = 0; i < N ; i++) {
			if (discovered[i] == false) {	
				// push source vertex into the queue
				// mark source vertex as discovered
				discovered[i] = true;
				queue.add(i);
				recursiveBFS(graph, queue, discovered);
			}
		}

	}

}


