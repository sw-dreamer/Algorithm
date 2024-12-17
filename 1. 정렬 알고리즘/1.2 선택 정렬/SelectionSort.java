package algorithm;

public class SelectionSort {

    // 선택 정렬을 수행하는 메서드
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        
        // 배열의 첫 번째 원소부터 마지막 원소까지 순차적으로 탐색
        for (int i = 0; i < n - 1; i++) {
            // 최소값을 찾을 위치
            int minIndex = i;
            
            // i 이후의 원소들 중에서 최소값을 찾음
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; // 최소값을 찾으면 그 인덱스를 저장
                }
            }
            
            // 최소값을 i번째 원소와 교환
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    // 배열을 출력하는 메서드
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // 메인 메서드로 정렬을 테스트
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("정렬되지 않은 배열:");
        printArray(arr);

        selectionSort(arr);

        System.out.println("정렬된 배열:");
        printArray(arr);
    }
}
