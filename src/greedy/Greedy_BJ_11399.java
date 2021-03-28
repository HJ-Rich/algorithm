package greedy;

import java.util.Arrays;
import java.util.Scanner;

// ATM https://www.acmicpc.net/problem/11399
// 통과
public class Greedy_BJ_11399 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] timesToWithdraw = new int[scanner.nextInt()];
        for(int i = 0; i < timesToWithdraw.length; i++) {
            timesToWithdraw[i] = scanner.nextInt();
        }

        Arrays.sort(timesToWithdraw);

        int result = 0;
        int sum = 0;
        for(int i = 0; i < timesToWithdraw.length; i++) {
            sum += timesToWithdraw[i];
            result += sum;
        }

        System.out.println(result);

    }

}
