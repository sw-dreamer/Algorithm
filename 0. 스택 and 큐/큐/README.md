# Java 큐(Queue) 개념 및 예제

큐(Queue)는 **FIFO (First In, First Out)** 방식의 자료 구조입니다. 즉, **가장 먼저 들어온 데이터가 가장 먼저 나가는** 방식입니다. 일상에서 **줄 서기**와 비슷합니다. 처음에 줄을 선 사람이 가장 먼저 처리됩니다.

## 큐(Queue) 주요 연산

- `enqueue(item)`: 큐에 데이터를 넣는다.
- `dequeue()`: 큐에서 데이터를 꺼낸다.
- `peek()`: 큐의 첫 번째 데이터를 확인한다.
- `isEmpty()`: 큐가 비어 있는지 확인한다.

## 큐 예제

```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        // 큐 객체 생성 (LinkedList를 사용하여 큐 구현)
        Queue<Integer> queue = new LinkedList<>();

        // enqueue 연산: 큐에 값 넣기
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);

        // peek 연산: 큐의 첫 번째 값 확인
        System.out.println("Front element: " + queue.peek());  // 10

        // dequeue 연산: 큐에서 값 꺼내기
        System.out.println("Dequeued element: " + queue.poll());  // 10
        System.out.println("Dequeued element: " + queue.poll());  // 20

        // 큐가 비어있는지 확인
        System.out.println("Is queue empty? " + queue.isEmpty());  // false
    }
}
```

### 출력
```
Front element: 10
Dequeued element: 10
Dequeued element: 20
Is queue empty? false
```
