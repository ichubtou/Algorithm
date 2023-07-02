import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int i1 = Integer.parseInt(st.nextToken());
        int i2 = Integer.parseInt(st.nextToken());

        int[] prime = new int[i2 + 1];

        for (int i = 2; i < i2 + 1; i++) {
            prime[i] = i;
        }

        for (int i = 2; i < i2 + 1; i++) {
            if (prime[i] == 0) {
                continue;
            }
            for (int j = 2 * i; j < i2 + 1; j += i) {
                prime[j] = 0;
            }
        }

        for (int i : prime) {
            if(i != 0 && i > i1 - 1){
                System.out.println(i);
            }
        }
    }
}
