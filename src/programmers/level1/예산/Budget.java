package programmers.level1.예산;

import java.util.Arrays;

// 예산
// https://programmers.co.kr/learn/courses/30/lessons/12982
public class Budget {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 2, 5, 4}, 9));
        System.out.println(solution(new int[]{2, 2, 3, 3}, 10));
    }

    private static int solution(int[] d, int budget) {
        int result = 0;

        Arrays.sort(d);
        for (int i : d) {
            if(budget - i >= 0) {
                budget -= i;
                result++;
            } else {
                break;
            }
        }

        return result;
    }

}
