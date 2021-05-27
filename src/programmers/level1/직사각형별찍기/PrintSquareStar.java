package programmers.level1.직사각형별찍기;

import java.util.Scanner;

// 직사각형 별찍기
// https://programmers.co.kr/learn/courses/30/lessons/12969
public class PrintSquareStar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        solution(a, b);
    }

    public static void solution(int n, int m) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
