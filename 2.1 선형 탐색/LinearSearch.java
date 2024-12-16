package algorithm;

public class LinearSearch {

    // 선형 탐색 함수
    public static int linearSearch(int[] arr, int target) {
        // 배열의 각 요소를 하나씩 순차적으로 확인
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // 찾은 경우 해당 인덱스를 반환
            }
        }
        return -1; // 찾지 못한 경우 -1을 반환
    }

    public static void main(String[] args) {
        // 배열 예시
        int[] arr = {5, 3, 8, 6, 7};
        int target = 6;

        // 선형 탐색 호출
        int result = linearSearch(arr, target);
        System.out.print("배열에 있는 값은 > ");
        for(int i=0;i<arr.length;i++) {
        	System.out.print(arr[i]+ " ");
        }
        System.out.println();
        System.out.println("찾는 값 > "+target);
        
        // 결과 출력
        if (result != -1) {
            System.out.println("찾은 값의 인덱스는 " + result + "입니다.");
        } else {
            System.out.println("찾는 값이 없습니다.");
        }
    }
}
