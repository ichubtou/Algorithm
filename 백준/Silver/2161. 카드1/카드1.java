import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i < n + 1; i++) {
            queue.add(i);
        }

        List<Integer> list = new ArrayList<>();
        int i = 0;
        while(queue.size() != 1) {
            i++;
            if(i % 2 == 1) {
                list.add(queue.poll());
            } else {
                int poll = queue.poll();
                queue.add(poll);
            }
        }

        list.add(queue.poll());

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
