package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 주유소 https://www.acmicpc.net/problem/13305
public class Greedy_BJ_13305A {

    public static void main(String[] args) throws IOException {

        // 도시 수, 도시간 거리, 도시별 가격 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        String[] _distances = br.readLine().split(" ");
        String[] _oilPrices = br.readLine().split(" ");

        int[] distances = new int[_distances.length];
        int[] oilPrices = new int[_oilPrices.length - 1];

        for(int i = 0; i < _distances.length; i++) distances[i] = Integer.parseInt(_distances[i]);
        for(int i = 0; i < _oilPrices.length - 1; i++) oilPrices[i] = Integer.parseInt(_oilPrices[i]);

        // 리턴 밸류 선언
        Long result = 0L;



        // 배열에 값이 존재하지 않을 경우 while문 탈출 후 결과 출력
        System.out.println(result);
    }

}
