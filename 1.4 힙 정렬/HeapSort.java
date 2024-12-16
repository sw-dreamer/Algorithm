package algorithm;

public class HeapSort {

    // 힙 정렬을 수행하는 메서드
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 힙을 만든다.
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 힙에서 원소를 하나씩 빼서 정렬된 배열로 만든다.
        for (int i = n - 1; i > 0; i--) {
            // 현재 루트(최대값)와 마지막 원소를 교환
            swap(arr, 0, i);

            // 교환 후 남은 부분에 대해 힙화 진행
            heapify(arr, i, 0);
        }
    }

    // 힙화 함수
    private static void heapify(int[] arr, int n, int i) {
        int largest = i; // 가장 큰 값의 인덱스
        int left = 2 * i + 1; // 왼쪽 자식
        int right = 2 * i + 2; // 오른쪽 자식

        // 왼쪽 자식이 더 크면
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // 오른쪽 자식이 더 크면
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // 가장 큰 값이 루트가 아니라면 교환
        if (largest != i) {
            swap(arr, i, largest);

            // 교환 후, 변경된 부분에 대해 힙화 진행
            heapify(arr, n, largest);
        }
    }

    // 두 원소를 교환하는 메서드
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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

        heapSort(arr);

        System.out.println("정렬된 배열:");
        printArray(arr);
    }
}
