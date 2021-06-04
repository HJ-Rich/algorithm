package programmers.level1.체육복;

import java.util.ArrayList;
import java.util.List;

// 체육복
// https://programmers.co.kr/learn/courses/30/lessons/42862
public class GymClothes {

    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 4}, new int[]{1, 3, 5}) == 5);
        System.out.println(solution(5, new int[]{2, 4}, new int[]{3}) == 4);
        System.out.println(solution(3, new int[]{3}, new int[]{1}) == 2);
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lostArray = new ArrayList<>();
        for (int i : lost) lostArray.add(i);
        List<Integer> reserveArray = new ArrayList<>();
        for (int i : reserve) reserveArray.add(i);

        // 자기 여벌 챙기기
        for (int i = 0; i < lostArray.size(); i++) {
            Integer number = lostArray.get(i);

            if(reserveArray.contains(number)) {
                lostArray.remove(number);
                reserveArray.remove(number);
                i--;
            }
        }

        // 자기 여벌 챙기기로 아무도 잃어버린 사람이 아니게 되면 학생 수 리턴
        if(lostArray.size() == 0) return n;

        // 학생 전체를 돌면서
        for (Integer i = 1; i <= n; i++) {

            // 잃어버버린 학생이라면
            if(lostArray.contains(i)) {
                Integer preNum = i - 1;
                Integer nextNum = i + 1;

                // 앞사람에게 빌리기 시도
                if(reserveArray.contains(preNum)) {
                    lostArray.remove(i);
                    reserveArray.remove(preNum);

                // 뒷사람에게 빌리기 시도
                } else if(reserveArray.contains(nextNum)) {
                    lostArray.remove(i);
                    reserveArray.remove(nextNum);
                }
            }
        }

        return n - lostArray.size();
    }

}
