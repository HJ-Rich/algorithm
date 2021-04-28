package etc;

// https://programmers.co.kr/learn/courses/30/lessons/60058
public class Bracket_Conversion {
    public static void main(String[] args) {
        System.out.println(solution("()))((()"));
    }

    private static String solution(String s) {
        StringBuffer result = new StringBuffer();
        recursiveSolution(s, result);
        return result.toString();
    }

    private static void recursiveSolution(String s, StringBuffer result) {
        // 이미 올바른 괄호 문자열이라면 그대로 return
        boolean isRightBracket = checkIfRightBracket(s);
        if(isRightBracket) return s;

        // 입력이 빈 문자열인 경우 빈 문자열을 반환.
        if(s.isEmpty()) return s;

        String u = getU(s);
        String v = s.substring(u.length());

        if(checkIfRightBracket(u)) {
            result.append(u);
        }
        else {
            String temp = "(";



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
    private static boolean checkIfRightBracket(String s) {
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
