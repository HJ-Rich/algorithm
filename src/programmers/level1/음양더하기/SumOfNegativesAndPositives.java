package programmers.level1.음양더하기;

// 음양 더하기
// https://programmers.co.kr/learn/courses/30/lessons/76501
public class SumOfNegativesAndPositives {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 7, 12}, new boolean[]{true, false, true}));   
        System.out.println(solution(new int[]{1, 2, 3}, new boolean[]{false, false, true}));   
    }

    private static int solution(int[] absolutes, boolean[] signs) {
        int result = 0;

        for (int i = 0; i < absolutes.length; i++) {
            if(signs[i]) {
                result += absolutes[i];
            } else {
                result -= absolutes[i];
            }
        }

        return result;
    }


}
