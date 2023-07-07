import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            int[][] arr = new int[y][x];

            for(int j = 0; j < y; j++) {
                String str = br.readLine();
                for(int k = 0; k < x; k++) {
                     if(str.charAt(k) == '#') {
                         arr[j][k] = 1;
                     }
                }
            }

            list.add(bfs(arr));
        }

        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    private static int bfs(int[][] arr) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int[] x = new int[]{1, -1, 0, 0};
        int[] y = new int[]{0, 0, 1, -1};
        int cnt = 0;

        for(int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] cxy = queue.poll();
                        int cx = cxy[1];
                        int cy = cxy[0];

                        for (int k = 0; k < 4; k++) {
                            int nx = cx + x[k];
                            int ny = cy + y[k];

                            if (nx >= 0 && nx < arr[0].length && ny >= 0 && ny < arr.length && !visited[ny][nx] && arr[ny][nx] == 1) {
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
