import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[][] arr1 = new String[n][n];
        String[][] arr2 = new String[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr1[i][j] = str.substring(j, j + 1);
                if (str.charAt(j) == 'R') {
                    arr2[i][j] = "G";
                } else {
                    arr2[i][j] = str.substring(j, j + 1);
                }
            }
        }

        System.out.println(bfs(arr1) + " " + bfs(arr2));
    }

    public static int bfs(String[][] arr) {
        int result = 0;
        boolean[][] visited = new boolean[arr.length][arr.length];
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (visited[i][j] == false) {
                    Queue<int[]> queue = new LinkedList();
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                    String color = arr[i][j];
                    while (!queue.isEmpty()) {
                        int[] xy = queue.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = xy[0] + dx[k];
                            int ny = xy[1] + dy[k];
                            if (nx >= 0 && nx < arr.length && ny >= 0 && ny < arr.length) {
                                if (!visited[nx][ny] && arr[nx][ny].equals(color)) {
                                    queue.add(new int[]{nx, ny});
                                    visited[nx][ny] = true;
                                }
                            }
                        }
                    }
                    result++;
                }
            }
        }
        return result;
    }
}