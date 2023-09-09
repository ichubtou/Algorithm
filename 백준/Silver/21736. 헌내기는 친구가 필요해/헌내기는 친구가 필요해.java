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

        int cx = 0;
        int cy = 0;

        char[][] arr = new char[y][x];

        for(int i = 0; i < y; i++) {
            String str = br.readLine();
            for(int j = 0; j < x; j++) {
                arr[i][j] = str.charAt(j);
                if(str.charAt(j) == 'I') {
                    cy = i;
                    cx = j;
                }
            }
        }
        int result = bfs(cy, cx, arr);

        if(result == 0) {
            System.out.println("TT");
        } else {
            System.out.println(result);
        }
    }

    public static int bfs(int cy, int cx, char[][] arr) {
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{cy, cx});
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        visited[cy][cx] = true;

        int n = 0;

        while(!queue.isEmpty()) {
            int[] cxy = queue.poll();
            cy = cxy[0];
            cx = cxy[1];

            for(int i = 0; i < 4; i++) {
                int ny = cy + y[i];
                int nx = cx + x[i];

                if(ny >= 0 && nx >= 0 && ny < arr.length && nx < arr[0].length && arr[ny][nx] != 'X' && !visited[ny][nx]) {
                    queue.add(new int[]{ny, nx});
                    visited[ny][nx] = true;
                    if(arr[ny][nx] == 'P') {
                        n++;
                    }
                }
            }
        }

        return n;
    }
}
