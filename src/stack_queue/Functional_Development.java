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

        // 배열의 맨 앞에 있는 요소가 100이 되기 위한 횟수를 구한다.
        // 그 횟수만큼 더하면서 100이 아닐 때까지 구한다.
        int workday = 0;
        for(int i = 0; i < progressesList.size(); i++) {


            // 이번 요소를 무조건 100이 넘게 만들 것이기 때문에 이번에 배열에 추가할 숫자를 1로 선언하고 시작한다.
            int answer = 1;

            // 이번 요소가 100이 넘게 만드는 몫을 구한다.
            int share = (100 - progressesList.get(i)) / speedsList.get(i);
            if((100 - progressesList.get(i)) % speedsList.get(i) != 0) {
                share++;
            }
            // 같은 몫으로 각자의 작업속도를 곱한 값이 100이 넘는 연속되는 요소의 수를 구한다.
            int index = i+1;
            // 배열 범위를 벗어나지 않는 한도내에서
            while(index <= progressesList.size()-1) {
                // 다음요소에 몫*작업속도를 더한 값이 100을 넘으면
                if(progressesList.get(index) + speedsList.get(index) * share >= 100) {
                    // 정답리스트에 이번에 들어갈 요소의 수를 추가하고 인덱스를 추가한다.
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
        int[] answers = new int[answerList.size()];
        for (int i = 0; i < answers.length; i++) {
            answers[i] = answerList.get(i);
        }

    }
}
