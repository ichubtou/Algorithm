import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static boolean[] visited;
    static int start;
    static int end;
    static int cnt;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());



        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        visited = new boolean[n + 1];

        dfs(list, start);

        if(result > 0) {
            System.out.println(result - 1);
        } else {
            System.out.println(-1);
        }
    }

    public static void dfs(List<ArrayList<Integer>> list, int start) {
        cnt++;
        if(start == end) {
            result = cnt;
        }

        for(int i = 0; i < list.get(start).size(); i++) {
            if (list.get(start).contains(list.get(start).get(i)) && visited[list.get(start).get(i)] == false) {
                visited[list.get(start).get(i)] = true;
                dfs(list, list.get(start).get(i));
            }
        }
        cnt--;
    }
}
