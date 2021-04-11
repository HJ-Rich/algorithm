package sort;

import java.util.Arrays;

/*
입출력 예
numbers	            return
[6, 10, 2]	        "6210"
[3, 30, 34, 5, 9]	"9534330"
 */
//https://programmers.co.kr/learn/courses/30/lessons/42746?language=java
public class The_Largest_Number {
    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};

        Rich[] riches = new Rich[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            riches[i] = new Rich(numbers[i]);
        }

        Arrays.sort(riches);

        String answer = "";
        for(Rich rich : riches) answer += rich.number;
        if(allZeroes(numbers)) answer = "0";

        System.out.println(answer);
    }

    // 전부 0으로 이뤄진 배열을 받았을 경우 예외 처리를 위한 메소드
    public static boolean allZeroes(int[] numbers) {
        boolean result = true;
        for(int i : numbers) {
            if(i != 0) {
                result = false;
                break;
            }
        }
        return result;
    }

    // 정렬을 위한 Comparable
    public static class Rich implements Comparable<Rich> {
        int number;

        Rich(int number) {
            this.number = number;
        }

        @Override
        public int compareTo(Rich o) {
            int temp1 = Integer.parseInt("" + this.number + o.number);
            int temp2 = Integer.parseInt("" + o.number + this.number);

            if(temp1 > temp2) return -1;
            else if(temp2 > temp1) return 1;
            else return 0;
        }
    }

}
