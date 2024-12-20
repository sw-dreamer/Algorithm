# Java로 구현한 힙 정렬 (Heap Sort)

## 힙 정렬이란?

힙 정렬(Heap Sort)은 완전 이진 트리의 특성을 이용하는 비교 기반 정렬 알고리즘입니다. 힙은 완전 이진 트리의 일종으로, 각 노드의 값이 자식 노드들의 값보다 크거나 작은 특성을 가집니다. 힙 정렬은 주로 최대 힙(Max Heap) 또는 최소 힙(Min Heap)을 사용하여 정렬을 수행합니다.

### 알고리즘 설명

힙 정렬은 두 단계로 나눠집니다:

1. **힙화(Heapify)**: 주어진 배열을 힙 구조로 변환합니다. 이 과정은 배열을 최대 힙 또는 최소 힙 형태로 만드는 과정입니다.
2. **정렬(Sort)**: 힙에서 가장 큰 원소(또는 가장 작은 원소)를 배열의 끝으로 이동시키고, 나머지 부분에 대해 힙화를 반복하여 정렬을 완료합니다.

## 시간 복잡도

- 최선, 평균, 최악의 경우: O(n log n)
- 힙 정렬은 항상 O(n log n)의 시간 복잡도를 가집니다. 피벗 선택이나 재귀 깊이에 의한 영향을 받지 않습니다.

## 공간 복잡도

- O(1): 힙 정렬은 추가적인 공간을 거의 사용하지 않으며, 제자리 정렬(in-place sorting) 방식입니다.

## 힙 정렬 알고리즘

1. 주어진 배열을 힙 구조로 변환합니다.
2. 힙에서 가장 큰 원소를 배열의 마지막 원소와 교환합니다.
3. 배열의 크기를 1 감소시키고, 남은 배열에서 힙화 과정을 반복합니다.

## 힙 정렬의 장점과 단점

### 장점:
  - 시간 복잡도가 항상 O(n log n)으로 일정합니다.
  - 제자리 정렬(in-place sorting) 방식이므로 추가적인 메모리 공간을 거의 사용하지 않습니다.
  - 안정적인 성능을 보장합니다.

### 단점:
  - 힙 구조를 만들고 유지하는데 필요한 추가적인 연산이 필요하므로 다른 알고리즘에 비해 코드가 복잡할 수 있습니다.
  - 비교 기반 정렬이므로 다른 정렬 알고리즘(예: 퀵 정렬, 병합 정렬)보다는 실제 실행 시간이 느릴 수 있습니다.
