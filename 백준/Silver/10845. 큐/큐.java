import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ClientInfoStatus;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        int l = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int x = 0;

            if (str.equals("push")) {
                x = Integer.parseInt(st.nextToken());
                queue.add(x);
                l = x;
            } else if (str.equals("pop")) {
                if (queue.isEmpty()) {
                    x = -1;
                } else {
                    x = queue.poll();
                }
            } else if (str.equals("size")) {
                x = queue.size();
            } else if (str.equals("empty")) {
                x = queue.isEmpty() ? 1 : 0;
            } else if (str.equals("front")) {
                if (queue.isEmpty()) {
                    x = -1;
                } else {
                    x = queue.peek();
                }
            } else if (str.equals("back")) {
                if (queue.isEmpty()) {
                    x = -1;
                } else {
                    x = l;
                }
            }

            if (!str.equals("push")) {
                list.add(x);
            }
        }
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
