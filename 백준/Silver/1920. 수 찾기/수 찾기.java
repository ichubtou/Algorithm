import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[Integer.parseInt(br.readLine())];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        Arrays.sort(arr);

        int n2 = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < n2; i++) {
            int n = Integer.parseInt(st2.nextToken());
            if(Arrays.binarySearch(arr, n) >= 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

    }
}
