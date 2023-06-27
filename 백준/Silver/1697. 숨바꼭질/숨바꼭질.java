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

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        bfs(n, k);
    }

    private static void bfs(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        int result = 0;

        queue.add(n);
        visited[n] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int c = queue.poll();

                if (c == k) {
                    System.out.println(result);
                }

                if (c - 1 >= 0 && !visited[c - 1]) {
                    queue.add(c - 1);
                    visited[c - 1] = true;
                }
                if (c + 1 <= 100000 && !visited[c + 1]) {
                    queue.add(c + 1);
                    visited[c + 1] = true;
                }
                if (c * 2 <= 100000 && !visited[c * 2]) {
                    queue.add(c * 2);
                    visited[c * 2] = true;
                }
            }
            result++;
        }
    }
}
