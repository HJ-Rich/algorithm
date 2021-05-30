package programmers.level1.신규아이디추천;

// 신규 아이디 추천
public class NewIdRecommend {

    public static void main(String[] args) {
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(solution("z-+.^."));
        System.out.println(solution("=.="));
        System.out.println(solution("123_.def"));
        System.out.println(solution("abcdefghijklmn.p"));
    }

    private static String solution(String new_id) {

        // Step 1. new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        new_id = new_id.toLowerCase();

        // Step 2. new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        char[] newIdCharArray = new_id.toCharArray();
        StringBuilder resultBuilder =  new StringBuilder();
        for (char c : newIdCharArray) {
            if(isValidChar(c)) {
                resultBuilder.append(c);
            }
        }
        new_id = resultBuilder.toString();

        // Step 3. new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        new_id = removeDoubleDot(new_id);

        // Step 4. new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        new_id = removeFirstAndLastDot(new_id);

        // Step 5. 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if(new_id.isEmpty()) {
            new_id = "a";
        }

        // Step 6. 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        //     만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if(new_id.length() > 15) {
            StringBuilder stringBuilder = new StringBuilder(new_id);
            stringBuilder.replace(15, stringBuilder.length(), "");

            if(stringBuilder.charAt(14) == '.') {
                stringBuilder.deleteCharAt(14);
            }

            new_id = stringBuilder.toString();
        }

        // Step 7. 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if(new_id.length() <= 2) {
            char c = new_id.charAt(new_id.length() - 1);

            while(new_id.length() < 3) {
                new_id += c;
            }
        }

        return new_id;
    }

    private static boolean isValidChar(char c) {
        if(c == '.' || c == '_' || c == '-') {
            return true;
        }

        else if(String.valueOf(c).matches("[a-z]")) {
            return true;
        }

        else if(String.valueOf(c).matches("[0-9]")) {
            return true;
        }

        return false;
    }

    public static String removeFirstAndLastDot(String target) {
        if(target.equals(".")) return "";
        while(target.indexOf(".") == 0) {
            target = target.substring(1);
        }

        if(target.equals(".")) return "";
        while(target.lastIndexOf(".") == target.length() - 1) {
            target = target.substring(0, target.length() - 1);
        }

        return target;
    }


    public static String removeDoubleDot(String target) {
        while(target.contains("..")) {
            target = target.replace("..", ".");
        }

        return target;
    }
}

/*
배워야할 타인의 답 1
class Solution {
    public String solution(String new_id) {
        String answer = "";
        String temp = new_id.toLowerCase();

        temp = temp.replaceAll("[^-_.a-z0-9]","");
        System.out.println(temp);
        temp = temp.replaceAll("[.]{2,}",".");
        temp = temp.replaceAll("^[.]|[.]$","");
        System.out.println(temp.length());
        if(temp.equals(""))
            temp+="a";
        if(temp.length() >=16){
            temp = temp.substring(0,15);
            temp=temp.replaceAll("^[.]|[.]$","");
        }
        if(temp.length()<=2)
            while(temp.length()<3)
                temp+=temp.charAt(temp.length()-1);

        answer=temp;
        return answer;
    }
}
 */


/*
배워야할 타인의 답 2

class Solution {
    public String solution(String new_id) {

        String s = new KAKAOID(new_id)
                .replaceToLowerCase()
                .filter()
                .toSingleDot()
                .noStartEndDot()
                .noBlank()
                .noGreaterThan16()
                .noLessThan2()
                .getResult();


        return s;
    }

    private static class KAKAOID {
        private String s;

        KAKAOID(String s) {
            this.s = s;
        }

        private KAKAOID replaceToLowerCase() {
            s = s.toLowerCase();
            return this;
        }

        private KAKAOID filter() {
            s = s.replaceAll("[^a-z0-9._-]", "");
            return this;
        }

        private KAKAOID toSingleDot() {
            s = s.replaceAll("[.]{2,}", ".");
            return this;
        }

        private KAKAOID noStartEndDot() {
            s = s.replaceAll("^[.]|[.]$", "");
            return this;
        }

        private KAKAOID noBlank() {
            s = s.isEmpty() ? "a" : s;
            return this;
        }

        private KAKAOID noGreaterThan16() {
            if (s.length() >= 16) {
                s = s.substring(0, 15);
            }
            s = s.replaceAll("[.]$", "");
            return this;
        }

        private KAKAOID noLessThan2() {
            StringBuilder sBuilder = new StringBuilder(s);
            while (sBuilder.length() <= 2) {
                sBuilder.append(sBuilder.charAt(sBuilder.length() - 1));
            }
            s = sBuilder.toString();
            return this;
        }

        private String getResult() {
            return s;
        }
    }
}
 */
