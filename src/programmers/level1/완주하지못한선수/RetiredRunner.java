package programmers.level1.완주하지못한선수;

import java.util.Arrays;

// 완주하지 못한 선수
//https://programmers.co.kr/learn/courses/30/lessons/42576
public class RetiredRunner {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[] {"eden", "kiki"}));
        System.out.println(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[] {"josipa", "filipa", "marina", "nikola"}));
        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[] {"stanko", "ana", "mislav"}));
        System.out.println(solution(new String[]{"mislav"}, new String[] {}));
    }

    // 6.3ms
    private static String solution(String[] participant, String[] completion) {
        String result = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        try {
            for (int i = 0; i < participant.length; i++) {
                if (!participant[i].equals(completion[i])) {
                    result = participant[i];
                    break;
                }
            }
        } catch (Exception e) {
            result = participant[participant.length-1];
        }

        return result;
    }

// 13.07ms
//    private static String solution(String[] participant, String[] completion) {
//        String result = "";
//
//        outer:for (String runner : participant) {
//            boolean isFinished = false;
//
//            for (int i = 0; i < completion.length; i++) {
//                if(runner.equals(completion[i])) {
//                    isFinished = true;
//                    completion[i] += "1";
//                    break;
//                }
//            }
//
//            if(!isFinished) {
//                result = runner;
//                break outer;
//            }
//        }
//
//        return result;
//    }


}
