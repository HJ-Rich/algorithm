package programmers.진행중.삼진법뒤집기.크레인인형뽑기게임;

import java.util.Stack;

// 크레인 인형뽑기 게임
// https://programmers.co.kr/learn/courses/30/lessons/64061
public class ClawMachine {

    public static void main(String[] args) {
        System.out.println(solution(
                            new int[][]{{0,0,0,0,0},
                                        {0,0,1,0,3},
                                        {0,2,5,0,1},
                                        {4,2,4,4,2},
                                        {3,5,1,3,1}},
                            new int[]{1,5,3,5,1,2,1,4}));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        // 인형을 뽑아 담아둘 스택
        Stack<Integer> dollStack = new Stack<>();

        // 인형을 뽑아 스택에 담기
        for (int i = 0; i < moves.length; i++) {

            int targetIndex = moves[i] - 1;

            for (int j = 0; j < board.length; j++) {
                if(board[j][targetIndex] == 0) continue;

                dollStack.push(board[j][targetIndex]);
                board[j][targetIndex] = 0;
                break;
            }

        }

        // 스택에서 crush가 발생하지 않을 때까지 반복
        for (int i = 0; i < dollStack.size(); i++) {
            boolean isCrushed = false;

            if(dollStack.size() > i + 1) {
                Integer target = dollStack.get(i);
                Integer nextTarget = dollStack.get(i + 1);

                if(target == nextTarget) {
                    dollStack.remove(target);
                    dollStack.remove(nextTarget);
                    isCrushed = true;
                    answer += 2;
                }

            }

            if(isCrushed) i = 0;
        }

        return answer;
    }

}
