package algorithm;

import java.util.*;

public class BfsEx {
    
    // 그래프의 크기 (노드 수)
    private int V;
    // 그래프의 인접 리스트
    private LinkedList<Integer> adjList[];

    // 생성자
    public BFS(int V) {
        this.V = V;
        adjList = new LinkedList[V];
        
        // 각 노드마다 LinkedList 초기화
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // 그래프에 간선 추가
    public void addEdge(int v, int w) {
        adjList[v].add(w);
    }

    // BFS 알고리즘 구현
    public void bfs(int start) {
        // 방문 여부를 체크하는 배열
        boolean visited[] = new boolean[V];
        
        // 큐 생성
        LinkedList<Integer> queue = new LinkedList<>();
        
        // 시작 노드 큐에 넣고 방문 표시
        visited[start] = true;
        queue.add(start);
        
        // 큐가 비어있지 않으면 반복
        while (!queue.isEmpty()) {
            // 큐에서 하나의 노드를 꺼냄
            int node = queue.poll();
            System.out.print(node + " ");
            
            // 연결된 노드들을 큐에 넣음
            Iterator<Integer> iterator = adjList[node].listIterator();
            while (iterator.hasNext()) {
                int adjNode = iterator.next();
                
                if (!visited[adjNode]) {
                    visited[adjNode] = true;
                    queue.add(adjNode);
                }
            }
        }
    }

    public static void main(String[] args) {
        // 그래프 생성
        BFS graph = new BFS(6);
        
        // 간선 추가 (예: 0 - 1, 0 - 2, 1 - 3, ...)
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        
        // BFS 실행
        System.out.println("BFS 탐색 결과:");
        graph.bfs(0); // 0번 노드부터 탐색
    }
}
