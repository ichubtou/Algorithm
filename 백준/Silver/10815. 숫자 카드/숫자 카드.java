import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] first = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            first[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(first);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            sb.append(binarySearch(Integer.parseInt(st.nextToken()), first));
        }

        System.out.println(sb);
    }

    //이진탐색 사용
    public static String binarySearch(int i, int[] first) {
        int lIdx = 0;
        int rIdx = first.length - 1;
        while(lIdx <= rIdx) {
            int mIdx = (lIdx + rIdx) / 2;

            if(i < first[mIdx]) {
                rIdx = mIdx - 1;
            } else if(i > first[mIdx]) {
                lIdx = mIdx + 1;
            } else {
                return "1 ";
            }
        }
        return "0 ";
    }
}
