package etc;

import java.util.ArrayList;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/72412
public class RankSearch {

    public static void main(String[] args) {
        System.out.println(
                solution(
                        new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"},
                        new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"}
                )
        );
    }

    public static int[] solution(String[] info, String[] queryString) {

        List<InfoVO> applicants = new ArrayList<>();
        List<InfoVO> queries = new ArrayList<>();

        // Convert applicants Infos from String Array to VO Array
        for (int i = 0; i < info.length; i++) {
            String[] stringInfo = info[i].split(" ");
            applicants.add(
                    new InfoVO()
                            .language(stringInfo[0])
                            .position(stringInfo[1])
                            .career(stringInfo[2])
                            .soulFood(stringInfo[3])
                            .score(Integer.parseInt(stringInfo[4])));

            String[] conditions = queryString[i].split(" and ");
            queries.add(
                    new InfoVO()
                            .language(conditions[0])
                            .position(conditions[1])
                            .career(conditions[2])
                            .soulFood(conditions[3].split(" ")[0])
                            .score(Integer.parseInt(conditions[3].split(" ")[1]))
            );
        }

        int[] answer = new int[queryString.length];

        // Search for applicants suitable on condition
        for (int i = 0; i < queries.size(); i++) {

            int matchedApplicants = 0;

            for (int j = 0; j < applicants.size(); j++) {
                InfoVO query = queries.get(i);
                InfoVO applicant = applicants.get(j);
                if(
                        (query.getLanguage().equals("-") || query.getLanguage().equals(applicant.getLanguage()))
                                &&  (query.getPosition().equals("-") || query.getPosition().equals(applicant.getPosition()))
                                &&  (query.getCareer().equals("-") || query.getCareer().equals(applicant.getCareer()))
                                &&  (query.getSoulFood().equals("-") || query.getSoulFood().equals(applicant.getSoulFood()))
                                &&  (query.getScore() <= applicant.getScore())
                ) {
                    matchedApplicants++;
                }
            }

            answer[i] = matchedApplicants;
        }

        return answer;
    }

    public static class InfoVO {

        public String language;
        public String position;
        public String career;
        public String soulFood;
        public int score;

        public String getLanguage() {
            return language;
        }

        public String getPosition() {
            return position;
        }

        public String getCareer() {
            return career;
        }

        public String getSoulFood() {
            return soulFood;
        }

        public int getScore() {
            return score;
        }

        public InfoVO language(String language) {
            this.language = language;
            return this;
        }

        public InfoVO position(String position) {
            this.position = position;
            return this;
        }

        public InfoVO career(String career) {
            this.career = career;
            return this;
        }

        public InfoVO soulFood(String soulFood) {
            this.soulFood = soulFood;
            return this;
        }

        public InfoVO score(int score) {
            this.score = score;
            return this;
        }

    }

}
