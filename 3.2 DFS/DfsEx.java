package algorithm;

import java.util.*;

public class DfsEx {
	// 그래프 클래스 정의 (인접 리스트 방식)
	static class Graph {
		private Map<String, List<String>> adjacencyList;

		public Graph() {
			adjacencyList = new HashMap<>();
		}

		public void addEdge(String node, String neighbor) {
			adjacencyList.putIfAbsent(node, new ArrayList<>());
			adjacencyList.get(node).add(neighbor);
		}

		public List<String> getNeighbors(String node) {
			return adjacencyList.getOrDefault(node, new ArrayList<>());
		}
	}

	// DFS 구현 (재귀 방식)
	public static void dfs(Graph graph, String start, Set<String> visited) {
		// 방문 처리
		visited.add(start);
		System.out.print(start + " ");

		// 인접 노드 탐색
		for (String neighbor : graph.getNeighbors(start)) {
			if (!visited.contains(neighbor)) {
				dfs(graph, neighbor, visited);
			}
		}
	}

	public static void main(String[] args) {
		// 그래프 생성
		Graph graph = new Graph();
		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("B", "D");
		graph.addEdge("B", "E");
		graph.addEdge("C", "F");
		graph.addEdge("E", "F");

		// 방문한 노드를 추적할 집합
		Set<String> visited = new HashSet<>();

		// DFS 실행
		System.out.print("DFS Traversal starting from A: ");
		dfs(graph, "A", visited);
	}
}
