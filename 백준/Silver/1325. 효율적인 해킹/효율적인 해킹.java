import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());

            list.get(i1).add(i2);
        }

        count = new int[n + 1];

        bfs(list);

        int max = 0;

        for (int i = 0; i < count.length; i++) {
            if (max < count[i]) {
                max = count[i];
            }
        }

        for (int i = 0; i < count.length; i++) {
            if (max == count[i]) {
                System.out.print(i + " ");
            }
        }
    }

    private static void bfs(List<ArrayList<Integer>> list) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < list.size(); i++) {
            boolean[] visited = new boolean[list.size() + 1];
            visited[i] = true;
            queue.add(i);

            while (!queue.isEmpty()) {
                int c = queue.poll();
                for (int j = 0; j < list.get(c).size(); j++) {
                    if (!visited[list.get(c).get(j)]) {
                        queue.add(list.get(c).get(j));
                        count[list.get(c).get(j)]++;
                        visited[list.get(c).get(j)] = true;
                    }
                }
            }
        }
    }
}
