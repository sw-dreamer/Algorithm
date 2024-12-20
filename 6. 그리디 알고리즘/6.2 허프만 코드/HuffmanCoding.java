package algorithm;

import java.util.HashMap;
import java.util.Map;

// 허프만 트리의 노드 클래스
class Node {
    char ch;      // 문자
    int freq;     // 문자 빈도수
    Node left, right;  // 왼쪽과 오른쪽 자식 노드

    // 생성자: 문자와 빈도수를 이용해 노드 생성
    public Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
        this.left = null;
        this.right = null;
    }
}

public class HuffmanCoding {

    // 허프만 코딩 생성 함수
    public static void generateHuffmanCode(String text) {
        // 1. 빈도수 계산
        // 텍스트에서 각 문자의 빈도를 계산하여 frequencyMap에 저장
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            // 문자가 frequencyMap에 없으면 기본값 0으로 시작하여 1을 더함
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // 2. 빈도수에 따라 노드 생성
        // 빈도수와 문자를 기반으로 각 문자의 노드를 생성하고 배열에 저장
        Node[] nodes = new Node[frequencyMap.size()];
        int index = 0;
        for (Character key : frequencyMap.keySet()) {
            nodes[index++] = new Node(key, frequencyMap.get(key));
        }

        // 3. 허프만 트리 생성
        // 노드가 하나만 남을 때까지 두 개의 최소 빈도수를 가진 노드를 합쳐서 트리 만들기
        while (nodes.length > 1) {
            // 배열에서 최소 빈도수를 가진 두 노드 선택
            int minIndex1 = findMinFrequencyNodeIndex(nodes);
            Node left = nodes[minIndex1];

            // 두 번째 최소 빈도수 노드 선택
            int minIndex2 = findMinFrequencyNodeIndexAfter(nodes, minIndex1);
            Node right = nodes[minIndex2];

            // 새로운 노드를 만들어서 두 노드를 합침
            Node newNode = new Node('\0', left.freq + right.freq); // 문자 없이 빈 노드 생성
            newNode.left = left;  // 새 노드의 왼쪽 자식은 첫 번째 노드
            newNode.right = right; // 새 노드의 오른쪽 자식은 두 번째 노드

            // 새 노드를 배열에 추가하고, 선택된 두 노드는 배열에서 제거
            Node[] newNodes = new Node[nodes.length - 1];  // 새 배열은 1개 더 적은 크기
            int newIndex = 0;
            // 배열에서 두 개의 최소 노드를 제외한 나머지 노드를 새 배열에 추가
            for (int i = 0; i < nodes.length; i++) {
                if (i != minIndex1 && i != minIndex2) {
                    newNodes[newIndex++] = nodes[i];
                }
            }
            newNodes[newNodes.length - 1] = newNode;  // 마지막에 새 노드를 추가
            nodes = newNodes;  // 배열을 새 배열로 교체
        }

        // 4. 허프만 코드 생성
        // 트리의 루트 노드에서부터 허프만 코드를 생성하여 출력
        Node root = nodes[0];  // 배열에 남은 노드가 허프만 트리의 루트
        printHuffmanCodes(root, "");  // 루트에서부터 코드 생성 시작
    }

    // 배열에서 최소 빈도수 노드를 찾는 함수
    private static int findMinFrequencyNodeIndex(Node[] nodes) {
        int minIndex = 0;  // 첫 번째 노드를 최소값으로 가정
        // 배열을 순회하면서 최소 빈도수를 가진 노드의 인덱스를 찾음
        for (int i = 1; i < nodes.length; i++) {
            if (nodes[i].freq < nodes[minIndex].freq) {
                minIndex = i;
            }
        }
        return minIndex;  // 최소 빈도수 노드의 인덱스를 반환
    }

    // 배열에서 특정 인덱스를 제외하고 최소 빈도수 노드를 찾는 함수
    private static int findMinFrequencyNodeIndexAfter(Node[] nodes, int excludeIndex) {
        int minIndex = (excludeIndex == 0) ? 1 : 0;  // 첫 번째 인덱스를 제외하고 시작
        // 제외된 인덱스를 제외한 나머지 노드들 중에서 최소 빈도수 노드의 인덱스를 찾음
        for (int i = 0; i < nodes.length; i++) {
            if (i != excludeIndex && nodes[i].freq < nodes[minIndex].freq) {
                minIndex = i;
            }
        }
        return minIndex;  // 최소 빈도수 노드의 인덱스를 반환
    }

    // 허프만 코드 출력 함수
    private static void printHuffmanCodes(Node root, String code) {
        if (root == null) return;  // 루트가 null이면 종료

        // 리프 노드에서 코드 출력 (리프 노드는 문자를 가지고 있음)
        if (root.left == null && root.right == null) {
            System.out.println(root.ch + ": " + code);  // 문자와 그에 대한 허프만 코드 출력
        }

        // 왼쪽 자식으로 내려가면 "0"을 추가, 오른쪽 자식으로 내려가면 "1"을 추가
        printHuffmanCodes(root.left, code + "0");  // 왼쪽 자식
        printHuffmanCodes(root.right, code + "1");  // 오른쪽 자식
    }

    // 메인 함수
    public static void main(String[] args) {
        String text = "ABRACADABRA";  // 허프만 코딩을 적용할 텍스트
        generateHuffmanCode(text);  // 허프만 코딩 생성 함수 호출
    }
}
