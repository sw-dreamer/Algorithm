# Java로 구현한 병합 정렬 (Merge Sort)

## 병합 정렬이란?

병합 정렬(Merge Sort)은 분할 정복(Divide and Conquer) 알고리즘을 기반으로 한 안정적인 정렬 알고리즘입니다. 이 알고리즘은 큰 문제를 작은 문제로 나누고, 이를 해결한 후 다시 합쳐서 전체 문제를 해결하는 방식입니다.

병합 정렬은 항상 O(n log n)의 시간 복잡도를 가지며, 매우 큰 데이터셋에 대해서도 안정적인 성능을 보입니다.

### 알고리즘 설명

1. 주어진 배열을 절반으로 분할합니다.
2. 각 부분 배열에 대해 병합 정렬을 재귀적으로 수행합니다.
3. 배열을 병합할 때, 두 배열을 하나의 정렬된 배열로 합칩니다.
4. 이 과정을 반복하여 모든 부분 배열이 정렬되면, 전체 배열이 정렬됩니다.

## 시간 복잡도

- 최선, 평균, 최악의 경우: O(n log n)
- 병합 정렬은 항상 O(n log n)의 시간 복잡도를 보장하므로 매우 효율적입니다.

## 공간 복잡도

- O(n): 병합 정렬은 두 부분 배열을 병합할 때 추가적인 배열 공간을 필요로 합니다.

## 병합 정렬 알고리즘

1. 주어진 배열을 반으로 나누어 두 부분 배열로 분할합니다.
2. 각 부분 배열에 대해 병합 정렬을 재귀적으로 수행합니다.
3. 두 정렬된 배열을 합쳐서 하나의 정렬된 배열로 만듭니다.

## 병합 정렬의 장점과 단점
### 장점:
  - 항상 O(n log n)의 시간 복잡도를 보장하며, 매우 큰 데이터셋에서 안정적인 성능을 발휘합니다.
  - 안정적인 정렬(stable sort) 알고리즘입니다. 즉, 동일한 값의 원소들의 순서가 유지됩니다.
  - 병합 정렬은 외부 정렬을 구현할 때 유용하게 사용될 수 있습니다.
### 단점:
  - 추가적인 배열 공간이 필요하여 공간 복잡도가 O(n)입니다. 이로 인해 메모리 사용이 많습니다.
  - 다른 정렬 알고리즘(예: 퀵 정렬)에 비해 실제 실행 속도가 느릴 수 있습니다.
