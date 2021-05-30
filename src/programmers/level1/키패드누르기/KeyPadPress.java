package programmers.level1.키패드누르기;

// 키패드 누르기
// https://programmers.co.kr/learn/courses/30/lessons/67256
public class KeyPadPress {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
        System.out.println(solution(new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left"));
        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
    }

    public static String solution(int[] numbers, String hand) {
        String result = "";

        User user = new User(hand);

        for (int i = 0; i < numbers.length; i++) {
            result += user.getPressingHand(numbers[i]);
        }

        return result;
    }

    public static class User {

        public int[][] keypad = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -1}};
        public int keyX = -1;
        public int keyY = -1;

        public String hand;
        public int leftX = 3;
        public int leftY = 0;
        public int rightX = 3;
        public int rightY = 2;

        public User(String hand) {
            this.hand = hand;
        }

        /**
         * 누른 키 패드 번호를 받아서 X, Y좌표를 설정합니다.
         * @param key 누른 키패드 번호
         */
        public void pressKeypad(int key) {
            outer:for (int i = 0; i < keypad.length; i++) {
                for (int j = 0; j < keypad[i].length; j++) {
                    if(keypad[i][j] == key) {
                        keyX = i;
                        keyY = j;
                        break outer;
                    }
                }
            }
        }

        /**
         * 키패드를 누른 손의 X, Y좌표를 설정합니다.
         * @param hand 키패드를 누른 손을 문자열 L 또는 R로 받습니다.
         */
        public void setHandPosition(String hand) {
            switch (hand) {
                case "L":
                    leftX = keyX;
                    leftY = keyY;
                    break;
                case "R":
                    rightX = keyX;
                    rightY = keyY;
                    break;
            }
        }

        /**
         * 키패드 번호를 파라미터로 받아, 어떤 손으로 눌렀는지 L 또는 R 문자열로 반환합니다.
         * @param key 누른 키패드 번호
         * @return 키패드를 누른 손을 문자열 L 또는 R로 반환합니다.
         */
        public String getPressingHand(int key) {
            String result = "";

            pressKeypad(key);

            if(key == 1 || key == 4 || key == 7) {
                result = "L";
            }

            else if(key == 3 || key == 6 || key == 9) {
                result = "R";
            }

            else if(key == 2 || key == 5 || key == 8 || key == 0) {
                int distanceL = Math.abs(leftX - keyX) + Math.abs(leftY - keyY);
                int distanceR = Math.abs(rightX - keyX) + Math.abs(rightY - keyY);

                if (distanceL < distanceR) {
                    result = "L";
                } else if (distanceR < distanceL) {
                    result = "R";
                } else if (distanceL == distanceR) {
                    result = (this.hand.equals("left")) ? "L" : "R";
                }
            }

            setHandPosition(result);

            return result;
        }

    }
}
