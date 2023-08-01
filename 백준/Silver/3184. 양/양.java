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

        String[][] arr = new String[y][x];

        for (int i = 0; i < y; i++) {
            String str = br.readLine();
            for (int j = 0; j < x; j++) {
                arr[i][j] = String.valueOf(str.charAt(j));
            }
        }

        int[] result = bfs(arr);

        System.out.println(result[0] + " " + result[1]);
    }

    private static int[] bfs(String[][] arr) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[arr.length][arr[0].length];

        int s = 0;
        int w = 0;

        int[] x = new int[]{1, -1, 0, 0};
        int[] y = new int[]{0, 0, 1, -1};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                int tempS = 0;
                int tempW = 0;
                if ((arr[i][j].equals("o") || arr[i][j].equals("v")) && !visited[i][j]) {
                    if(arr[i][j].equals("o")) {
                        tempS++;
                    } else if(arr[i][j].equals("v")) {
                        tempW++;
                    }
                    visited[i][j] = true;
                    queue.add(new int[] {i, j});
                    while (!queue.isEmpty()) {
                        int[] xy = queue.poll();
                        int cx = xy[1];
                        int cy = xy[0];

                        for(int k = 0; k < 4; k++) {
                            int nx = cx + x[k];
                            int ny = cy + y[k];

                            if(nx >= 0 && nx < arr[0].length && ny >= 0 && ny < arr.length && !visited[ny][nx] && !arr[ny][nx].equals("#")) {
                                if(arr[ny][nx].equals("o")) {
                                    tempS++;
                                } else if(arr[ny][nx].equals("v")) {
                                    tempW++;
                                }
                                visited[ny][nx] = true;
                                queue.add(new int[] {ny, nx});
                            }
                        }
                    }
                    if(tempS > tempW) {
                        s += tempS;
                    } else {
                        w += tempW;
                    }
                }
            }
        }

        return new int[] {s, w};
    }
}
