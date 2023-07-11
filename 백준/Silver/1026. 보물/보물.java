import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] aArr = new int[n];
        Integer[] bArr = new Integer[n];

        int sum = 0;

        for(int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                if(i == 0) aArr[j] = Integer.parseInt(st.nextToken());
                else bArr[j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(aArr);
        Arrays.sort(bArr, Collections.reverseOrder());

        for(int i = 0; i < n; i++) {
            sum = sum + aArr[i] * bArr[i];
        }

        System.out.println(sum);
    }
}
