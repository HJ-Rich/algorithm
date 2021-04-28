package hash;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://programmers.co.kr/learn/courses/30/lessons/42746?language=java
public class Hash_P_42576 {
    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};
        int a = 10;

        List<String> list = new ArrayList<>();
        for(int i : numbers) list.add(String.valueOf(i));

        rich:for (int i = 0; i < 10; i++) {

            si:for (int j = 0; j < 10; j++) {
                System.out.println(11);

                if(j == 1) break rich;
            }

        }




    }
}
