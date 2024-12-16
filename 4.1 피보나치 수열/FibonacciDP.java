package algorithm;

public class FibonacciDP {

	// 동적 계획법 방식으로 피보나치 수열 계산
	public static int fibonacciDP(int n) {
		int[] fib = new int[n + 1];
		fib[1] = 1;
		for (int i = 2; i <= n; i++) {
			fib[i] = fib[i - 1] + fib[i - 2];
		}
		return fib[n];
	}

	public static void main(String[] args) {
		int n = 10;
		System.out.println("피보나치 수열의 " + n + "번째 항: " + fibonacciDP(n));
	}

}
