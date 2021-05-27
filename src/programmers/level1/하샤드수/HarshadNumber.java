package programmers.level1.하샤드수;

// 하샤드 수
// https://programmers.co.kr/learn/courses/30/lessons/12947
public class HarshadNumber {

    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(12));
        System.out.println(solution(11));
        System.out.println(solution(13));
    }

    public static boolean solution(int x) {
        boolean result = false;

        if(x % getSum(x) == 0) {
            result = true;
        }

        return result;
    }

    /**
     * 정수를 파라미터로 받아 각 자릿수의 합을 구해 반환합니다.
     * @param target 각 자릿수의 합을 구할 정수입니다.
     * @return 각 자릿수의 합을 정수로 반환합니다.
     */
    public static int getSum(int target) {
        int result = 0;

        for (int i = 0; i < String.valueOf(target).length(); i++) {
            result += ((int) (target / Math.pow(10, i))) % 10;
        }

        return result;
    }

}
