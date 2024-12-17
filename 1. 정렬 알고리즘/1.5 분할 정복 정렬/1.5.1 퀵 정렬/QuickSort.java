package algorithm;

public class QuickSort {

    // 퀵 정렬을 수행하는 메서드
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 피벗 인덱스를 구함
            int pivotIndex = partition(arr, low, high);
            
            // 피벗을 기준으로 두 부분 리스트에 대해 재귀적으로 퀵 정렬 수행
            quickSort(arr, low, pivotIndex - 1);  // 왼쪽 부분
            quickSort(arr, pivotIndex + 1, high); // 오른쪽 부분
        }
    }

    // 파티션 메서드 - 피벗을 기준으로 배열을 나눔
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // 피벗은 배열의 마지막 원소로 선택
        int i = low - 1;  // i는 피벗보다 작은 원소가 위치할 곳을 나타냄

        for (int j = low; j < high; j++) {
            // 현재 원소가 피벗보다 작으면
            if (arr[j] < pivot) {
                i++; // i를 증가시키고, arr[i]와 arr[j]를 교환
                swap(arr, i, j);
            }
        }

        // 피벗을 올바른 위치에 배치
        swap(arr, i + 1, high);
        return i + 1; // 피벗의 최종 위치
    }

    // 배열의 두 원소를 교환하는 메서드
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

        quickSort(arr, 0, arr.length - 1);

        System.out.println("정렬된 배열:");
        printArray(arr);
    }
}
