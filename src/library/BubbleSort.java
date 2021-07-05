package library;

import lombok.Builder;

import java.util.List;

@Builder
public class BubbleSort {

    private int randomIntegerArrayMin;
    private int randomIntegerArrayMax;
    private int randomIntegerArraySize;
    private double time;
    private int comparisons;
    private int swaps;

    public static void main(String[] args) {
        BubbleSort.builder()
            .randomIntegerArrayMin(1)
            .randomIntegerArrayMax(100000)
            .randomIntegerArraySize(70000)
            .build().sort();
    }

    public void sort() {
        List<Integer> integerList = RandomIntegerArray.builder().min(randomIntegerArrayMin).max(randomIntegerArrayMax).size(randomIntegerArraySize).build().getRandomIntegerArray();
        System.out.println("before sort");
        System.out.println(integerList);

        long sortStarted = System.currentTimeMillis();
        bubbleSort(integerList, 0);
        long sortEnded = System.currentTimeMillis();
        this.time = (sortEnded - sortStarted) / 1000.0;

        System.out.println("\n\n\n\n\n\n\n\n\n");
        System.out.println("after sort");
        System.out.println(integerList);

        printResult();
    }

    private void printResult() {
        System.out.println("finished sorting for " + time + " seconds!");
        System.out.println(swaps + " swaps out of " + comparisons + " comparisons used");
    }

    private void bubbleSort(List<Integer> integerList, int trials) {
        boolean needMoreSort = true;

        while (needMoreSort) {
            needMoreSort = false;
            for (int i = 0; i < integerList.size(); i++) {
                if(swap(integerList, i)) {
                    needMoreSort = true;
                }
            }
        }

    }

    private boolean swap(List<Integer> integerList, int i) {
        this.comparisons++;

        boolean result = false;

        int leftValue = 0;
        int rightValue = 0;

        try {
            leftValue = integerList.get(i);
            rightValue= integerList.get(i + 1);

            if(leftValue > rightValue) {
                int temp = integerList.get(i);
                integerList.set(i, integerList.get(i + 1));
                integerList.set(i + 1, temp);
                result = true;
                this.swaps++;
            }
        } catch (IndexOutOfBoundsException e) {
        }

        return result;
    }

}
