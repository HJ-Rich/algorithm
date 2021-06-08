package programmers.level1.내적;

// 내적
// https://programmers.co.kr/learn/courses/30/lessons/70128
public class InnerProduct {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4}, new int[]{-3, -1, 0, 2}) == 3);
        System.out.println(solution(new int[]{-1, 0, 1}, new int[]{1, 0, -1}) == -2);
    }

    public static int solution(int[] a, int[] b) {
        int answer = 0;

        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }

        return answer;
    }

}
