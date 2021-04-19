package etc;

// https://programmers.co.kr/learn/courses/30/lessons/60058
public class Bracket_Conversion {
    public static void main(String[] args) {
        StringBuilder answerBuilder = new StringBuilder("");
        new Bracket_Conversion().solution2("()))((()", answerBuilder);
        System.out.println(answerBuilder);
    }

    private String solution2(String p, StringBuilder answerBuilder) {
        if(p.equals("")) {
            return "";
        }

        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();

        // 주어진 문자열 p를 더이상 나눌 수 없는 균형잡힌 괄호 u와, 나머지 문자열 v로 나눈다.
        getDividedUV(p, u, v);

        // u가 올바른 괄호 문자열이면 그대로 붙이고, 아니면 고쳐서 붙인다.
        if(isRightBracket(u.toString())) answerBuilder.append(u);
        else answerBuilder.append(getUFixed(u));

        // 나머지 v에 대해서 재귀수행한다.
        return solution2(v.toString(), answerBuilder);
    }

    // 문자열 p를 받아서 더이상 나눌 수 없는 균형잡힌 문자열 U와 나머지 문자열 V로 나누는 메소드
    public static void getDividedUV(String p, StringBuilder u, StringBuilder v) {

        int left = 0;
        int right = 0;
        boolean isValancedU = false;

        getU:for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);

            // u가 균형잡힌 문자열로 완성되었을 경우 v에 나머지 char를 쌓는다.
            if(isValancedU) {
                v.append(p, i, p.length());
                break getU;
            }

            // u가 균형잡힌 문자열로 완성되지 않았을 경우 u에 char를 쌓는다.
            else if(!isValancedU) {
                if (c == '(') left++;
                else if (c == ')') right++;
                u.append(c);
                if(left != 0 && left == right) isValancedU = true;
            }
        }

    }

    // U를 올바른 괄호 문자열로 변환하는 메소드
    public static StringBuilder getUFixed(StringBuilder u) {
        StringBuilder uBuilder = new StringBuilder("(");
        u.deleteCharAt(0);
        u.deleteCharAt(u.length()-1);
        for (int i = 0; i < u.length(); i++) {
            if(u.charAt(i) == '(') uBuilder.append(")");
            else if(u.charAt(i) == ')') uBuilder.append("(");
        }
        uBuilder.append(")");
        return u;
    }

    // 올바른 괄호 문자열인지 판별하는 메소드
    public static boolean isRightBracket(String p) {
        boolean result = true;

        int left = 0;
        int right = 0;
        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(') left++;
            else if(p.charAt(i) == ')') right++;
            if(right > left) {
                result = false;
                break;
            }
        }

        return result;
    }




}
