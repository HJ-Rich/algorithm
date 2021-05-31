package programmers.level1.로또최고순위와최저순위;

import java.util.HashSet;
import java.util.Set;

// 로또 최고 순위와 최저 순위
// https://programmers.co.kr/learn/courses/30/lessons/77484?language=java
public class LotteryPossibility {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19}));
        System.out.println(solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25}));
        System.out.println(solution(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35}));
    }

    public static int[] solution(int[] lottos, int[] win_nums) {
        int bestCase = 0;
        int worstCase = 0;

        Set<Integer> winSet = new HashSet<>();
        for (int i : win_nums) {
            winSet.add(i);
        }

        for (int i : lottos) {
            if(winSet.contains(i)) {
                bestCase++;
                worstCase++;
            }
            if(i == 0) {
                bestCase++;
            }
        }

        return new int[]{getPlaceByCorretNumber(bestCase), getPlaceByCorretNumber(worstCase)};
    }

    public static int getPlaceByCorretNumber(int corretNumbers) {
        switch (corretNumbers) {
            case 0:
            case 1:
                return 6;
            case 2:
                return 5;
            case 3:
                return 4;
            case 4:
                return 3;
            case 5:
                return 2;
            case 6:
                return 1;
            default:
                return 0;
        }
    }
}
