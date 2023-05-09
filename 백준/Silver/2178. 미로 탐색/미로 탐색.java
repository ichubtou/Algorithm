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

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[][] arr = new int[x][y];
        int[] dx = new int[] {1, -1, 0, 0};
        int[] dy = new int[] {0, 0, 1, -1};

        for(int i = 0; i < x; i++) {
            String temp = br.readLine();
            for(int j = 0; j < y; j++) {
                arr[i][j] = Integer.parseInt(temp.substring(j, j + 1));
            }
        }

        Queue<int[]> queue = new LinkedList();
        int[][] visited = new int[x][y];
        visited[0][0] = 1;
        queue.add(new int[]{0, 0});

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            int cx = current[0];
            int cy = current[1];

            if(cx == x - 1 && cy == y - 1) {
                break;
            }

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < x && ny < y) {
                    if (arr[nx][ny] == 1 && visited[nx][ny] == 0) {
                        visited[nx][ny] = visited[cx][cy] + 1;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }

        System.out.println(visited[x - 1][y - 1]);
    }
}
