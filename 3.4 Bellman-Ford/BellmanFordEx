package algorithm;

import java.util.Arrays;

public class BellmanFordEx {

    // 벨만-포드 알고리즘 구현
    public static void bellmanFord(int V, int[][] edges, int start) {
        // 1. 거리 배열 초기화 (무한대 값으로 설정)
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        // 2. 경로 추적을 위한 배열 초기화 (각 정점에 대해 이전 정점 기록)
        int[] prev = new int[V];
        Arrays.fill(prev, -1);  // -1은 이전 정점이 없음을 의미

        // 3. V-1번의 간선 완화
        for (int i = 1; i < V; i++) {
            for (int[] edge : edges) {
                int u = edge[0];  // 출발 정점
                int v = edge[1];  // 도착 정점
                int weight = edge[2];  // 가중치

                // 출발점 u에서 도달할 수 있고, dist[u] + weight < dist[v]라면 dist[v]를 갱신
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    prev[v] = u;  // 이전 정점 갱신
                }
            }
        }

        // 4. 음수 사이클 검출
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("음수 사이클이 존재합니다.");
                return;
            }
        }

        // 5. 최단 거리 및 지나가는 노드 출력
        System.out.println("최단 거리와 지나가는 노드:");
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println(i + " : ∞ (도달 불가능)");
            } else {
                System.out.print(i + " : " + dist[i] + " | 지나가는 노드들: ");
                printPath(prev, i);  // 최단 경로 출력
                System.out.println();  // 줄 바꿈
            }
        }
    }

    // 최단 경로를 출력하는 함수 (지나가는 노드들 출력)
    public static void printPath(int[] prev, int vertex) {
        if (vertex == -1) {
            return;  // 경로가 없으면 리턴
        }
        printPath(prev, prev[vertex]);  // 재귀적으로 이전 정점 출력
        System.out.print(vertex + " ");  // 현재 정점 출력
    }

    public static void main(String[] args) {
        // 그래프 간선 리스트 정의 (u, v, weight)
        // 예: (0, 1, -1) -> 0번 정점에서 1번 정점으로 -1의 가중치 간선이 있음
        int[][] edges = {
            {0, 1, -1},
            {0, 2, 4},
            {1, 2, 3},
            {1, 3, 2},
            {1, 4, 2},
            {3, 2, 5},
            {3, 1, 1},
            {4, 3, -3}
        };

        int V = 5;  // 정점의 개수
        int start = 0;  // 출발 정점

        // 벨만-포드 알고리즘 실행
        bellmanFord(V, edges, start);
    }
}
