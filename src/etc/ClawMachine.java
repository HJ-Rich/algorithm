package etc;

// https://programmers.co.kr/learn/courses/30/lessons/64061
public class ClawMachine {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 0, 0, 0},{0, 0, 1, 0, 3},{0, 2, 5, 0, 1},{4, 2, 4, 4, 2},{3, 5, 1, 3, 1}}, new int[]{1, 5, 3, 5, 1, 2, 1, 4}));
    }

    private static int solution(int[][] board, int[] moves) {
        int result = 0;

        int stackNumber = 0;

        for (int i = 0; i < moves.length; i++) {
            int move = moves[i];

            for (int j = 0; j < board.length; j++) {
                int target = board[j][move-1];
                if(target != 0) {
                    if(stackNumber == target) {
                        result += 2;
                        stackNumber = 0;
                    }
                    else {
                        stackNumber = target;
                    }
                    board[j][move-1] = 0;
                }
            }
        }

        return result;
    }


}
