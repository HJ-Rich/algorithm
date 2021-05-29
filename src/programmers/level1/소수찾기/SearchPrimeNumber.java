package programmers.level1.소수찾기;

// 소수 찾기
// https://programmers.co.kr/learn/courses/30/lessons/12921

public class SearchPrimeNumber {

    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(5));
        System.out.println(solution(1000000));
    }

    public static int solution(int n) {
        int result = 1;

        for (int i = 3; i <= n; i += 2) {
            if(isPrimeNumber(i)) result++;
        }

        return result;
    }

    public static boolean isPrimeNumber(int target) {
        boolean result = true;

        for (int i = 3; i <= Math.sqrt(target); i += 2) {
            if(target % i == 0) {
                result = false;
                break;
            }
        }

        return result;
    }
}
