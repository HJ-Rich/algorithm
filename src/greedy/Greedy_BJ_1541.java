package greedy;

import java.util.Scanner;

public class Greedy_BJ_1541 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        // 숫자 배열
        String[] numbersInStringArray = input.split("\\+|\\-");
        int[] numbers = new int[numbersInStringArray.length];
        for(int i = 0; i < numbersInStringArray.length; i++) {
            numbers[i] = Integer.parseInt(numbersInStringArray[i]);
        }

        // 부호 배열
        String[] codes = new String[numbersInStringArray.length-1];
        int j = 0;
        for(int i = 0; i < input.length(); i++) {
            String str = input.charAt(i)+"";
            if(str.equals("+") || str.equals("-")) {
                codes[j] = str;
                j++;
            }
        }

        // 첫번째 마이너스 부호의 인덱스
        int indexOfFirstMinus = 0;
        for(int i = 0; i < codes.length; i++) {
            if(codes[i].equals("-")) {
                indexOfFirstMinus = i;
                break;
            }
        }

        // 마이너스 부호 인덱스 전까지는 덧셈, 이후로는 뺄셈
        int result = numbers[0];
        for(int i = 1; i < numbers.length; i++) {
            if(i < indexOfFirstMinus + 1) {
                result += numbers[i];
            }
            else {
                result -= numbers[i];
            }
        }

        System.out.println(result);

    }
}
// 처음 마이너스 만난 이후로는 무조건 다 빼기로 전환할 수 있는거네?
// 그러면 마이너스의 위치를 찾고. 그 전까지는 다 더하고. 그 뒤로는 다 빼고?


 // 1 + 2 - 1 - (2 + 1 + 2) - (1 + 2) - 1 + 1 - 1 + 1)
// 1 + 1 + 2 - 2 - 1 - 1 + 2 - 1
// 1. - 스위치가 켜져있지 않을 때 +를 만났다면 그냥 더한다
// 2. - 스위치가 켜져있지 않을 때 -를 만났다면 마이너스 스위치를 켜고 마이너스 부호 뒤의 숫자를 temp에 더한다
// 3. - 스위치가 켜져있을 때 +를 만났다면 + 뒤의 숫자를 temp에 계속 더하다가 플러스를 만나면 플러스 뒤의 숫자만큼 temp에서 빼고 temp값을 총합에서 빼고 마이너스 스위치를 끈다
// 4. - 스위치가 켜져있을 때 -를 만났다면 - 뒤의 숫자를 temp에 더하고 진행한다