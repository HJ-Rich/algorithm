package etc;

import java.util.ArrayList;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/64061
// 9/11 통과...
public class ClawMachine {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}}, new int[]{1, 5, 3, 5, 1, 2, 1, 4}));
        System.out.println(solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}}, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
        System.out.println(solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}}, new int[]{1, 5, 3, 5, 1, 2, 1, 4}));
    }

    private static int solution(int[][] board, int[] moves) {
        int result = 0;

        List<Integer> stackNumberList = new ArrayList<>();

        for (int i = 0; i < moves.length; i++) {
            int move = moves[i];

            for (int j = 0; j < board.length; j++) {
                int target = board[j][move-1];
                if(target != 0) {
                    stackNumberList.add(target);
                    board[j][move-1] = 0;
                    break;
                }
            }

        }

        for (int i = 0; i < stackNumberList.size(); i++) {
            if(i < stackNumberList.size() - 1) {
                int now = stackNumberList.get(i);
                int next = stackNumberList.get(i + 1);
                if(now == next) {
                    result += 2;
                    stackNumberList.remove(i);
                    stackNumberList.remove(i);
                    i = 0;
                }
            }
        }

        return result;
    }


}
