package algorithm;

import java.util.*;

public class FloydWarshallEx {

	// Number of vertices in the graph
	private static final int INF = 99999; // Representation of infinity

	public static void main(String[] args) {
		// Graph representation (adjacency matrix)
		int[][] graph = { { 0, 5, INF, 8 }, // Node 1
				{ INF, 0, 7, INF }, // Node 2
				{ 2, INF, 0, 4 }, // Node 3
				{ INF, INF, 3, 0 } // Node 4
		};

		// Apply Floyd-Warshall algorithm
		floydWarshall(graph);
	}

	public static void floydWarshall(int[][] graph) {
		int vertices = graph.length;
		int[][] dist = new int[vertices][vertices];

		// Initialize the solution matrix same as the input graph matrix
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				dist[i][j] = graph[i][j];
			}
		}

		// Floyd-Warshall algorithm
		for (int k = 0; k < vertices; k++) {
			for (int i = 0; i < vertices; i++) {
				for (int j = 0; j < vertices; j++) {
					if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}

		// Print the shortest distance matrix
		printSolution(dist);
	}

	public static void printSolution(int[][] dist) {
		int vertices = dist.length;
		System.out.println("Shortest distances between every pair of vertices:");
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				if (dist[i][j] == INF) {
					System.out.print("INF ");
				} else {
					System.out.print(dist[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
}
