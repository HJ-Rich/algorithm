package etc;

import java.util.ArrayList;
import java.util.List;


// https://programmers.co.kr/learn/courses/30/lessons/60057
public class StringCompression {

    public static void main(String[] args) {
        String s = "abcabcabcabc3dede";
        int answer = solution(s);
        System.out.println(answer);
    }

    private static int solution(String s) {
        int result = s.length();

        // 나누어 떨어지는 길이로만 압축이 가능하다.

        // 나누어 떨어지는 몫 구하기
        List<Integer> shareList = getShareList(s);

        for (int i = 0; i < shareList.size(); i++) {
            int compressed = result;

            int length = shareList.get(i);

            // 구해온 몫을 길이로 잘라서 리스트에 담는다
            List<String> compressList = new ArrayList<>();
            for (int j = 0; j < s.length() / length; j++) {
                compressList.add(s.substring(j * length, j * length + length));
            }

            // 리스트에서 하나씩 꺼내어 압축 결과를 만들어낸다.
            StringBuilder compressResult = new StringBuilder();
            for (int j = 0; j < compressList.size(); j++) {

            }

            // 압축된 결과의 길이가 result 보다 작으면 result를 교체한다.
            if(result > compressed) {
                result = compressed;
            }
        }
        return result;
    }

    private static List<Integer> getShareList(String s) {
        List<Integer> result = new ArrayList<>();
        int target = Integer.parseInt(s);
        for (int i = 1; i < target; i++) {
            if(target % i == 0) result.add(i);
        }
        return result;
    }

}
