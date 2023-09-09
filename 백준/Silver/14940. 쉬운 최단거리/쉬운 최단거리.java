import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int cy = 0;
        int cx = 0;

        int[][] arr = new int[y][x];

        for(int i = 0; i < y; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < x; j++) {
                int xy = Integer.parseInt(st.nextToken());
                if(xy == 1) {
                    arr[i][j] = -1;
                }
                if(xy == 2) {
                    cy = i;
                    cx = j;
                }
            }
        }

        bfs(cx, cy, arr);

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] bfs(int cx, int cy, int[][] arr) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{cy, cx});
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int[] x = new int[]{1, -1, 0, 0};
        int[] y = new int[]{0, 0, 1, -1};

        arr[cy][cx] = 0;
        visited[cy][cx] = true;

        while(!queue.isEmpty()) {
            int[] cxy = queue.poll();
            cy = cxy[0];
            cx = cxy[1];

            for(int i = 0; i < 4; i++) {
                int ny = cy + y[i];
                int nx = cx + x[i];

                if(ny >= 0 && nx >= 0 && ny < arr.length && nx < arr[0].length && !visited[ny][nx] && arr[ny][nx] == -1) {
                    queue.add(new int[]{ny, nx});
                    visited[ny][nx] = true;
                    arr[ny][nx] = arr[cy][cx] + 1;
                }
            }
        }

        return arr;
    }

}
