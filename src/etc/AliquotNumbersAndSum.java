package etc;

// https://programmers.co.kr/learn/courses/30/lessons/77884
public class AliquotNumbersAndSum {

    public static void main(String[] args) {
        System.out.println(solution(13, 17));
        System.out.println(solution(24, 27));
    }

    // 주어진 두 수를 순회하며 약수의 갯수가 짝수면 합하고 홀수면 뺀 결과를 반환하라
    public static int solution(int left, int right) {
        int result = 0;
        for (int i = left; i <= right; i++) {
            if(isEvenAliquot(i)) {
                result += i;
            } else {
                result -= i;
            }
        }
        return result;
    }

    // 약수의 갯수가 짝수인지 판별하는 메소드
    public static boolean isEvenAliquot(int target) {
        int aliquot = 0;
        for (int i = 1; i <= target; i++) {
            if (target % i == 0) {
                aliquot++;
            }
        }
        return aliquot % 2 == 0;
    }


}
