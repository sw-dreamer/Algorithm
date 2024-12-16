package algorithm;

public class MergeSort {

    // 병합 정렬을 수행하는 메서드
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return; // 배열의 크기가 1보다 작으면 정렬할 필요 없음
        }

        int mid = arr.length / 2;  // 배열을 절반으로 나눔
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        // 왼쪽 부분 배열과 오른쪽 부분 배열로 나눔
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        // 재귀적으로 병합 정렬을 수행
        mergeSort(left);
        mergeSort(right);

        // 병합
        merge(arr, left, right);
    }

    // 두 배열을 병합하는 메서드
    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // 두 배열을 비교하여 작은 원소부터 arr 배열에 채운다.
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // 왼쪽 배열에 남은 원소가 있으면 복사
        while (i < left.length) {
            arr[k++] = left[i++];
        }

        // 오른쪽 배열에 남은 원소가 있으면 복사
        while (j < right.length) {
            arr[k++] = right[j++];
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

        mergeSort(arr);

        System.out.println("정렬된 배열:");
        printArray(arr);
    }
}
