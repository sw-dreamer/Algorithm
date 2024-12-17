package algorithm;

public class BubbleSort {

    // 버블 정렬을 수행하는 메서드
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        
        // 배열의 모든 원소를 순차적으로 비교
        for (int i = 0; i < n - 1; i++) {
            // 마지막 i개의 원소는 이미 정렬되어 있음
            for (int j = 0; j < n - i - 1; j++) {
                // 인접한 원소를 비교
                if (arr[j] > arr[j + 1]) {
                    // 원소의 순서가 잘못되었으면 교환
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
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

        bubbleSort(arr);

        System.out.println("정렬된 배열:");
        printArray(arr);
    }
}
