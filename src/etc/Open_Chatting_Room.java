package etc;

// https://programmers.co.kr/learn/courses/30/lessons/42888
public class Open_Chatting_Room {

    public static void main(String[] args) {
        String[] w = new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        for (int i = 0; i < w.length; i++) {
            if(w[i].split(" ")[0].equals("Change")) {
                for(int j = 0; j < w.length; j++) {
                    String uid = w[i].split(" ")[1];
                    if(w[j].split(" ")[1].equals(uid)) {
                        String temp = w[j].split(" ")[0] + " " + w[j].split(" ")[1] + " " + w[i].split(" ")[2];
                        w[j] = temp;
                    }
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();



    }

}
