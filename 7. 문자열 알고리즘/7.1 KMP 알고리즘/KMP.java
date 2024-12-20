package algorithm;

public class KMP {

    // KMP 알고리즘을 사용하여 텍스트에서 패턴을 찾는 함수
    public static void KMPSearch(String text, String pattern) {
        // 부분 일치 테이블 생성
        int[] lps = computeLPSArray(pattern);

        int i = 0;  // 텍스트의 인덱스
        int j = 0;  // 패턴의 인덱스

        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                // 일치하면 두 인덱스를 모두 증가시킴
                j++;
                i++;
            }

            if (j == pattern.length()) {
                // 패턴을 찾았으면 인덱스 출력
                System.out.println("패턴이 텍스트의 " + (i - j) + " 위치에서 발견됨");
                j = lps[j - 1];  // 부분 일치 테이블을 사용해 패턴의 인덱스를 이동
            }
            else if (i < text.length() && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    // 불일치가 발생하면, 부분 일치 테이블을 사용해 패턴 인덱스를 이동
                    j = lps[j - 1];
                } else {
                    // 패턴의 첫 문자와 텍스트의 현재 문자가 일치하지 않으면 텍스트 인덱스를 증가
                    i++;
                }
            }
        }
    }

    // 부분 일치 테이블을 생성하는 함수 (LPS 배열)
    private static int[] computeLPSArray(String pattern) {
        int length = 0;  // 이전 일치의 길이
        int[] lps = new int[pattern.length()];

        lps[0] = 0;  // 첫 번째 문자는 항상 0

        int i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];  // 일치하는 접미사 접두사 길이를 참고하여 이동
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";

        KMPSearch(text, pattern);  // 텍스트에서 패턴을 검색
    }
}
