package etc;

// https://programmers.co.kr/learn/courses/30/lessons/60058
public class Bracket_Conversion {
    public static void main(String[] args) {
        StringBuilder answerBuilder = new StringBuilder();
        new Bracket_Conversion().solution2("()))((()", answerBuilder);
        System.out.println(answerBuilder);
    }

    private void solution2(String p, StringBuilder answerBuilder) {
        if(p.equals("")) {
            return;
        }

        // u, v로 분리하기 위해 StringBuilder 객체 선언.
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();

        // u가 완성되었는지 여부를 판별할 boolean 객체
        boolean isUComplete = false;
        boolean isRightU = true;

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
            }

            // u가 완성되지 않았을 경우 u에 char를 쌓는다.
            else if(!isUComplete) {
                if (c == '(') left++;
                else if (c == ')') right++;
                u.append(c);
                if(right > left) isRightU = false;
                if(left == right) isUComplete = true;
            }
        }

        // 올바른 괄호 문자열일 경우 그냥 붙인다
        if(isRightU) {
            answerBuilder.append(u);
        }


        /*
        4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
          4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
          4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
          4-3. ')'를 다시 붙입니다.
          4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
          4-5. 생성된 문자열을 반환합니다.
         */
        // 올바른 괄호 문자열이 아닐 경우 처리
        else if(!isRightU) {
            StringBuilder uBuilder = new StringBuilder("(");
            for (int i = 0; i < u.length(); i++) {
                if(u.charAt(i) == '(') uBuilder.append(")");
                else uBuilder.append("(");
            }
            uBuilder.append(")");
            answerBuilder.append(uBuilder);
        }

        // 재귀적으로 수행한다.
        solution2(v.toString(), answerBuilder);
    }




}
