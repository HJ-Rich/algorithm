package etc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// https://programmers.co.kr/learn/courses/30/lessons/60057
public class StringCompression {

    public static void main(String[] args) {
        String s = "abcabcabcabc3dede";
        String answer = solution(s);
        System.out.println(answer);
    }

    private static String solution(String s) {
        String result = "";
        // 같은 길이의 숫자로 나누어 떨어지는 길이로만 압축이 가능하다.
        // 즉 소수일 경우, 1개 단위로 잘랐을 때만

        // 몫 구하기
        List<Integer> shareList = getShareList(s);

        // 구해온 몫을 길이로 하여 잘라본다.
        Map<Integer, Map<String, Integer>> compressMap = new HashMap<>();
        for (int i = 0; i < shareList.size(); i++) {
            Map<String, Integer> subMap = new HashMap<>();
            

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
