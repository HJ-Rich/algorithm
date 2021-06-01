package programmers.level1.문자열내마음대로정렬하기;

import java.util.Arrays;
import java.util.Comparator;

// 문자열 내 마음대로 정렬하기
// https://programmers.co.kr/learn/courses/30/lessons/12915
public class SortingStringAsWish {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"sun", "bed", "car"}, 1));
        System.out.println(solution(new String[]{"abce", "abcd", "cdx"}, 2));
    }

    public static String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = 0;

                char o1Char = o1.charAt(n);
                char o2Char = o2.charAt(n);

                if(o1Char < o2Char) {
                    result = -1;
                } else if(o1Char > o2Char) {
                    result = 1;
                } else if(o1Char == o2Char) {
                    String[] targets = new String[]{o1, o2};
                    Arrays.sort(targets);
                    if(targets[0].equals(o1)) {
                        result = -1;
                    } else {
                        result = 1;
                    }
                }

                return result;
            }
        });

        return strings;
    }
}

/*
// 참고해야할 다른 사람의 답 1
// - , 김평안 , Seokhun Cho , - , - 외 43 명

// 접근 전략은 나와 비슷한데, 같을 경우 처리에서 차이가 발생한다.
// compareTo를 이용해 두 문자열을 사전순 정렬을 순서를 0, 1, -1로 반환할 수 있음을 처음 알았다.

import java.util.*;

class Solution {
  public String[] solution(String[] strings, int n) {
      Arrays.sort(strings, new Comparator<String>(){
          @Override
          public int compare(String s1, String s2){
              if(s1.charAt(n) > s2.charAt(n)) return 1;
              else if(s1.charAt(n) == s2.charAt(n)) return s1.compareTo(s2);
              else if(s1.charAt(n) < s2.charAt(n)) return -1;
              else return 0;
          }
      });
      return strings;
  }
}
 */

/*
// 참고해야할 다른 사람의 답 2
// - , 정선욱 , - , 박재오 , - 외 22 명

// 비교 대상이 되는 문자를 각 문자 맨 앞에 붙여서 정렬을 한 다음,
// 정렬된 배열을 순회하며 맨 앞 문자를 substring해서 반환하는 방식.

// 대상 문자를 맨 앞에 붙임으로써 그 문자를 기준으로 제일 먼저 비교하고,
// 같을 경우 그 뒤 문자열로 정렬되므로 다른 로직을 고려할 필요가 없는 아주 간결한 방식이다.

import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            arr.add("" + strings[i].charAt(n) + strings[i]);
        }
        Collections.sort(arr);
        answer = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i).substring(1, arr.get(i).length());
        }
        return answer;
    }
}
 */