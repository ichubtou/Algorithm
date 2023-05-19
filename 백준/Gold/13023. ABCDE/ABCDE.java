import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int xy = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        List<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < xy; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.get(x).add(y);
            list.get(y).add(x);
        }
        int cnt = 0;

        for (int i = 0; i < xy; i++) {
            visited = new boolean[xy];
            dfs(list, i, cnt);
            if (check == true) {
                System.out.println(1);
                break;
            }
        }

        if (check == false) {
            System.out.println(0);
        }
    }

    public static boolean dfs(List<ArrayList<Integer>> list, int n, int cnt) {
        visited[n] = true;
        cnt++;
        if (cnt == 5 || check == true) {
            check = true;
            return true;
        }
        for (int i = 0; i < list.get(n).size(); i++) {
            if (!visited[list.get(n).get(i)])
                dfs(list, list.get(n).get(i), cnt);
        }
        visited[n] = false;
        return false;
    }
}
