package programmers.level1.이상한문자만들기;

// 이상한 문자 만들기
// https://programmers.co.kr/learn/courses/30/lessons/12930
public class MakingWiredWord {

    public static void main(String[] args) {
        System.out.println(solution("try hello world"));
        System.out.println(solution("world t t   tv"));
    }

    private static String solution(String s) {
        StringBuilder stringBuilder = new StringBuilder();

        char[] elements = s.toCharArray();
        boolean isEven = true;

        for (int i = 0; i < elements.length; i++) {
            char target = elements[i];
            if(target == ' ') {
                isEven = true;
                stringBuilder.append(" ");
                continue;
            }

            if(isEven) {
                stringBuilder.append(String.valueOf(target).toUpperCase());
                isEven = false;
            } else {
                stringBuilder.append(String.valueOf(target).toLowerCase());
                isEven = true;
            }

        }

        return stringBuilder.toString();
    }