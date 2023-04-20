import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int max = 0;
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n ;i++) {
            int num = Integer.parseInt(st.nextToken());
            if(max < num) {
                max = num;
            }
            sum += num;
        }

        System.out.println((float)sum/(n * max) * 100);
    }
}