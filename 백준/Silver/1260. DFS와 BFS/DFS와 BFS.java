import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = 0;
        int n = 0;
        int start = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        len = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < len + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            list.get(n1).add(n2);
            list.get(n2).add(n1);
        }
        List<Integer> visited = new ArrayList<>();
        dfs(list, start, visited);
        System.out.println();
        String bfs = bfs(list, start).stream().map(num -> num.toString())
                .collect(Collectors.joining(" "));
        System.out.println(bfs);

    }

    public static List<Integer> bfs(ArrayList<ArrayList<Integer>> list, int start) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> visited = new ArrayList<>();
        queue.add(start);
        visited.add(start);
        result.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 1; i < list.size() + 1; i++) {
                if (list.get(current).contains(i) && !visited.contains(i)) {
                    queue.add(i);
                    visited.add(i);
                    result.add(i);
                }
            }
        }
        return result;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> list, int start, List<Integer> visited) {
        System.out.print(start);
        visited.add(start);
        for(int i = 1; i < list.size() + 1; i++) {
            if(list.get(start).contains(i) && !visited.contains(i)) {
                System.out.print(" ");
                dfs(list, i, visited);
            }
        }
    }
}
