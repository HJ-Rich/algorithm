package library;

import lombok.Builder;

import java.util.List;

@Builder
public class BubbleSort {

    private List<Integer> listToSort;
    private int comparisons;
    private int swaps;

    public static void main(String[] args) {
        BubbleSort bubbleSort = BubbleSort.builder()
                                    .listToSort(
                                        RandomIntegerArray.builder()
                                            .min(1)
                                            .max(100000)
                                            .size(40000)
                                            .build().getRandomIntegerArray()
                                    ).build();

        System.out.print("정렬 전 0-10 인덱스 : ");
        for (int i = 0; i < 10; i++) {
            System.out.print(bubbleSort.listToSort.get(i) + " ");
        }
        System.out.println();

        System.gc();
        long before = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long sortStarted = System.currentTimeMillis();

        bubbleSort.bubbleSort(bubbleSort.listToSort, 0);

        long sortEnded = System.currentTimeMillis();
        double time = (sortEnded - sortStarted) / 1000.0;

        System.gc();
        long after = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        double usedMemory = (before - after) / 1024.0 / 1024.0;

        System.out.print("정렬 후 0-10 인덱스 : ");
        for (int i = 0; i < 10; i++) {
            System.out.print(bubbleSort.listToSort.get(i) + " ");
        }
        System.out.println();
        System.out.printf("%.3f 초 소요\n", time);
        System.out.printf("%.3f MB 소요\n", usedMemory);
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
