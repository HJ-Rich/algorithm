package greedy;

import java.util.Scanner;

// 동전0 https://www.acmicpc.net/problem/11047
// 통과
public class Greedy_BJ_11047 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] arr = new int[n];
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            int num = 0;
            num = k/arr[i];
            count += num;
            k = k - (arr[i] * num);
            if (k == 0) {
                break;
            }
        }

        System.out.println(count);
    }
}
