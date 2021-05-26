package etc;

import java.util.ArrayList;
import java.util.List;

public class CreatingPrimeNumber {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 7, 6, 4}));
        System.out.println(solution(new int[]{1, 2, 8}));
    }

    /**
     * 정수 배열을 받아, 중복 없이 3개의 수를 더해서 소수가 되는 경우의 수를 반환합니다.
     * @param nums 정수 배열을 받습니다.
     * @return 3개의 중복없는 합이 소수가 되는 경우의 수를 정수로 반환합니다.
     */
    public static int solution(int[] nums) {
        int answer = 0;

        List<Integer> sumCases = getSumCases(nums);
        for (Integer i : sumCases) {
            if(isPrimeNumber(i)) {
                answer++;
            }
        }

        return answer;
    }

    /**
     * 서로 다른 3개의 수의 합의 경우의 수를 반환합니다.
     * @param nums 파라미터로 받는 정수 배열입니다.
     * @return 서로 다른 3개의 수의 합의 경우의 수를 List로 반환합니다.
     */
    private static List<Integer> getSumCases(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    result.add(sum);
                }
            }
        }

        return result;
    }

    /**
     * 주어진 정수가 소수인지 판별합니다.
     * @param target 소수인지 검증할 정수입니다.
     * @return 주어진 정수가 소수이면 true, 아니면 false를 반환합니다.
     */
    private static boolean isPrimeNumber(Integer target) {
        boolean result = false;

        int aliqot = 0;
        for (int i = 1; i <= target; i++) {
            if(target % i == 0) {
                aliqot++;
            }
        }

        if(aliqot == 2) {
            result = true;
        }

        return result;
    }

}
