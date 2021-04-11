package sort;

import java.util.Arrays;

/*
입출력 예
numbers	            return
[6, 10, 2]	        "6210"
[3, 30, 34, 5, 9]	"9534330"
 */
//https://programmers.co.kr/learn/courses/30/lessons/42746?language=java

/*

다 푼 이후 다른 사람의 풀이를 보고 배운 점

1. 맨 앞 숫자가 0이면 전부 0이라는 의미니까 배열 전체를 조회할 필요가 없었다. 맨 마지막에 삼항연산자로 첫글자가 0인지 판별하는 거 쩔었다..
2. String += 대신 StringBuilder의 append를 사용하도록 해보자...
3. 단순 정수형을 원하는 방식으로 정렬하려는 거라면, Comparable을 구현하는 방법도 있지만,
Coolections.sort(list (a,b) -> { ... }); 와 같은 람다식으로 바로 처리를 할 수도 있다.

 */

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
