package codestates.Implementation;

public class BoardGame {
    public static void main(String[] args) {
        int[][] board1 = new int[][]{
                {0, 0, 0, 1},
                {1, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0}
        };
        int output1 = boardGame(board1, "RRDLLD");
        System.out.println(output1); // 4


        int[][] board2 = new int[][]{
                {0, 0, 1},
                {1, 1, 1},
                {1, 0, 0}
        };
        int output2 = boardGame(board2, "UUUDD");
        System.out.println(output2); // null

        int[][] board3 = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0}
        };
        int output3 = boardGame(board3, "DDRRRUDUDUD");
        System.out.println(output3); // 0
    }

    public static Integer boardGame(int[][] board, String operation) {
        //연산 인덱스 선언
        int operationIdx = 0;
        //현재 좌표 선언
        int[] current = {0, 0};
        //게임 점수 선언
        int point = 0;
        //연산이 끝날때까지 반복
        while(operationIdx != operation.length()) {
            //조작 방향에 따라 이동 좌표 적용
            if(operation.charAt(operationIdx) == 'U') {
                current[0]--;
            } else if(operation.charAt(operationIdx) == 'D') {
                current[0]++;
            } else if(operation.charAt(operationIdx) =='L') {
                current[1]--;
            } else {
                current[1]++;
            }

            //맵 밖으로 나갔을 때
            if(current[0] == -1 || current[1] == -1 || current[0] > board.length - 1 || current[1] > board.length - 1) {
                return -1;
            }
            //지점이 1일 경우 point++
            if (board[current[0]][current[1]] == 1) {
                point++;
            }

            //연산인덱스++  해주어 다음 연산 시행
            operationIdx++;
        }
        return point;
    }
}
