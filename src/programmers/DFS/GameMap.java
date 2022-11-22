package programmers.DFS;

import java.util.LinkedList;
import java.util.Queue;

public class GameMap {
    public static void main(String[] args) {
        GameMap test1 = new GameMap();
        GameMap test2 = new GameMap();

        int maps1[][] = new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };

        int maps2[][] = new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}
        };

        System.out.println(test1.solution(maps1));
        System.out.println(test1.solution(maps2));
    }

    public int solution(int[][] maps) {
        int answer = 0;

        Queue<int[]> queue = new LinkedList<>(); //1.
        int[][] check = new int[maps.length][maps[0].length]; //2.
        int[] movex = {1, 0, -1, 0};
        int[] movey = {0, 1, 0, -1};
        int x = 0;
        int y = 0;

        queue.add(new int[]{x, y});//3.
        check[x][y] = 1;

        while(!queue.isEmpty()) {//4.
            int[] current = queue.remove();//5.
            int cx = current[0];
            int cy = current[1];
            for(int i = 0; i < 4; i++) {//6.
                int nx = cx + movex[i];
                int ny = cy + movey[i];

                //7.
                if(nx < 0 || nx > maps.length - 1 || ny < 0 || ny > maps[0].length - 1) {
                    continue;
                }
                //8.
                if(check[nx][ny] == 0 && maps[nx][ny] == 1) {
                    check[nx][ny] = check[cx][cy] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        answer = check[maps.length - 1][maps[0].length - 1];
        if(answer == 0){
            answer = -1;
        }
        return answer;
    }
}
