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

        char[][] arr = new char[y][x];

        for (int i = 0; i < y; i++) {
            String str = br.readLine();
            for (int j = 0; j < x; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int[] result = dfs(arr);

        System.out.println(result[0] + " " + result[1]);
    }

    private static int[] dfs(char[][] arr) {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        Queue<int[]> queue = new LinkedList<>();

        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};

        int v = 0;
        int k = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                int tempV = 0;
                int tempK = 0;
                if ((arr[i][j] == '.' || arr[i][j] == 'v' || arr[i][j] == 'k') && !visited[i][j]) {
                    visited[i][j] = true;
                    if (arr[i][j] == 'v') {
                        tempV++;
                    } else if (arr[i][j] == 'k') {
                        tempK++;
                    }
                    queue.add(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        int[] cxy = queue.poll();
                        int cx = cxy[1];
                        int cy = cxy[0];

                        for (int l = 0; l < 4; l++) {
                            int nx = cx + x[l];
                            int ny = cy + y[l];

                            if (nx >= 0 && nx < arr[0].length && ny >= 0 && ny < arr.length && !visited[ny][nx] && arr[ny][nx] != '#') {
                                if (arr[ny][nx] == 'v') {
                                    tempV++;
                                } else if (arr[ny][nx] == 'k') {
                                    tempK++;
                                }
                                visited[ny][nx] = true;
                                queue.add(new int[]{ny, nx});
                            }
                        }
                    }
                }
                if(tempV >= tempK) {
                    v += tempV;
                } else {
                    k += tempK;
                }
            }
        }
        return new int[]{k, v};
    }
}
