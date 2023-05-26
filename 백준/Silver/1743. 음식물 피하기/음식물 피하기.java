import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int yLen = Integer.parseInt(st.nextToken());
        int xLen = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] arr = new int[yLen][xLen];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;

            arr[y][x] = 1;
        }

        System.out.println(bfs(arr));
    }

    public static int bfs(int[][] arr) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        Queue<int[]> queue = new LinkedList<>();

        int result = 0;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 1 && !visited[i][j]) {
                    int cnt = 1;
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});

                    while(!queue.isEmpty()) {
                        int[] xy = queue.poll();
                        int cx = xy[1];
                        int cy = xy[0];

                        for(int k = 0; k < 4; k++) {
                            int nx = cx + dx[k];
                            int ny = cy + dy[k];

                            if(nx >= 0 && nx < arr[0].length && ny >= 0 && ny < arr.length && !visited[ny][nx] && arr[ny][nx] == 1) {
                                cnt++;
                                visited[ny][nx] = true;
                                queue.add(new int[]{ny, nx});
                            }
                        }
                    }
                    if(result < cnt) {
                        result = cnt;
                    }
                }
            }
        }

        return result;
    }
}
