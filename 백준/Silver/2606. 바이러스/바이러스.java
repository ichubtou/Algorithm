import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];

        Map<Integer, Integer> map = new HashMap<>();
        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            arr[num2][num1] = 1;
            arr[num1][num2] = 1;
        }

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 1; i < n + 1; i++) {
            if (arr[1][i] == 1) {
                int[] xy = {1, i};
                queue.add(xy);
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];

            for (int j = 0; j < n + 1; j++) {
                if (arr[cx][j] == 1) {
                    queue.add(new int[]{j, 0});
                    map.put(j, j);
                    arr[cx][j] = 0;
                    arr[j][cx] = 0;
                }
            }
        }

        System.out.println(map.size());
    }
}

