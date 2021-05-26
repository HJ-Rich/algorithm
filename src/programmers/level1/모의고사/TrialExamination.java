package programmers.level1.모의고사;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// 모의고사
// https://programmers.co.kr/learn/courses/30/lessons/42840
public class TrialExamination {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 2, 3, 4, 5, 1, 2, 4, 5, 2, 1, 4, 5, 2, 3, 4}));
        System.out.println(solution(new int[] {1, 3, 2, 4, 2}));
    }

    private static int[] solution(int[] answers) {
        List<Integer> answerList = new ArrayList<>();

        List<StudentVO> students = new ArrayList<>();
        students.add(new StudentVO(5, new int[] {1, 2, 3, 4, 5}));
        students.add(new StudentVO(8, new int[] {2, 1, 2, 3, 2, 4, 2, 5}));
        students.add(new StudentVO(10, new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}));

        // 채점
        for (int answer : answers) {
            for (StudentVO student : students) {
                if(answer == student.getAnswer()) {
                    student.score += 1;
                }
            }
        }

        // 최대 점수 확인
        int maxScore = 0;
        for (StudentVO student : students) {
            if(student.score >= maxScore) {
                maxScore = student.score;
            }
        }

        // 최대 점수자 배열에 담기
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).score == maxScore) {
                answerList.add(i + 1);
            }
        }

        // 리스트를 배열로 변환
        return answerList.stream()
                         .filter(Objects::nonNull)
                         .mapToInt(Integer::intValue)
                         .toArray();
    }

    /**
     * 수험자 객체입니다. 정답 패턴과 점수 등을 필드로, 다음 정답을 반환하는 메소드를 갖고 있습니다.
     */
    public static class StudentVO {
        public int index;
        public int length;
        public int[] style;
        public int score;

        public StudentVO(int length, int[] style) {
            this.length = length;
            this.style = style;
        }

        /**
         * 자신의 패턴에 맞게 다음 정답을 반환합니다.
         * @return 1에서 5사이의 정답을 정수를 반환합니다.
         */
        public int getAnswer() {
            int result = style[index];
            if(index == length - 1) {
                index = 0;
            } else {
                index ++;
            }
            return result;
        }
    }

}
