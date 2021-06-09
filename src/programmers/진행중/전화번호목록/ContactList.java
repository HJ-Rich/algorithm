package programmers.진행중.전화번호목록;

import java.util.Arrays;
import java.util.regex.Pattern;

// 전화번호 목록
// https://programmers.co.kr/learn/courses/30/lessons/42577
public class ContactList {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"}) == false);
        System.out.println(solution(new String[]{"123","456","789"}) == true);
        System.out.println(solution(new String[]{"12","123","1235","567","88"}) == false);
    }

    // 효율성 2/4 통과
    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        outer:for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book.length; j++) {
                String target = phone_book[i];
                String search = phone_book[j];
                if(search.indexOf(target) == 0) {
                    if(target.equals(search)) continue ;
                    answer = false;
                    break outer;
                }
            }
        }

        return answer;
    }

}
