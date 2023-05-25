import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int b;
    static int cnt;
    static List<Integer> list;
    static boolean check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        dfs(a);

        if(check != true) {
            System.out.println(-1);
        } else {
            System.out.println(Collections.min(list) + 1);
        }
    }

    public static void dfs(long a) {
        if(a == b) {
            check = true;
            list.add(cnt);
        }
        if(a < b) {
            for(int i = 0; i < 2; i++) {
                long x;
                if(i == 0) {
                    x = a * 10 + 1;
                } else {
                    x = a * 2;
                }
                cnt++;
                dfs(x);
                cnt--;
            }
        }
    }
}
