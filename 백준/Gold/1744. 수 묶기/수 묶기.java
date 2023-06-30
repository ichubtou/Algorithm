import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> ppq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> mpq = new PriorityQueue<>();

        boolean zero = false;

        int result = 0;

        for(int i = 0; i < len; i++) {
            int n = Integer.parseInt(br.readLine());

            if(n > 1) {
                ppq.add(n);
            } else if(n == 1) {
                result++;
            } else if(n == 0) {
                zero = true;
            } else {
                mpq.add(n);
            }
        }

        while(ppq.size() > 1) {
            int n1 = ppq.poll();
            int n2 = ppq.poll();
            result += n1 * n2;
        }
        if(!ppq.isEmpty()) {
            result += ppq.poll();
        }
        while(mpq.size() > 1) {
            result += mpq.poll() * mpq.poll();
        }
        if(!mpq.isEmpty() && zero == false) {
            result += mpq.poll();
        }

        System.out.println(result);
    }
}
