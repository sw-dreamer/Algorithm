package algorithm;

class Activity {
    int start;
    int end;

    // Activity 클래스 생성자
    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class ActivitySelection {
    // 활동 선택 함수
    public static void activitySelection(Activity[] activities) {
        // 1. 활동을 종료 시간 기준으로 정렬하기 (종료 시간이 작은 순으로)
        for (int i = 0; i < activities.length - 1; i++) {
            for (int j = i + 1; j < activities.length; j++) {
                // 종료 시간이 i번째 활동보다 j번째 활동이 더 빠르면, 두 활동을 교환
                if (activities[i].end > activities[j].end) {
                    Activity temp = activities[i];
                    activities[i] = activities[j];
                    activities[j] = temp;
                }
            }
        }

        // 2. 선택된 활동 출력하기
        System.out.println("선택된 활동: ");
        
        // 첫 번째 활동은 항상 선택
        int lastSelected = 0;
        System.out.println("활동: (" + activities[lastSelected].start + ", " + activities[lastSelected].end + ")");
        
        // 두 번째 활동부터는 끝나는 시간이 이전 활동의 끝나는 시간보다 큰 경우 선택
        for (int i = 1; i < activities.length; i++) {
            // 이전에 선택된 활동의 종료 시간이 현재 활동의 시작 시간보다 작거나 같을 때만 선택
            if (activities[i].start >= activities[lastSelected].end) {
                System.out.println("활동: (" + activities[i].start + ", " + activities[i].end + ")");
                lastSelected = i; // 현재 활동을 선택하고, lastSelected를 갱신
            }
        }
    }

    public static void main(String[] args) {
        // 3. 활동 배열 생성 (start 시간, end 시간)
        Activity[] activities = {
            new Activity(1, 4),
            new Activity(3, 5),
            new Activity(0, 6),
            new Activity(5, 7),
            new Activity(3, 8),
            new Activity(5, 9),
            new Activity(6, 10),
            new Activity(8, 11),
            new Activity(8, 12)
        };

        // 4. 활동 선택 함수 호출
        activitySelection(activities);
    }
}
