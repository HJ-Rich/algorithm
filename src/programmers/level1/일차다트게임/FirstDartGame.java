package programmers.level1.일차다트게임;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 1차 다트 게임
// https://programmers.co.kr/learn/courses/30/lessons/17682
public class FirstDartGame {

    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T") == 37);
        System.out.println(solution("1D2S#10S") == 9);
        System.out.println(solution("1D2S0T") == 3);
        System.out.println(solution("1S*2T*3S") == 23);
        System.out.println(solution("1D#2S*3S") == 5);
        System.out.println(solution("1T2D3D#") == -4);
        System.out.println(solution("1D2S3T*") == 59);
    }

    public static int solution(String dartResult) {
        String[] results = getSplitResults(dartResult);
        int[] scores = new int[results.length];

        for (int i = 0; i < results.length; i++) {
            setScoresByResults(i, results[i], scores);
        }

        return Arrays.stream(scores).sum();
    }

    public static String[] getSplitResults(String dartResult) {
        Pattern dartResultPart = Pattern.compile("^(([0-9]|10)[SDT][*#]?)(([0-9]|10)[SDT][*#]?)(([0-9]|10)[SDT][*#]?)$");
        Matcher matcher = dartResultPart.matcher(dartResult);
        matcher.matches();

        return new String[]{matcher.group(1), matcher.group(3), matcher.group(5)};
    }

    public static void setScoresByResults(int index, String singleTryResult, int[] scores) {
        int score, previousScore = 0;
        if(index != 0) previousScore = scores[index - 1];

        Pattern singleTryPattern = Pattern.compile("^([0-9]|10)([SDT])([*#]?)$");
        Matcher matcher = singleTryPattern.matcher(singleTryResult);
        matcher.matches();

        // 점수 할당
        score = Integer.parseInt(matcher.group(1));

        // S, D, T 계산
        switch (matcher.group(2)) {
            case "D":
                score = (int) Math.pow(score, 2);
                break;
            case "T":
                score = (int) Math.pow(score, 3);
                break;
        }

        // *, # 계산
        try {
            switch (matcher.group(3)) {
                case "*":
                    score *= 2;
                    if(index != 0) {
                        previousScore *= 2;
                        scores[index - 1] = previousScore;
                    }
                    break;
                case "#":
                    score *= -1;
                    break;
            }
            scores[index] = score;
        } catch (Exception e) {

        }

    }

}
