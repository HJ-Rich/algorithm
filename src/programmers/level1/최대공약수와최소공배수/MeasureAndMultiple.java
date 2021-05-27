package programmers.level1.최대공약수와최소공배수;

import java.util.ArrayList;
import java.util.List;

// 최대공약수와 최소공배수
// https://programmers.co.kr/learn/courses/30/lessons/12940
public class MeasureAndMultiple {

    public static void main(String[] args) {
        System.out.println(solution(3, 12));
        System.out.println(solution(2, 5));
    }

    private static int[] solution(int n, int m) {
        int[] result = new int[2];
        
        result[0] = getGreatestCommonDivisor(getAliqots(n), getAliqots(m));
        result[1] = getLeastCommonMultiple(n, m, n, m);

        return result;
    }

    /**
     * 두 정수를 받아, 최소공배수를 반환합니다.
     * @param n 첫번쨰 정수입니다.
     * @param m 두번째 정수입니다.
     * @param nMultiple 첫번쨰 정수입니다.
     * @param mMultiple 두번째 정수입니다.
     * @return 두 정수의 최소공배수를 정수로 반환합니다.
     */
    private static int getLeastCommonMultiple(int n, int m, int nMultiple, int mMultiple) {
        if(n == m) {
            return n;
        }

        if(n < m) {
            n += nMultiple;
        } else {
            m += mMultiple;
        }

        return getLeastCommonMultiple(n, m, nMultiple, mMultiple);
    }

    /**
     * 내림차순 정렬된 두 정수 리스트를 받아 가장 큰 공통의 수를 반환합니다.
     * @param aliqotsOfN 정수 리스트
     * @param aliqotsOfM 정수 리스트
     * @return 두 리스트에 모두 존재하는 가장 큰 정수를 반환합니다. 없을 경우 0을 반환합니다.
     */
    private static int getGreatestCommonDivisor(List<Integer> aliqotsOfN, List<Integer> aliqotsOfM) {
        int result = 0;

        for (int i : aliqotsOfN) {
            if(aliqotsOfM.contains(i)) {
                result = i;
                break;
            }
        }

        return result;
    }

    /**
     * 정수를 받아 약수의 리스트를 반환하는 메소드입니다.
     * @param target 약수 리스트를 구할 정수를 파라미터로 받습니다.
     * @return 약수가 들어있는 정수 리스트를 내림차순으로 반환합니다.
     */
    private static List<Integer> getAliqots(int target) {
        List<Integer> result = new ArrayList<>();

        for (int i = target; i >= 1; i--) {
            if(target % i == 0) {
                result.add(i);
            }
        }

        return result;
    }


}
