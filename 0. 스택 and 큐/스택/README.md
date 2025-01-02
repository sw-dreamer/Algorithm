# Java 스택(Stack)과 큐(Queue) 개념 및 예제

스택(Stack)과 큐(Queue)는 컴퓨터 과학에서 많이 사용되는 **자료 구조**입니다. 이들은 데이터를 저장하고 관리하는 방법을 정의하는데, 각각의 특징을 가지고 있습니다.

## 1. 스택(Stack) 개념

스택은 **LIFO (Last In, First Out)** 방식의 자료 구조입니다. 즉, **가장 마지막에 들어온 데이터가 가장 먼저 나가는** 방식입니다. 우리가 일상에서 쓰는 **서랍**이나 **접시 더미**와 비슷하다고 할 수 있습니다. 가장 나중에 올려놓은 접시가 가장 먼저 쌓이고, 가장 마지막에 빼게 됩니다.

### 스택의 주요 연산
- `push(item)`: 스택에 데이터를 넣는다.
- `pop()`: 스택에서 데이터를 꺼낸다.
- `peek()`: 스택의 가장 위에 있는 데이터를 확인한다.
- `isEmpty()`: 스택이 비어 있는지 확인한다.

### 스택 예제

```java
import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        // 스택 객체 생성
        Stack<Integer> stack = new Stack<>();

        // push 연산: 스택에 값 넣기
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // peek 연산: 스택의 최상단 값 확인
        System.out.println("Top element: " + stack.peek());  // 30

        // pop 연산: 스택에서 값 꺼내기
        System.out.println("Popped element: " + stack.pop());  // 30
        System.out.println("Popped element: " + stack.pop());  // 20

        // 스택이 비어있는지 확인
        System.out.println("Is stack empty? " + stack.isEmpty());  // false
    }
}
```
#### 출력
```
Top element: 30
Popped element: 30
Popped element: 20
Is stack empty? false
```
