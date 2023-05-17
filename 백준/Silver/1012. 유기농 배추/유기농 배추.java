import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] result = new int[n];
        int[][] arr;

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int xLen = Integer.parseInt(st.nextToken());
            int yLen = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            arr = new int[xLen][yLen];

            for(int j = 0; j < num; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                arr[x][y] = 1;
            }
            result[i] = bfs(arr);
        }

        for(int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static int bfs(int[][] arr) {
        int cnt = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int[] dx = new int[] {1, -1, 0, 0};
        int[] dy = new int[] {0, 0, 1, -1};

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] xy = queue.poll();
                        int cx = xy[0];
                        int cy = xy[1];
                        for (int k = 0; k < 4; k++) {
                            int nx = cx + dx[k];
                            int ny = cy + dy[k];
                            if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr[0].length) {
                                if (!visited[nx][ny] && arr[nx][ny] == 1) {
                                    visited[nx][ny] = true;
                                    queue.add(new int[]{nx, ny});
                                }
                            }
                        }
                    }
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
