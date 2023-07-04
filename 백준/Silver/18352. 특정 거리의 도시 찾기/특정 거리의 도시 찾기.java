import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] visited;

    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int len = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        visited = new int[len + 1];

        List<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < len + 1; i++) {
            list.add(new ArrayList<>());
            visited[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int i1 = Integer.parseInt(st.nextToken());
            int i2 = Integer.parseInt(st.nextToken());

            list.get(i1).add(i2);
        }

        bfs(list, start);

        boolean check = false;

        for(int i = 0; i < visited.length; i++) {
            if(visited[i] == k) {
                check = true;
                System.out.println(i);
            }
        }

        if(check == false) {
            System.out.println(-1);
        }
    }

    public static void bfs(List<ArrayList<Integer>> list, int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = 0;
        queue.add(start);

        while (!queue.isEmpty()) {
            int c = queue.poll();

            for(int i = 0; i < list.get(c).size(); i++) {
                if(visited[list.get(c).get(i)] == -1) {
                    visited[list.get(c).get(i)] = visited[c] + 1;
                    queue.add(list.get(c).get(i));
                }

            }
        }
    }
}
