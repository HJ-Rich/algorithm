package programmers.진행중.짝지어제거하기;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

// 짝지어 제거하기
// https://programmers.co.kr/learn/courses/30/lessons/12973
// 정확성 통과, 효율성 1/8 통과
public class RemoveByPair {

    public int solution(String s) {
        String result = removePair(s);
        return result.length() == 0 ? 1 : 0;
    }

    private String removePair(String s) {
        StringBuilder sb = new StringBuilder();

        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if(i != charArray.length - 1 && charArray[i] == charArray[i + 1]) {
                i++;
                continue;
            }

            sb.append(charArray[i]);
        }

        boolean isExploded = !(s.length() == sb.length());

        return isExploded ? removePair(sb.toString()) : sb.toString();
    }

    @DisplayName("짝 지어 제거하기")
    @Timeout(1)
    @Test()
    void test() {
        Assertions.assertEquals(1, solution("baabaa"));
        Assertions.assertEquals(0, solution("cdcd"));
    }

}
