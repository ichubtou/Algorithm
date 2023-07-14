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

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int size = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] startXY = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            st = new StringTokenizer(br.readLine());
            int[] endXY = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            arr[i] = bfs(startXY, endXY, size);
        }

        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static int bfs(int[] start, int[] end, int size) {
        Queue<int[]> queue = new LinkedList<>();
        int[] x = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
        int[] y = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
        int[][] visited = new int[size][size];

        queue.add(start);

        while(!queue.isEmpty()) {
            int[] cxy = queue.poll();
            int cx = cxy[1];
            int cy = cxy[0];

            if(cxy[0] == end[0] && cxy[1] == end[1]) {
                break;
            }

            for(int i = 0; i < 8; i++) {
                int nx = cx + x[i];
                int ny = cy + y[i];

                if(nx > -1 && nx < size && ny > -1 && ny < size && visited[ny][nx] == 0) {
                    queue.add(new int[]{ny, nx});
                    visited[ny][nx] = visited[cy][cx] + 1;
                }
            }
        }

        return visited[end[0]][end[1]];
    }
}
