package etc;

// https://programmers.co.kr/learn/courses/30/lessons/60058
public class Bracket_Conversion {
    public static void main(String[] args) {
        StringBuilder answerBuilder = new StringBuilder();
        new Bracket_Conversion().solution("()))((()", answerBuilder);
        System.out.println(answerBuilder);
    }

    private void solution(String p, StringBuilder answerBuilder) {
        // 균형잡힌 괄호 문자열이 주어진다.
        // 즉, 문자열은 괄호로만 구성되며, 열기와 닫기의 갯수가 맞다는 뜻이다.
        // 이를 열고 닫는 짝까지 맞춰내어 올바른 괄호 문자열로 만들어 반환하는 것이 문제다.

        // 균형잡힌 괄호 문자열 -> 올바른 괄호 문자열 변환 알고리즘은 문제에 제시되었다.
        // 이를 코드로 작성해 내는 것이 문제다.

        /*
        1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
        2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
        3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
          3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
        4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
          4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
          4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
          4-3. ')'를 다시 붙입니다.
          4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
          4-5. 생성된 문자열을 반환합니다.
         */
        //----------------------------------------------------------------

        // 2번 조건에 따라 주어진 문자열을 균형잡힌 괄호 문자열 2개로 분리해야 한다.
        // 먼저 왼쪽을 최소단위로 쪼개고 쪼갠 결과가 올바른이면 붙이고 남은쪽을 다시 쪼개는식.
        // 쪼갠 결과가 올바르지 않다면 4번의 과정을 수행.

        // 재귀 브레이커
        if(p.equals("")) {
            return;
        }

        // u, v로 분리하기 위해 StringBuilder 객체 선언.
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();

        // u가 완성되었는지 여부를 판별할 boolean 객체
        boolean isUComplete = false;
        boolean isRightV = true;

        // 최소 단위로 u를 분리해내기 위한 int 객체 둘 선언.
        int left = 0;
        int right = 0;
        int vLeft = 0;
        int vRight = 0;

        // getU 반복문을 수행하고 나면 u와 v가 분리된다.
        getU:for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);

            //u가 완성되었을 경우 v에 char를 쌓는다.
            if(isUComplete) {
                if (c == '(') vLeft++;
                else if (c == ')') vRight++;
                v.append(c);
                if(right > left) isRightV = false;
            }

            // u가 완성되지 않았을 경우 u에 char를 쌓는다.
            else if(!isUComplete) {
                if (c == '(') left++;
                else if (c == ')') right++;
                u.append(c);
                if(left == right) isUComplete = true;
            }
        }

        // 올바른 괄호 문자열일 경우 그냥 붙인다
        if(isRightV) {
            answerBuilder.append(u);
        }

        // 올바른 괄호 문자열이 아닐 경우 처리
        else if(!isRightV) {

        }




        // 재귀적으로 수행한다.
        solution(v.toString(), answerBuilder);
    }




}
