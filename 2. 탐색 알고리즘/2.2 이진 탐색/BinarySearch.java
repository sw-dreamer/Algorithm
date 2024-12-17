package algorithm;

public class BinarySearch {

    // 이진 탐색 함수
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = (left + right) / 2;  // 중앙 인덱스 계산
            
            if (arr[mid] == target) {
                return mid;  // 찾은 경우 해당 인덱스를 반환
            } else if (arr[mid] < target) {
                left = mid + 1;  // 오른쪽 절반 탐색
            } else {
                right = mid - 1;  // 왼쪽 절반 탐색
            }
        }
        
        return -1;  // 찾지 못한 경우 -1을 반환
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};
        int target = 7;

        int result = binarySearch(arr, target);
        System.out.print("배열에 있는 값은 > ");
        for(int i=0;i<arr.length;i++) {
        	System.out.print(arr[i]+ " ");
        }
        System.out.println();
        System.out.println("찾는 값 > "+target);
        
        if (result != -1) {
            System.out.println("찾은 값의 인덱스는 " + result + "입니다.");
        } else {
            System.out.println("찾는 값이 없습니다.");
        }
    }
}
