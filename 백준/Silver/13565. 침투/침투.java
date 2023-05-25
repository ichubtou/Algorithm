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

        int[][] arr = new int[y][x];

        for (int i = 0; i < y; i++) {
            String str = br.readLine();
            for (int j = 0; j < x; j++) {
                arr[i][j] = Integer.parseInt(str.substring(j, j + 1));
            }
        }

        boolean[][] visited = bfs(arr);
        boolean check = false;

        for(int i = 0; i < visited[0].length; i++) {
            if(visited[visited.length - 1][i]) {
                check = true;
            }
        }

        System.out.println(check ? "YES" : "NO");
    }

    public static boolean[][] bfs(int[][] arr) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];

        Queue<int[]> queue = new LinkedList<>();

        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};

        for (int i = 0; i < arr[0].length; i++) {
            if (arr[0][i] == 0 && !visited[0][i]) {
                visited[0][i] = true;
                queue.add(new int[]{0, i});

                while (!queue.isEmpty()) {
                    int[] xy = queue.poll();
                    int cx = xy[1];
                    int cy = xy[0];

                    for (int j = 0; j < 4; j++) {
                        int nx = cx + x[j];
                        int ny = cy + y[j];

                        if(nx >= 0 && nx < arr[0].length && ny >= 0 && ny < arr.length && !visited[ny][nx] && arr[ny][nx] == 0) {
                            visited[ny][nx] = true;
                            queue.add(new int[]{ny, nx});
                        }
                    }
                }
            }
        }

        return visited;
    }
}
