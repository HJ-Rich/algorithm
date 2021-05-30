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
배워야할 타인의 답 1 - 김나현, 김윤옥님
// 정규식을 제대로 사용하는 모범 사례다.
// 복기하는 것만으로 큰 공부가 됐다.
class Solution {
    public String solution(String new_id) {
        String answer = "";

        // Step 1. 전체 소문자화
        String temp = new_id.toLowerCase();

        // Step 2. 영소문자, 숫자, -_. 이외 문자 제거
        // replaceAll 은 문자열 전체에 대해 탐색 및 변경을 수행.
        // [] 안에 정규식을 넣음.
        // a-z는 a부터 z까지 모든 영소문자, 0-9는 숫자를 의미, -_.는 각각의 특수문자 자체를 의미.
        // ^는 Not을 의미하므로 ^ 이후의 정규표현식에 해당하지 않을 경우 두번째 파라미터인 ""로 대체됨.
        temp = temp.replaceAll("[^-_.a-z0-9]","");

        // Step 3. .. 을 .로 교체
        // [.] 점 하나가 {2,} 2번 이상 반복이라는 의미. 따라서 ..이던 ....이던 두번째 파라미터인 .로 교체됨
        temp = temp.replaceAll("[.]{2,}",".");

        // Step 4. 맨 앞 또는 맨 뒤의 . 제거
        // []안에 ^가 있으면 Not 의 의미
        // []앞에 ^가 있으면 시작의 의미.
        // 따라서 [^.] 이면 .이 아니면 match이고, ^[.] 이면 .로 시작하면 match이다.
        // []뒤에 $가 오면 끝을 의미. [.]$는 .으로 끝나면 match.
        // | 는 또는을 의미. 종합하면 (^[.] = .으로 시작한다) (| = 또는) ([.]$ = .으로 끝난다)
        temp = temp.replaceAll("^[.]|[.]$","");

        // Step 5. 빈 문자열이면 "a"를 할당.
        if(temp.equals(""))
            temp+="a";

        // Step 6. 길이가 15를 초과하면 잘라내고 맨 앞 뒤 .을 다시 제거.
        // 이 때는 맨 앞 글자의 변화는 일어나지 않기 때문에 substring이후엔 replace("[.]$", "")만 해도 될 듯 하다.
        if(temp.length() >=16){
            temp = temp.substring(0,15);
            temp=temp.replaceAll("^[.]|[.]$","");
        }

        // Step 7. 길이가 2 이하면 3이 될 때까지 마지막 문자를 더해준다.
        if(temp.length()<=2)
            while(temp.length()<3)
                temp+=temp.charAt(temp.length()-1);

        answer=temp;
        return answer;
    }
}
 */


/*
배워야할 타인의 답 2 - "-"님
실무 경험이 늘어날수록, 알고리즘을 풀면서도 유지보수, 확장성 및 객체지향적 설계를 고려하게 되는 경험을 한다.
단순히 문제를 풀어내는 것을 넘어서서 스스로 만족할만한, 업무에도 적용 가능할법한 코드를 짜고 싶어진다.
그리고 이 코드는 정규표현식의 사용도 그렇지만 메소드 체이닝과 유지 보수 확장성, 가독성 측면에서
정말 실무에서 사용해도 충분하다고 느껴질 정도의 아름다운 코드라고 느껴진다.
실제 필터를 적용해야할 여러 방면에서 이런식으로 클래스를 나눠서 생성시점에 메소드 체이닝을 활용할 수 있는 가능성을 배웠다.

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
