# 피보나치 수열 (Fibonacci Sequence)

피보나치 수열(Fibonacci Sequence)은 각 항이 그 앞의 두 항의 합인 수열입니다. 이 수열은 다음과 같은 형태로 정의됩니다:

- F(0) = 0
- F(1) = 1
- F(n) = F(n-1) + F(n-2) for n ≥ 2

따라서 수열은 다음과 같습니다:

  ```
  0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ...
  ```

## 피보나치 수열의 특징

- **재귀적 구조**: 피보나치 수열은 재귀적으로 정의되며, 각각의 값은 이전 두 값의 합으로 표현됩니다.
- **수학적 의미**: 피보나치 수열은 자연, 예술, 컴퓨터 과학 등 다양한 분야에서 발생합니다. 예를 들어, 식물의 나선형 배열, 황금비와 관련이 있습니다.

## 알고리즘 설명

피보나치 수열을 구하는 방법은 크게 두 가지가 있습니다:

1. **재귀적 방식**:
    - F(n) = F(n-1) + F(n-2)로 구하는 방식입니다.
    - 이 방법은 단순하지만 비효율적입니다. 같은 값을 여러 번 계산하게 됩니다.

  ```
  public class Fibonacci {
  
      // 재귀적 방식으로 피보나치 수열 계산
      public static int fibonacciRecursive(int n) {
          if (n <= 1) {
              return n;
          }
          return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
      }
  
      public static void main(String[] args) {
          int n = 10;
          System.out.println("피보나치 수열의 " + n + "번째 항: " + fibonacciRecursive(n));
      }
  }
  ```

2. **동적 계획법 (DP) 방식**:
    - 계산한 값을 저장하여 중복 계산을 피하는 방식입니다. 시간 복잡도를 줄일 수 있습니다.
  ```
  public class Fibonacci {

      // 동적 계획법 방식으로 피보나치 수열 계산
      public static int fibonacciDP(int n) {
          int[] fib = new int[n + 1];
          fib[1] = 1;
          for (int i = 2; i <= n; i++) {
              fib[i] = fib[i - 1] + fib[i - 2];
          }
          return fib[n];
      }
  
      public static void main(String[] args) {
          int n = 10;
          System.out.println("피보나치 수열의 " + n + "번째 항: " + fibonacciDP(n));
      }
  }
  ```

## 시간 복잡도

- **재귀적 방식**: O(2^n) – 중복 계산이 많기 때문에 비효율적입니다.
- **동적 계획법 방식**: O(n) – 값을 저장하여 중복 계산을 방지하므로 더 효율적입니다.

## 장점
  - 재귀적 접근: 구현이 간단하고, 피보나치 수열의 본질적인 정의에 부합합니다.
  - 동적 계획법: 중복 계산을 제거하여 효율성을 극대화할 수 있습니다.
## 단점
  - 재귀적 방식: 성능이 매우 비효율적입니다. 큰 n에 대해서는 시간이 많이 걸립니다.
  - 메모리 사용: 동적 계획법은 추가적인 배열을 사용하므로 메모리 사용량이 늘어날 수 있습니다.

## 활용 예시
### 피보나치 수열은 다음과 같은 분야에서 활용됩니다:
  - 컴퓨터 과학: 알고리즘 설계에서 자주 사용됩니다. 예를 들어, 피보나치 힙(fibonacci heap)이나 분할 정복 알고리즘에서 활용됩니다.
  - 수학: 피보나치 수열은 여러 수학적 문제에서 중요한 역할을 합니다.
  - 자연: 식물의 잎이나 꽃잎 배열과 같이 자연에서도 피보나치 수열을 찾아볼 수 있습니다.
