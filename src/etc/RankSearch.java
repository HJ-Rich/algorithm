package etc;

import java.util.ArrayList;
import java.util.List;

public class RankSearch {

    public static void main(String[] args) {

        System.out.println(
            solution(
                    new String[]{"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"},
                    new String[]{"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"}
            )
        );
    }



    public static String[] solution(String[] info, String[] query) {

        List<InfoVO> applicants = new ArrayList<>();

        // Convert applicants Infos from String Array to VO Array
        for (int i = 0; i < info.length; i++) {
            String[] stringInfo = info[i].split(" ");
            applicants.add(
                    new InfoVO()
                    .language(stringInfo[0])
                    .position(stringInfo[1])
                    .career(stringInfo[2])
                    .soulFood(stringInfo[3])
                    .score(stringInfo[4]));
        }

        // Search for applicants suitable on condition
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < query.length; i++) {
            //String[]
            //switch ()

        }

        return null;
    }

    public static class InfoVO{

        public String language;
        public String position;
        public String career;
        public String soulFood;
        public String score;

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

        public String getScore() {
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

        public InfoVO score(String score) {
            this.score = score;
            return this;
        }

    }

    public static class QueryVO {
        public enum queryLanguage {
            HEADER {
                @Override
                public String toString() {
                    return "header";
                }
            },
            SECTION
        }
    }

}
