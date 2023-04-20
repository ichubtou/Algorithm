import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int max = 0;

        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> sort = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int j = Integer.parseInt(br.readLine());
            arr[i] = j;
            map.put(i, j);
        }

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            sort.put(arr[i], i);
        }

        for (int i = 0; i < map.size(); i++) {
            int temp = i - sort.get(map.get(i));
            if (temp > 0 && temp > max) {
                max = temp;
            }
        }

        System.out.println(max + 1);
    }
}