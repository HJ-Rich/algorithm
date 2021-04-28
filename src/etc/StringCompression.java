package etc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://programmers.co.kr/learn/courses/30/lessons/60057
public class StringCompression {

    public static void main(String[] args) {
        String s = "xababcdcdababcdcd";
        int answer = mySolution(s);
        System.out.println("정답은~~~" + answer);
    }

    private static int mySolution(String s) {
        int result = s.length();

        // 나누어 떨어지는 길이로만 압축이 가능하다.

        // 나누어 떨어지는 몫 구하기
        List<Integer> shareList = getShareList(s);

        for (int i = 0; i < shareList.size(); i++) {

            int length = shareList.get(i);

            // 구해온 몫을 길이로 잘라서 리스트에 담는다
            List<String> compressList = new ArrayList<>();
            for (int j = 0; j < s.length() / length; j++) {
                compressList.add(s.substring(j * length, j * length + length));
            }

            // 리스트에서 하나씩 꺼내어 압축 결과를 만들어낸다.
            StringBuilder compressResult = new StringBuilder();
            for (int j = 0; j < compressList.size(); j++) {

                int numberOfElement = 1;
                int index = j;
                try {
                    while (true) {
                        String a = compressList.get(index);
                        String b = compressList.get(index + 1);
                        if (a.equals(b)) {
                            index++;
                            numberOfElement++;
                        }
                        else {
                            break;
                        }
                    }
                }
                // 마지막 요소가 비교할 대상을 찾지 못하며 IOBE 발생
                // 그와 동시에 마지막 요소가 추가되지 못하여 마지막이 줄어든거네
                catch(Exception e) {
                }

                if(numberOfElement > 1) {
                    j = j + numberOfElement - 1;
                    compressResult.append(numberOfElement + compressList.get(j));
                }
                else {
                    compressResult.append(compressList.get(j));
                }
            }
            HashSet
            // 압축된 결과의 길이가 result 보다 작으면 result를 교체한다.
            if(result > compressResult.length()) {
                result = compressResult.length();
            }

            System.out.println(length + "로 나눴을 때! : " + compressResult.length() + " : " + compressResult);
        }
        return result;
    }

    private static List<Integer> getShareList(String s) {
        List<Integer> result = new ArrayList<>();
        int target = s.length();
        for (int i = 1; i < target; i++) {
            if(target % i == 0) result.add(i);
        }
        return result;
    }

}
