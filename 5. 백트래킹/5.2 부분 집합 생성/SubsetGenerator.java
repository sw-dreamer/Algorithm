package algorithm;

import java.util.ArrayList;

public class SubsetGenerator {

    // 백트래킹을 사용하여 부분집합을 생성하는 메서드
    public static ArrayList<ArrayList<Integer>> generateSubsets(int[] nums) {
        // 부분집합을 저장할 ArrayList
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        
        // 백트래킹을 시작하는 함수 호출
        // 처음에는 시작 인덱스는 0, 현재 부분집합은 빈 배열, subsets는 빈 리스트
        backtrack(nums, 0, new ArrayList<Integer>(), subsets);
        
        // 모든 부분집합이 생성되었으면 결과를 반환
        return subsets;
    }

    // 백트래킹 함수: 현재까지 부분집합을 생성하며, 모든 경우를 탐색
    private static void backtrack(int[] nums, int start, ArrayList<Integer> currentSubset,
                                  ArrayList<ArrayList<Integer>> subsets) {
        
        // 현재 부분집합을 결과 리스트에 추가
        subsets.add(new ArrayList<>(currentSubset));

        // 부분집합을 생성할 때, 'start'부터 시작해서 배열의 끝까지 원소를 하나씩 탐색
        for (int i = start; i < nums.length; i++) {
            
            // 원소 nums[i]를 현재 부분집합에 추가
            currentSubset.add(nums[i]);

            // 원소를 추가한 후, 다음 원소로 넘어가면서 재귀적으로 부분집합을 계속 탐색
            // i+1을 시작 인덱스로 주어, 중복된 부분집합을 방지
            backtrack(nums, i + 1, currentSubset, subsets);

            // 원소를 제외하고 다시 탐색하기 위해 현재 부분집합에서 마지막 원소를 제거
            // 즉, 현재 원소를 포함시키지 않은 경우를 탐색
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    public static void main(String[] args) {
        // 부분집합을 구할 배열
        int[] nums = { 1, 2, 3, 4, 5 };
        
        // generateSubsets 메서드를 호출하여 부분집합을 생성
        ArrayList<ArrayList<Integer>> result = generateSubsets(nums);

        // 결과 출력: 생성된 모든 부분집합을 출력
        for (ArrayList<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}
