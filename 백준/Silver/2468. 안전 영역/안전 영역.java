import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 101; i++) {
            int result = bfs(arr, i);

            if(answer < result) {
                answer = result;
            }
        }

        System.out.println(answer);
    }

    private static int bfs(int[][] arr, int h) {
        boolean[][] visited = new boolean[arr.length][arr.length];
        Queue<int[]> queue = new LinkedList<>();
        int[] x = new int[]{1, -1, 0, 0};
        int[] y = new int[]{0, 0, 1, -1};
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] > h && !visited[i][j]) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        int xy[] = queue.poll();
                        int cy = xy[0];
                        int cx = xy[1];

                        for (int k = 0; k < 4; k++) {
                            int ny = cy + y[k];
                            int nx = cx + x[k];

                            if (nx > -1 && nx < arr.length && ny > -1 && ny < arr.length && arr[ny][nx] > h && !visited[ny][nx]) {
                                queue.add(new int[]{ny, nx});
                                visited[ny][nx] = true;
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
