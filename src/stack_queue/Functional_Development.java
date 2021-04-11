package stack_queue;

//https://programmers.co.kr/learn/courses/30/lessons/42586
/*
입출력 예
progresses	                speeds         	    return
[93, 30, 55]	            [1, 30, 5]	[2, 1]
[95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
 */

import java.util.ArrayList;
import java.util.List;

public class Functional_Development {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        List<Integer> progressesList = new ArrayList<>();
        List<Integer> speedsList = new ArrayList<>();
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            progressesList.add(progresses[i]);
            speedsList.add(speeds[i]);
        }

        // 배열의 맨 앞에 있는 요소가 배포되기 위한 작업일을 구한다.
        for(int i = 0; i < progressesList.size(); i++) {

            // 이번 요소를 무조건 100이 넘게 만들 것이기 때문에 이번에 배열에 추가할 숫자를 1로 선언하고 시작한다.
            int answer = 1;

            // 이번 요소가 100이 넘게 만드는 몫을 구한다.
            int share = (100 - progressesList.get(i)) / speedsList.get(i);
            if((100 - progressesList.get(i)) % speedsList.get(i) != 0) {
                share++;
            }

            // 다음 요소부터 탐색을 하기 위해 현재 인덱스+1 해준 새로운 인덱스 변수를 선언한다.
            int index = i+1;

            // 배열 범위를 벗어나지 않는 한도내에서
            while(index <= progressesList.size()-1) {
                // 다음요소의 진행률에 몫*작업속도를 더한 값이 100을 넘으면
                if(progressesList.get(index) + speedsList.get(index) * share >= 100) {
                    // 정답리스트에 이번에 들어갈 요소에 1을 더하고 인덱스를 더한다.
                    answer++;
                    index++;
                }

                // 100이 넘지 않으면 브레이크.
                else {
                    break;
                }

            }

            // 이번 회차에 배포가능한 연속적인 요소의 수를 정답 배열에 추가한다.
            answerList.add(answer);

            // 배포된 요소의 수-1 만큼 i에 더해서 그 다음부터 탐색토록 한다.
            i += answer -1;
        }

        // 리스트를 배열로 변환하여 반환한다.
        int[] answers = new int[answerList.size()];
        for (int i = 0; i < answers.length; i++) {
            answers[i] = answerList.get(i);
        }

        // 출력
        for(int i = 0; i < answers.length; i++) {
            if(i == 0) System.out.print("[");
            System.out.print(answers[i]);
            if(i == answers.length-1) System.out.print("]");
            else System.out.print(",");
        }

    }
}
