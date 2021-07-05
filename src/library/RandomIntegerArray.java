package library;

import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public class RandomIntegerArray {

    private int min;
    private int max;
    private int size;

    public List<Integer> getRandomIntegerArray() {
        long timeStarted = System.currentTimeMillis();

        List<Integer> integerList = new ArrayList<>();
        while (integerList.size() < size) {
            int randomNumber = (int) (Math.random() * (max - min) + min);
            if(integerList.contains(randomNumber)) {
                continue;
            }
            integerList.add(randomNumber);
        }

        long timeEnded = System.currentTimeMillis();
        System.out.println((timeEnded - timeStarted) / 1000.0 + "초 소요 : 랜덤 List 생성 완료");

        return integerList;
    }

}
