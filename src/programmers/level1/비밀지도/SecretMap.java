package programmers.level1.비밀지도;

// 비밀지도
// https://programmers.co.kr/learn/courses/30/lessons/17681
public class SecretMap {

    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28}));
        System.out.println(solution(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10}));
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < arr1.length; i++) {
            String a1 = getBinaryStringWithLength(arr1[i], n);
            String a2 = getBinaryStringWithLength(arr2[i], n);

            answer[i] = getOverlapedResult(a1, a2);
        }

        return answer;
    }

    /**
     * 10진수 정수와 길이를 받아서 길이에 맞춘 2진수 문자열을 반환합니다.
     * @param target 변환 대상 10진수
     * @param length 길이
     * @return 주어진 길이에 맞춘 2진수 문자열
     */
    public static String getBinaryStringWithLength(int target, int length) {
        String result = Integer.toBinaryString(target);

        while(result.length() < length) {
            result = "0" + result;
        }

        return result;
    }

    /**
     * 이진수 문자열 두 개를 받아서, 한 줄의 지도의 결과를 반환하는 메소드입니다.
     * @param a1 이진수 문자열1
     * @param a2 이진수 문자열2
     * @return "#"과 " "로 구성된 지도 합성 결과를 반환합니다.
     */
    public static String getOverlapedResult(String a1, String a2) {
        char[] a1CharArray = a1.toCharArray();
        char[] a2CharArray = a2.toCharArray();

        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < a1CharArray.length; j++) {
            if(a1CharArray[j] == '0' && a2CharArray[j] == '0') {
                stringBuilder.append(" ");
            } else {
                stringBuilder.append("#");
            }
        }

        return stringBuilder.toString();
    }

}
