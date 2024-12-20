package algorithm;

public class MaximumSubarray {
    
    // 최대 부분 수열 합을 구하는 함수
    public static int maxSubArray(int[] nums) {
        // 첫 번째 요소를 초기값으로 설정
        int maxSum = nums[0];
        int currentSum = nums[0];
        
        // 배열을 순차적으로 처리
        for (int i = 1; i < nums.length; i++) {
            // 현재 요소를 포함한 부분 수열 합과, 현재 요소만을 포함하는 부분 수열 중 큰 값을 선택
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            
            // 최대 부분 수열 합을 갱신
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }
    
    public static void main(String[] args) {
        // 테스트 배열
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        
        // 최대 부분 수열 합 출력
        System.out.println("최대 부분 수열 합: " + maxSubArray(arr));
    }
}
