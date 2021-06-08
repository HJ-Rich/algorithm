package programmers.level1.폰켓몬;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 폰켓몬
// https://programmers.co.kr/learn/courses/30/lessons/1845
public class Phoneketmon {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 1, 2, 3}) == 2);
        System.out.println(solution(new int[]{3, 3, 3, 2, 2, 4}) == 3);
        System.out.println(solution(new int[]{3, 3, 3, 2, 2, 2}) == 2);
    }

    public static int solution(int[] nums) {
        int allowedNumberToOwn = nums.length / 2;

        Set<Integer> phoneketmons = new HashSet<>();
        Arrays.stream(nums).forEach(num -> phoneketmons.add(num));

        return (phoneketmons.size() > allowedNumberToOwn) ? allowedNumberToOwn : phoneketmons.size();
    }

}
