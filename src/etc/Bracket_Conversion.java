package etc;

// https://programmers.co.kr/learn/courses/30/lessons/60058
public class Bracket_Conversion {
    public static void main(String[] args) {
        System.out.println(solution("()))((()"));
    }

    private static String solution(String s) {
        return recursiveSolution(s);
    }

    private static String recursiveSolution(String s) {
        // 1. 입력이 빈 문자열인 경우 빈 문자열을 반환. (재귀 종료)
        if(s.isEmpty()) return s;

        // 2. 균형잡힌 괄호 문자열 u와 나머지 v로 분리한다. u는 더이상 분리 불가해야 하고 v는 빈 문자열일 수 있다.
        String u = getU(s);
        String v = s.substring(u.length());

        // 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
        if(isRightBracket(u)) {
            // 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다
            return u + recursiveSolution(v);
        }

        // 4. u가 올바른 괄호 문자열이 아니라면 아래 과정을 수행한다.
        else {
            // 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙인다.
            return new StringBuffer("(")
            // 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
            .append(recursiveSolution(v))
            // 4-3. ')'를 다시 붙입니다.
            .append(")")
            // 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
            .append(postProcessForU(u))
            // 4-5. 생성된 문자열을 반환합니다.
            .toString();
        }
    }

    // u의 첫번째, 마지막 문자를 제거하고 나머지 문자열의 괄호 방향을 뒤집어 반환하는 메소드.
    private static String postProcessForU(String u) {
        StringBuffer result = new StringBuffer();

        StringBuffer newU = new StringBuffer(u).deleteCharAt(u.length()-1).deleteCharAt(0);
        char[] newUCharArray = newU.toString().toCharArray();

        for (char c : newUCharArray) {
            if(c == '(') result.append(")");
            else if(c == ')') result.append("(");
        }

        return result.toString();
    }

    // u를 반환하는 메소드 (u는 더이상 분리할 수 없는 균형잡힌 괄호 문자열)
    private static String getU(String s) {
        StringBuffer result = new StringBuffer();

        int checker = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                checker++;
                result.append("(");
            }
            else if(s.charAt(i) == ')') {
                checker--;
                result.append(")");
            }

            if(checker == 0) break;
        }

        return result.toString();
    }

    // 올바른 괄호 문자열인지 체크하는 메소드
    private static boolean isRightBracket(String s) {
        int checker = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') checker++;
            else if(s.charAt(i) == ')') checker--;
            if(checker < 0) {
                return false;
            }
        }

        return true;
    }

}
