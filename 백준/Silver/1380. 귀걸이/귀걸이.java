import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> result = new ArrayList<>();

        List<String> list = new ArrayList<>();

        while (true) {
            String str = br.readLine();
            if (!list.isEmpty()) {
                for (String s : list) {
                    if(s != null) {
                        result.add(s);
                    }
                }
            }
            if (Integer.parseInt(str) == 0) {
                break;
            }
            Map<String, Integer> map = new HashMap<>();
            list = new ArrayList<>();

            for (int i = 0; i < Integer.parseInt(str); i++) {
                String name = br.readLine();
                list.add(name);
                map.put(name, i + 1);
            }

            for (int i = 0; i < 2 * Integer.parseInt(str) - 1; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());

                if(!map.containsValue(n)) {
                    list.set(n - 1, null);
                } else {
                    map.values().remove(n);
                }
            }
        }

        int j = 1;
        for (int i = 0; i < result.size(); i++, j++) {
            System.out.println(j + " " + result.get(i));
        }
    }
}
