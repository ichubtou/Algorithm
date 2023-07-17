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

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());

        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        int result = bfs(x1, y1, x2, y2, n);
        System.out.println(result == Integer.MAX_VALUE - 1 ? -1 : result);
    }

    private static int bfs(int x1, int y1, int x2, int y2, int n) {
        Queue<int[]> queue = new LinkedList();
        int[] x = new int[]{-2, -2, 0, 0, 2, 2};
        int[] y = new int[]{-1, 1, -2, 2, -1, 1};
        int[][] visited = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++){
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        queue.add(new int[]{y1, x1});
        visited[y1][x1] = 1;

        while(!queue.isEmpty()) {
            int[] cxy = queue.poll();
            int cx = cxy[1];
            int cy = cxy[0];

            if(x2 == cx && y2 == cy) {
                break;
            }

            for(int i = 0; i < 6; i++) {
                int nx = cx + x[i];
                int ny = cy + y[i];

                if(nx > -1 && nx < n && ny > -1 && ny < n && visited[ny][nx] > visited[cy][cx] + 1) {
                    queue.add(new int[]{ny, nx});
                    visited[ny][nx] = visited[cy][cx] + 1;
                }
            }
        }
        return visited[y2][x2] - 1;
    }
}
