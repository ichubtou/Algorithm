import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int len = Integer.parseInt(st.nextToken()) + 1;
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[len];
        int[] resultArr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i < len; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            resultArr[i] = arr[end] - arr[start - 1];
        }

        for (int i : resultArr) {
            System.out.println(i);
        }
    }
}
