package algorithm;

public class InsertionSort {

    // 삽입 정렬을 수행하는 메서드
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        // 두 번째 원소부터 마지막 원소까지 처리
        for (int i = 1; i < n; i++) {
            int key = arr[i];  // 현재 원소
            int j = i - 1;

            // 현재 원소보다 큰 원소들을 한 칸씩 밀기
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            // 현재 원소를 적절한 위치에 삽입
            arr[j + 1] = key;
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

        insertionSort(arr);

        System.out.println("정렬된 배열:");
        printArray(arr);
    }
}
