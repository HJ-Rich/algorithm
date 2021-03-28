package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 주유소 https://www.acmicpc.net/problem/13305
public class Greedy_BJ_13305 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfCities = Integer.parseInt(scanner.nextLine());
        String[] _distances = scanner.nextLine().split(" ");
        String[] _oilPrices = scanner.nextLine().split(" ");

        List<Integer> distances = new ArrayList<>();
        for(String d : _distances) distances.add(Integer.parseInt(d));

        List<Integer> oilPrices = new ArrayList<>();
        for(String o : _oilPrices) oilPrices.add(Integer.parseInt(o));
        oilPrices.remove(oilPrices.get(oilPrices.size()-1));

        int totalDistance = 0;
        for (Integer distance : distances) totalDistance += distance;
        int result = 0;

        while(true) {
            int minPrice = Collections.min(oilPrices);
            int index = distances.indexOf(minPrice);

            int dis = 0;
            for(int i = index; i < distances.size(); i++) {
                dis += distances.get(i);
            }
            result += dis * minPrice;
            totalDistance -= dis;

            if(totalDistance == 0) break;

            distances.subList(index, distances.size()-1);
            oilPrices.subList(index, oilPrices.size()-1);
        }

        System.out.println(result);
    }

}
