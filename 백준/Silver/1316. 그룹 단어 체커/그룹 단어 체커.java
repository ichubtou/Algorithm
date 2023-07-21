import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            List<Character> list = new ArrayList<>();
            String str = br.readLine();
            list.add(str.charAt(0));
            boolean check = true;
            for (int j = 1; j < str.length(); j++) {
                if (list.contains(str.charAt(j)) && str.charAt(j - 1) != str.charAt(j)) {
                    check = false;
                }
                list.add(str.charAt(j));
            }
            if(check) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
