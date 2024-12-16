package algorithm;

public class FibonacciRecursive {

	// 재귀적 방식으로 피보나치 수열 계산
	public static int fibonacciRecursive(int n) {
		if (n <= 1) {
			return n;
		}
		return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
	}

	public static void main(String[] args) {
		int n = 10;
		System.out.println("피보나치 수열의 " + n + "번째 항: " + fibonacciRecursive(n));
	}

}
