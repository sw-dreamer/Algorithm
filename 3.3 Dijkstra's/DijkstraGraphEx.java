package algorithm;

import java.util.*;

public class DijkstraGraphEx{
    static class Edge {
        int target, weight;
        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    public static void dijkstra(List<List<Edge>> graph, int start) {
        int n = graph.size();
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0], distance = current[1];

            if (distance > distances[node]) continue;

            for (Edge edge : graph.get(node)) {
                int newDist = distances[node] + edge.weight;
                if (newDist < distances[edge.target]) {
                    distances[edge.target] = newDist;
                    pq.add(new int[]{edge.target, newDist});
                }
            }
        }

        // 결과 출력
        System.out.println("노드 " + start + "에서 각 노드까지의 최단 거리:");
        for (int i = 1; i < n; i++) {
            System.out.println("노드 " + i + "까지의 최소 가중치 의 합 : " + distances[i]);
        }
    }

    public static void main(String[] args) {
        int n = 5; // 노드 개수
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        // 그래프 간선 추가
        graph.get(1).add(new Edge(2, 3));
        graph.get(1).add(new Edge(3, 6));
        graph.get(1).add(new Edge(4, 7));
        graph.get(2).add(new Edge(3, 1));
        graph.get(3).add(new Edge(4, 1));

        dijkstra(graph, 1); // 1번 노드에서 시작
    }
}
