package etc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://programmers.co.kr/learn/courses/30/lessons/42888
public class Open_Chatting_Room {

    public static void main(String[] args) {
        String[] record = new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        Map<String, String> idmap = new HashMap<>();
        for (int i = 0; i < record.length; i++) {
            String[] temp = record[i].split(" ");
            switch (temp[0]) {
                case "Enter":
                case "Change":
                    idmap.put(temp[1], temp[2]);
                    break;
            }
        }


        for (int i = 0; i < record.length; i++) {
            if(record[i].split(" ")[0].equals("Change")) {
                for(int j = 0; j < record.length; j++) {
                    String uid = record[i].split(" ")[1];
                    if(record[j].split(" ")[1].equals(uid)) {
                        String temp = record[j].split(" ")[0] + " " + record[j].split(" ")[1] + " " + record[i].split(" ")[2];
                        record[j] = temp;
                    }
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < record.length; i++) {
            String[] temp = record[i].split(" ");
            switch (temp[0]) {
                case "Enter":
                    answer.append(idmap.get(temp[1]) + "님이 들어왔습니다.\n");
                    break;
                case "Leave":
                    answer.append(idmap.get(temp[1]) + "님이 나갔습니다.\n");
                    break;
            }
        }

        String[] answer2 = answer.toString().split("\n");
        System.out.println("gg");

    }

}
