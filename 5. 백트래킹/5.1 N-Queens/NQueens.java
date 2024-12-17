import java.util.ArrayList;
import java.util.List;

public class NQueens {

    // 주어진 크기 n에 대해 모든 퀸 배치를 찾아 반환하는 함수
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();  // 가능한 배치들을 저장할 리스트
        int[] board = new int[n];  // board[i] = j -> i번째 행에 j번째 열에 퀸을 배치
        solveNQueensHelper(n, 0, board, result);  // 백트래킹을 이용해 퀸 배치를 시작
        return result;  // 모든 가능한 배치를 반환
    }

    // 백트래킹을 사용하여 퀸을 배치하는 재귀 함수
    private static void solveNQueensHelper(int n, int row, int[] board, List<List<String>> result) {
        // 모든 행에 퀸을 배치했다면 결과 리스트에 현재 배치를 추가
        if (row == n) {
            result.add(generateBoard(board));  // board 배열을 문자열 형태로 변환하여 결과에 추가
            return;
        }

        // 현재 행(row)에서 모든 열(col)을 시도하여 퀸을 배치
        for (int col = 0; col < n; col++) {
            // 현재 (row, col) 위치에 퀸을 배치할 수 있는지 확인
            if (isSafe(row, col, board)) {
                board[row] = col;  // 퀸을 (row, col)에 배치
                solveNQueensHelper(n, row + 1, board, result);  // 다음 행으로 넘어가서 퀸 배치 시도
                board[row] = -1;  // 퀸을 배치했던 자리를 되돌림(백트래킹)
            }
        }
    }

    // 현재 (row, col) 위치에 퀸을 배치할 수 있는지 확인하는 함수
    private static boolean isSafe(int row, int col, int[] board) {
        for (int i = 0; i < row; i++) {
            // 같은 열에 이미 퀸이 배치되었는지 확인
            if (board[i] == col) {
                return false;  // 같은 열에 퀸이 있다면 배치할 수 없음
            }
            // 대각선에 퀸이 있는지 확인
            if (Math.abs(board[i] - col) == Math.abs(i - row)) {
                return false;  // 대각선에 퀸이 있다면 배치할 수 없음
            }
        }
        return true;  // 안전한 위치에 퀸을 배치할 수 있음
    }

    // board 배열을 문자열 리스트로 변환하는 함수
    private static List<String> generateBoard(int[] board) {
        List<String> boardList = new ArrayList<>();  // 결과를 저장할 리스트
        for (int i = 0; i < board.length; i++) {
            char[] row = new char[board.length];  // 각 행을 나타내는 문자 배열
            for (int j = 0; j < board.length; j++) {
                // board[i] == j이면 퀸이 해당 위치에 놓였다는 의미, 'Q'를 배치
                // 아니면 '.'을 배치하여 빈 공간을 나타냄
                row[j] = (j == board[i]) ? 'Q' : '.';  
            }
            boardList.add(new String(row));  // 배열을 문자열로 변환하여 리스트에 추가
        }
        return boardList;  // 변환된 문자열 리스트 반환
    }

    // 프로그램의 시작점
    public static void main(String[] args) {
        int n = 4;  // 예시: 4x4 체스판
        List<List<String>> solutions = solveNQueens(n);  // 가능한 모든 퀸 배치 방법을 구함
        System.out.println("총 " + solutions.size() + " 가지 배치 방법:");
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);  // 각 배치 방법을 출력
            }
            System.out.println();  // 각 배치 방법 사이에 빈 줄을 추가하여 구분
        }
    }
}
