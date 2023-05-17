import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while(!queue.isEmpty()) {
            int[] xy = queue.poll();
            int[][] arr = new int[xy[1]][xy[0]];
            for(int i  = 0; i < xy[1]; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < xy[0]; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            list.add(bfs(arr));
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            if(x != 0 && y != 0) {
                queue.add(new int[] {x, y});
            }
        }

        list.stream().forEach(System.out::println);
    }

    public static int bfs(int[][] arr) {
        int cnt = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int[] dx = {1, 1, 1, -1, -1, -1, 0, 0};
        int[] dy = {1, 0, -1, 1, 0, -1, 1, -1};

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 1 && !visited[i][j]) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;

                    while (!queue.isEmpty()) {
                        int[] xy = queue.poll();
                        int cx = xy[1];
                        int cy = xy[0];

                        for (int k = 0; k < 8; k++) {
                            int nx = cx + dx[k];
                            int ny = cy + dy[k];

                            if (nx >= 0 && nx < arr[0].length && ny >= 0 && ny < arr.length) {
                                if (!visited[ny][nx] && arr[ny][nx] == 1) {
                                    queue.add(new int[]{ny, nx});
                                    visited[ny][nx] = true;
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
