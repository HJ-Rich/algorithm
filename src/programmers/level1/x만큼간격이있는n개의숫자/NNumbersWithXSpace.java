package programmers.level1.x만큼간격이있는n개의숫자;

// x만큼 간격이 있는 n개의 숫자
// https://programmers.co.kr/learn/courses/30/lessons/12954
public class NNumbersWithXSpace {

    public static void main(String[] args) {
        solution(2, 5);
        solution(4, 3);
        solution(-4, 2);
        solution(10000000, 1000);
        solution(-10000000, 1000);
    }

    public static long[] solution(int x, int n) {
        long[] result = new long[n];

        long longX = x;

        for (int i = 0; i < n; i++) {
            result[i] = longX * i + longX;
        }

        return result;
    }


}
