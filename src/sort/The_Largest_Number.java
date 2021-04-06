package sort;

import java.util.Arrays;

//https://programmers.co.kr/learn/courses/30/lessons/42746?language=java
public class The_Largest_Number {
    public static void main(String[] args) {
        int[] numbers = new int[] {3, 30, 0, 34, 5, 9};
        String answer = "";

        // 전략
        // 1. 9부터 1까지 앞자리가 같은 숫자들을 뽑아온다.
        // 2. 10으로 나눈 나머지가 큰 순서대로 정렬하되, 나머지가 같을 경우 큰 수가 앞으로 온다.
        // 3. 0을 뒤에 모두 붙인다.
        // 내가 원하는 조건대로 정렬할 수 있게.. 코드를 짜야겠는데?

        // 런타임에러.... merge...

        RichSort[] richArray = new RichSort[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            richArray[i] = new RichSort(numbers[i]);
        }

        Arrays.sort(richArray);
        for (RichSort richSort : richArray) {
            answer += String.valueOf(richSort.number);
        }

        System.out.println(answer);
    }

    static class RichSort implements Comparable<RichSort> {

        int number;

        RichSort(int number) {
            this.number = number;
        }

        @Override
        public int compareTo(RichSort rich) {
            int result = -1;

            int firstDigitOfField = Integer.parseInt(String.valueOf(this.number).substring(0, 1));
            int firstDigitOfParameter = Integer.parseInt(String.valueOf(rich.number).substring(0, 1));

            // 맨 앞자리 숫자가 큰 순서대로 정렬한다.
            if(firstDigitOfField > firstDigitOfParameter) {
                result = -1;
            }
            else if(firstDigitOfField < firstDigitOfParameter) {
                result = 1;
            }

            // 맨 앞자리 숫자가 같을 경우,
            else if(firstDigitOfField == firstDigitOfParameter) {

                // 10으로 나눈 나머지가 큰 순서대로 정렬한다.
                if(this.number % 10 > rich.number % 10) {
                    result = -1;
                }
                else if(this.number % 10 < rich.number % 10) {
                    result = 1;
                }

                // 10으로 나눈 나머지도 같을 경우 더 작은 수를 먼저 정렬한다
                else if(this.number % 10 == rich.number % 10) {
                    if(this.number < rich.number) {
                        result = -1;
                    }if(this.number > rich.number) {
                        result = 1;
                    }else {
                        result = 0;
                    }
                }
            }

            return result;
        }
    }
}
