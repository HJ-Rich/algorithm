package programmers.진행중.삼진법뒤집기;

// 3진법 뒤집기
// https://programmers.co.kr/learn/courses/30/lessons/68935
// 8/10
public class ReverseTernary {

    public static void main(String[] args) {
        System.out.println(solution(125) == 229);
        System.out.println(solution(100000000) == 56480240);
        System.out.println(solution( 1) == 1);
        System.out.println(solution(45) == 7);
    }

    public static long solution(int n) {
        long ternary = getTernaryByDecimal(n);
        long reverseTernary = Long.parseLong(new StringBuilder(String.valueOf(ternary)).reverse().toString());
        long decimal = getDecimalByTernary(reverseTernary);
        return decimal;
    }

    /**
     * 10진수를 3진수로 변환하는 메소드입니다.
     * @param n 3진수로 변환할 10진수 정수L
     * @return 3진수 정수L을 반환합니다.
     */
    public static long getTernaryByDecimal(int n) {
        StringBuilder ternaryBuilder = new StringBuilder();

        while(true) {
            if(n <= 3) {
                ternaryBuilder.insert(0, n % 3);
                break;
            }

            ternaryBuilder.insert(0, n % 3);
            n /= 3;
        }

        return Long.parseLong(ternaryBuilder.toString());
    }

    /**
     * 3진수를 10진수로 변환하는 메소드입니다.
     * @param ternary 10진수로 변환할 3진수 정수L
     * @return 10진수 정수를 반환합니다.
     */
    public static long getDecimalByTernary(long ternary) {
        long result = 0;

        String[] ternaryNumbers = String.valueOf(ternary).split("");
        double j = 0;
        for (int i = ternaryNumbers.length - 1; i >= 0; i--) {
            long num1 = Long.parseLong(ternaryNumbers[i]);
            long num2 = (long) Math.pow(3, j);
            result += num1 * num2;
            j++;
        }

        return result;
    }

}
