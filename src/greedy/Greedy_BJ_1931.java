package greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 회의실 배정 https://www.acmicpc.net/problem/1931
public class Greedy_BJ_1931 {

    // 1. 시작시간을 기준으로 정렬한다.
    // 2. 사용시간이 가장 짧은 순으로 정렬한다.
    // 2. 시작시간 = 정렬시간 일 경우 카운팅한다
    // 3. 시작시간

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfMeetings = scanner.nextInt();

        List<int[]> meetings = new ArrayList<>();
        for(int i = 0; i < numberOfMeetings * 2; i++) {
            int[] meeting = new int[2];
            meeting[0] = scanner.nextInt();
            meeting[1] = scanner.nextInt();
            meetings.add(meeting);
        }

        int result = 0;

        for(int i = meetings.size()-1; i >= 0; i--) {
            int count = 1;
            int[] meeting = meetings.get(i);

            int start = meeting[0];
            int startOfTarget = 0;
            int index = -1;
            // 이번 타겟의 시작시간과 같거나 더 일찍 끝나면서 제일 늦게 시작하는 녀석 가져와.
            for(int j = i - 1; j >= 0; j--) {
                if(meetings.get(j)[1] <= start && meetings.get(j)[0] > startOfTarget) {
                    startOfTarget = meetings.get(j)[0];
                    index = j;
                }
            }

            if(index != -1) {
                meetings.get(index);
            }

        }

        System.out.println(result);

    }

}

