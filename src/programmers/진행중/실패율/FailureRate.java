package programmers.진행중.실패율;

import java.util.*;
import java.util.stream.Stream;

// 실패율
//
public class FailureRate {

    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3}));
        System.out.println(solution(4, new int[]{4, 4, 4, 4, 4}));

    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] faileureRates = new double[N];

        //TODO 스테이지마다 다른 분모가 적용되도록 수정해야함
        for (Integer i = 1; i <= N; i++) {
            Integer finalI = i;
            faileureRates[i - 1] = Arrays.stream(stages).filter((failedStage) -> failedStage == finalI).count() / (stages.length * 1.0);
        }

        return answer;
    }

}
