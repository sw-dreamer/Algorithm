// 분할 가능한 배낭 문제 (Fractional Knapsack 문제 - 그리디 알고리즘 사용)
// 분할 가능한 배낭 문제에서는 각 물건을 나누어 담을 수 있습니다.
// 이 문제는 그리디 알고리즘을 사용하여 해결할 수 있습니다.
// 물건의 가치/무게 비율을 기준으로 내림차순으로 정렬하고, 가장 가치를 많이 제공하는 물건부터 배낭에 담습니다.

// 설명:
// Item 클래스는 물건의 가치와 무게를 저장합니다.
// fractionalKnapsack 함수는 그리디 알고리즘을 사용하여 물건을 가치/무게 비율에 따라 내림차순으로 정렬한 뒤, 배낭에 물건을 담습니다.
// 물건을 담을 때 배낭이 가득 차면 멈추고, 일부만 담을 수 있는 물건은 그 비율에 맞게 가치를 계산하여 담습니다.

import java.util.*;

public class FractionalKnapsack {

    // 물건을 가치/무게 비율로 내림차순 정렬하는 클래스
    static class Item {
        int value, weight;
        
        // 생성자
        public Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }
        
        // 가치/무게 비율로 내림차순 정렬을 위한 메서드
        public double getValuePerWeight() {
            return (double) value / weight;
        }
    }

    // 분할 가능한 배낭 문제를 해결하는 함수
    public static double fractionalKnapsack(int W, Item[] items) {
        // 가치/무게 비율로 내림차순 정렬
        Arrays.sort(items, (a, b) -> Double.compare(b.getValuePerWeight(), a.getValuePerWeight()));
        
        double totalValue = 0;  // 배낭에 담을 수 있는 최대 가치
        for (Item item : items) {
            if (W == 0) {
                break;  // 배낭이 가득 찼으면 종료
            }
            
            // 배낭에 담을 수 있는 양
            if (item.weight <= W) {
                W -= item.weight;  // 배낭에 물건을 다 담은 경우
                totalValue += item.value;  // 물건의 전체 가치를 더함
            } else {
                // 배낭에 물건을 일부만 담을 수 있는 경우
                totalValue += item.value * ((double) W / item.weight);
                W = 0;  // 배낭이 가득 찼음
            }
        }
        
        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = {
            new Item(60, 10),
            new Item(100, 20),
            new Item(120, 30)
        };
        int W = 50;
        
        double maxValue = fractionalKnapsack(W, items);
        System.out.println("최대 가치: " + maxValue);  // 출력: 240.0
    }
}
