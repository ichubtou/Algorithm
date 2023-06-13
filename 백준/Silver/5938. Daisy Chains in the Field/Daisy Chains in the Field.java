import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int len = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        List<ArrayList<Integer>> list = new ArrayList<>();
        visited = new boolean[len + 1];

        for(int i = 0; i < len + 1; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            list.get(n1).add(n2);
            list.get(n2).add(n1);
        }

        dfs(list, 1);

        boolean check = false;

        for(int i = 1; i < visited.length; i++) {
            if(!visited[i]) {
                check = true;
                System.out.println(i);
            }
        }
        
        if(!check) {
            System.out.println(0);
        }
    } 

    public static void dfs(List<ArrayList<Integer>> list, int start) {
        visited[start] = true;

        for(int i = 0; i < list.get(start).size(); i++) {
            if(list.get(start).contains(list.get(start).get(i)) && !visited[list.get(start).get(i)]) {
               dfs(list, list.get(start).get(i));
            }
        }
    }
}
