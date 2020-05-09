package org.atanu.java.ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {

	// A List of Lists to represent an adjacency list
	List<LinkedList<Integer>> adjList = null;

	public Graph(List<Edge> edges , int N) {

		adjList = new ArrayList<>(N);

		for(int i = 0; i < N ; i++) {
			adjList.add(i, new LinkedList<Integer>());
		}

		for(int i = 0; i < edges.size() ; i++) {

			int source = edges.get(i).source;
			int dest = edges.get(i).dest;

			// Add an edge from src to dest
			adjList.get(source).add(dest);

			// Since graph is undirected, add an edge from dest to src also 
			adjList.get(dest).add(source);

		}

	}
}
