# Java로 구현한 버블 정렬 (Bubble Sort)

## 버블 정렬이란?

버블 정렬(Bubble Sort)은 인접한 두 원소를 비교하여 순서가 잘못된 경우 교환하는 방식으로 정렬을 수행하는 간단한 비교 기반 정렬 알고리즘입니다. 이 과정을 반복하여 리스트가 정렬될 때까지 수행합니다.

버블 정렬은 작은 원소들이 "버블처럼" 위로 올라가고, 큰 원소들은 "가라앉듯" 아래로 내려가면서 정렬됩니다.

## 시간 복잡도

- 최선의 경우 (이미 정렬된 경우): O(n)
- 평균 및 최악의 경우: O(n^2)

버블 정렬은 평균과 최악의 경우 시간 복잡도가 O(n^2)로, 큰 리스트에서 비효율적입니다.

## 공간 복잡도

- O(1): 버블 정렬은 추가적인 공간을 거의 사용하지 않으며, 입력 리스트 내에서 직접 정렬을 수행하는 제자리 정렬(in-place sorting)입니다.

## 버블 정렬 알고리즘

1. 리스트의 처음부터 끝까지 순차적으로 비교를 시작합니다.
2. 각 인접한 두 원소를 비교합니다.
3. 원소들이 잘못된 순서라면 교환합니다.
4. 1~3 단계를 반복하여 정렬된 리스트를 만듭니다.

## 코드 설명

 - bubbleSort(int[] arr): 버블 정렬 알고리즘을 구현한 메서드입니다. 배열을 순차적으로 비교하며, 인접한 두 원소를 교환합니다.
 - printArray(int[] arr): 배열을 출력하는 도우미 메서드입니다.
 - main 메서드에서는 정렬할 배열을 초기화하고, 정렬 전후로 배열을 출력합니다.

## 예시
  ```
  {64, 34, 25, 12, 22, 11, 90}
  ```

## 출력
  ```
  정렬된 배열:
  11 12 22 25 34 64 90
  ```

## 버블 정렬의 장점과 단점

### 장점:

  - 구현이 간단하고 이해하기 쉽습니다.
    
  - 추가적인 메모리를 거의 사용하지 않으며, 제자리 정렬이 가능합니다.

### 단점:
  - 시간 복잡도가 O(n^2)로, 큰 데이터셋에서는 비효율적입니다.

  - 이미 정렬된 배열에 대해서도 불필요한 비교를 많이 수행합니다.

