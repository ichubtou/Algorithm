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

        int yLen = Integer.parseInt(st.nextToken());
        int xLen = Integer.parseInt(st.nextToken());

        int[][] arr = new int[yLen][xLen];

        for(int i = 0; i < yLen; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < xLen; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(arr));
    }

    private static int bfs(int arr[][]) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];

        Queue<int[]> queue = new LinkedList<>();

        int result = 0;

        int[] x = {1, 1, 1, -1, -1, -1, 0, 0};
        int[] y = {1, 0, -1, 1, 0, -1, 1, -1};

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == 1 && !visited[i][j]) {
                    result++;
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;

                    while(!queue.isEmpty()) {
                        int[] cxy = queue.poll();
                        int cx = cxy[1];
                        int cy = cxy[0];

                        for(int k = 0; k < 8; k++) {
                            int nx = cx + x[k];
                            int ny = cy + y[k];

                            if(nx >= 0 && nx < arr[0].length && ny >= 0 && ny < arr.length && !visited[ny][nx] && arr[ny][nx] == 1) {
                                queue.add(new int[]{ny, nx});
                                visited[ny][nx] = true;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
