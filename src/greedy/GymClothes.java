package greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * 프로그래머스 - Level1 - 탐욕법 - 체육복
 * @author hj-rich
 * @version 1.0.0
 * @since 2021.05.17
 */
public class GymClothes {

    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
        System.out.println(solution(5, new int[]{2, 4}, new int[]{3}));
        System.out.println(solution(3, new int[]{3}, new int[]{1}));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int result = n;

        List<Integer> lostList = new ArrayList<>();
        for (int i : lost) {
            lostList.add(i);
        }

        List<Integer> reserveList = new ArrayList<>();
        for (int i : reserve) {
            reserveList.add(i);
        }

        for (int i = 0; i < reserveList.size(); i++) {
            int index = lostList.indexOf(reserveList.get(i));
            if(index > -1) {
                reserveList.remove(i);
                lostList.remove(index);
            }
        }

        for (int i = 0; i < lostList.size(); i++) {
            int index = reserveList.indexOf(lostList.get(i) - 1);
            if(index > -1) {
                lostList.remove(i);
                reserveList.remove(index);
            }
        }

        for (int i = 0; i < lostList.size(); i++) {
            int index = reserveList.indexOf(lostList.get(i) + 1);
            if(index > -1) {
                lostList.remove(i);
                reserveList.remove(index);
            }
        }

        return result - lostList.size();
    }

}
