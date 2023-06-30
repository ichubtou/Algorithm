import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int len = Integer.parseInt(st.nextToken());

//        List<Integer> list = new ArrayList<>();
//
//        int result = 0;
//        for(int i = 0; i < len; i++) {
//            list.add(Integer.parseInt(br.readLine()));
//        }
//
//        while(list.size() != 1) {
//            Collections.sort(list);
//            int n = list.remove(0) + list.remove(0);
//
//            result += n;
//            list.add(n);
//        }
//
//        System.out.println(result);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int result = 0;
        for (int i = 0; i < len; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        while (pq.size() != 1) {
            int n = pq.poll() + pq.poll();

            result += n;
            pq.add(n);
        }

        System.out.println(result);
    }
}
