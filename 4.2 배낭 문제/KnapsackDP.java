public class KnapsackDP {

    // 0/1 배낭 문제를 해결하는 동적 계획법 함수
    public static int knapsack(int[] weights, int[] values, int W) {
        int n = weights.length;
        int[][] dp = new int[n + 1][W + 1];  // dp[i][w]는 i번째 물건까지 고려했을 때, 용량 w에서의 최대 가치
        
        // 물건을 하나씩 고려하면서 배낭에 담을지 말지를 결정
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (weights[i - 1] <= w) {
                    // 물건을 담는 경우와 담지 않는 경우 중 최대 값 선택
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];  // 담지 않는 경우
                }
            }
        }
        
        // 최종적으로 구한 최대 가치는 dp[n][W]
        return dp[n][W];
    }

    public static void main(String[] args) {
        int[] weights = {2, 3, 4, 5};
        int[] values = {3, 4, 5, 6};
        int W = 5;
        
        int maxValue = knapsack(weights, values, W);
        System.out.println("최대 가치: " + maxValue);  // 출력: 7
    }
}
