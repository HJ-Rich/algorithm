package programmers.진행중.체육복;

import java.util.ArrayList;
import java.util.List;

// 체육복
// https://programmers.co.kr/learn/courses/30/lessons/42862
public class GymClothes {

    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
        System.out.println(solution(5, new int[]{2, 4}, new int[]{3}));
        System.out.println(solution(3, new int[]{3}, new int[]{1}));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lostArray = new ArrayList<>();
        List<Integer> reserveArray = new ArrayList<>();

        for (int i : lost) {
            lostArray.add(i);
        }
        for (int i : reserve) {
            reserveArray.add(i);
        }

        for (int i = 0; i < lostArray.size(); i++) {
            if(reserveArray.contains(lostArray.get(i))) {
                reserveArray.remove(new Integer(i));
                lostArray.remove(i);
                i--;
            }
        }

        for (int i = 0; i < lostArray.size(); i++) {
            Integer num = lostArray.get(i);
            if(reserveArray.contains(num - 1)) {
                reserveArray.remove(num);
                lostArray.remove(num);
                i--;
            }
            else if(reserveArray.contains(num + 1)) {
                reserveArray.remove(num);
                lostArray.remove(num);
                i--;
            }
        }

        return n - lostArray.size();
    }

}
