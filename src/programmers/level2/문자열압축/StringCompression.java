package programmers.level2.문자열압축;

// 문자열 압축
// https://programmers.co.kr/learn/courses/30/lessons/60057
public class StringCompression {

    public static void main(String[] args) {
        System.out.println("정답은~~~ : " + solution("xababcdcdababcdcd"));
    }

    public static int solution(String s) {
        int answer = s.length();                                    // 맨 처음엔 압축하지 않은 최대 길이를 담는다.

        for (int i = 1; i <= s.length() / 2; i++) {                 // 1부터 문자열 길이의 절반까지의 단위로 잘라 압축한 결과 중 가장 짧은 결과를 구한다.
            System.out.println("i = " + i);
            String compressed = compressByLength(s, i);             // i를 기준으로 압축한 결과를 반환하는 메소드를 구성한다.
            int compressedLength = compressed.length();             // 압축 결과 문자열의 길이다.

            System.out.printf("압축 대상 : %s, 압축 단위 : %s, 압축 결과 : %s, : %s", s, i+"", compressed, compressedLength+"\n");

            if(compressedLength < answer) answer = compressedLength; // 압축 결과가 더 짧다면 answer에 대입한다.
        }

        return answer;                                              // 최종 결과를 반환한다.
    }

    private static String compressByLength(String target, int length) {
        StringBuffer result = new StringBuffer();

        int counter = 1;
        boolean isFinal = false;

        for (int i = 0; i < target.length(); i++) {
            int index = i * length;
            String now = "";
            String next = "";

            try {
                now = target.substring(index, index + length);
            }
            catch (IndexOutOfBoundsException e) {
                now = target.substring(index);
                isFinal = true;
            }

            if(!isFinal) {
                try {
                    next = target.substring(index + length, index + length + length);
                } catch (IndexOutOfBoundsException e) {
                    next = target.substring(index + length);
                    isFinal = true;
                }
            }

            if(now.equals(next)) {
                counter++;
                continue;
            }
            else {
                String stringToAppend = (counter > 1) ? counter + now : now;
                result.append(stringToAppend);
                if(isFinal) {
                    result.append(next);
                    break;
                }
                counter = 1;
            }
        }

        return result.toString();
    }

}
