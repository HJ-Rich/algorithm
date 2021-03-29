package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 주유소 https://www.acmicpc.net/problem/13305
public class Greedy_BJ_13305B {

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

        // 배열에 값이 남아있을 동안 반복
        while(distances.length > 0) {

            // 도시별 가격 배열에서 최저값과 인덱스 찾기
            int minOilPrice = oilPrices[0];
            int indexOfMinOilPrice = 0;
            for (int i = 0; i < oilPrices.length; i++) {
                if (oilPrices[i] < minOilPrice) {
                    minOilPrice = oilPrices[i];
                    indexOfMinOilPrice = i;
                }
            }

            // 도시간 거리 배열에서 위에서 찾은 인덱스 이후 값을 합연산하여 최저값으로 갈 거리를 구함
            Long sumOfDistanceToGo = 0L;
            for (int i = indexOfMinOilPrice; i < distances.length; i++) sumOfDistanceToGo += distances[i];

            // 최저값 * 거리 로 소요 금액을 구해 누적연산
            result += minOilPrice * sumOfDistanceToGo;

            // 계산을 완료한 만큼 도시간 거리, 도시별 가격 배열을 잘라냄
            distances = Arrays.copyOfRange(distances, 0, indexOfMinOilPrice);
            oilPrices = Arrays.copyOfRange(oilPrices, 0, indexOfMinOilPrice);
        }

        // 배열에 값이 존재하지 않을 경우 while문 탈출 후 결과 출력
        System.out.println(result);
    }

}
