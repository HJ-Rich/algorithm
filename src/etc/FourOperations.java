package etc;

import java.util.ArrayList;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/1843
public class FourOperations {

    public static void main(String[] args) {
        System.out.println(solution(new String[] {"1", "-", "3", "+", "5", "-", "8"}));
        System.out.println(solution(new String[] {"5", "-", "3", "+", "1", "+", "2", "-", "4"}));
    }

    public static int solution(String arr[]) {
        // 5 - (3 + 1 + 2 - 4)

        // 마이너스를 만나면, 다음 마이너스를 만날 때까지 다 연산한 다음에 지금까지의 합에서 뺀다.
        // 플러스를 만나면 합에 추가한다.

        //TODO 첫번째 마이너스와 두번째 마이너스 사이의 임시 누적값이 마이너스일 경우를 고려하지 못했다..

        // 첫번째 문자열의 값으로 리턴값을 초기화한다.
        int result = Integer.parseInt(arr[0]);

        // 부호를 담은 배열을 준비한다.
        List<String> operations = new ArrayList<>();
        for (int i = 1; i < arr.length; i += 2) {
            operations.add(arr[i]);
        }

        // 문자열을 담은 배열을 준비한다.
        List<String> numbers = new ArrayList<>();
        for (int i = 2; i < arr.length; i += 2) {
            numbers.add(arr[i]);
        }

        // 뺄셈을 만났는지 여부를 체크하는 변수
        boolean isSubstract = false;
        int temp = 0;

        // 첫 문자열을 제외했기 때문에 두 배열의 길이는 같다.
        for (int i = 0; i < operations.size(); i++) {
            // 뺄셈을 이미 만났을 경우
            if(isSubstract) {
                // 덧셈을 만나면 임시 누적 합연산한다.
                if(operations.get(i).equals("+")) {
                    temp += Integer.parseInt(numbers.get(i));
                }
                // 뺄셈을 만나면 임시 누적에서 빼고, 임시 누적값을 누적에서 빼고, isSubstract = false 해준다.
                else if(operations.get(i).equals("-")) {
                    temp -= Integer.parseInt(numbers.get(i));
                    result -= temp;
                    isSubstract = false;
                }
            }
            else {
                // 뺄셈을 아직 만나지 못했을 경우, 덧셈은 단순히 합연산하면 된다.
                if(operations.get(i).equals("+")) {
                    result += Integer.parseInt(numbers.get(i));
                }
                // 뺄셈을 처음 만났을 경우, 다음 뺄셈을 만날때까지 임시 변수에 값을 누적한 후,
                // 다음 뺄셈을 만났을 때까지의 연산 결과를 누적값에서 뺀다.
                // isSubstract = true로 선언해준다.
                else if(operations.get(i).equals("-")) {
                    temp = Integer.parseInt(numbers.get(i));
                    isSubstract = true;
                }
            }
        }

        return result;
    }



}
