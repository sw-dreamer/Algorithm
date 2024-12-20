package algorithm;

public class RabinKarp {

	  // 라빈-카프 알고리즘을 사용하여 텍스트에서 패턴을 찾는 함수
	  public static void rabinKarpSearch(String text, String pattern) {
	      int d = 256;  // 아스키 문자 집합 크기 (대부분의 경우 256)
	      int q = 101;  // 소수 q, 해시 값을 계산할 때 사용
	      int n = text.length();
	      int m = pattern.length();

	      int patternHash = 0;  // 패턴의 해시 값
	      int textHash = 0;     // 텍스트의 첫 번째 부분 문자열의 해시 값
	      int h = 1;

	      // (d^(m-1)) % q 계산 (슬라이딩 윈도우에서 해시 값을 계산할 때 사용)
	      for (int i = 0; i < m - 1; i++) {
	          h = (h * d) % q;
	      }

	      // 패턴과 텍스트의 첫 번째 부분 문자열 해시 값 계산
	      for (int i = 0; i < m; i++) {
	          patternHash = (d * patternHash + pattern.charAt(i)) % q;
	          textHash = (d * textHash + text.charAt(i)) % q;
	      }

	      // 슬라이딩 윈도우 방식으로 텍스트에서 패턴을 검색
	      for (int i = 0; i <= n - m; i++) {
	          // 현재 텍스트의 부분 문자열과 패턴의 해시 값 비교
	          if (patternHash == textHash) {
	              // 해시 값이 같으면 실제 문자열 비교
	              if (text.substring(i, i + m).equals(pattern)) {
	                  System.out.println("패턴이 텍스트의 " + i + " 위치에서 발견됨");
	              }
	          }

	          // 텍스트의 다음 부분 문자열로 해시 값 갱신
	          if (i < n - m) {
	              textHash = (d * (textHash - text.charAt(i) * h) + text.charAt(i + m)) % q;

	              // 음수인 경우를 처리
	              if (textHash < 0) {
	                  textHash = (textHash + q);
	              }
	          }
	      }
	  }

	  public static void main(String[] args) {
	      String text = "ABBBCABABABCABABBABABCABABCABAB";
	      String pattern = "ABABCABAB";

	      rabinKarpSearch(text, pattern);  // 텍스트에서 패턴을 검색
	  }
	}
