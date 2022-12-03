import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            cnt = 0;
            String str = br.readLine();
            int l = 0, r = str.length() - 1;
            recursion(str, l, r);
            if(cnt != str.length() / 2 + 1) {
                System.out.println("0 " + cnt);
            }
            else {
                System.out.println("1 " + cnt);
            }

        }
    }

    public static void recursion(String str, int l, int r) {
        cnt++;
        if (r <= l) {
            return;
        }

        if (str.charAt(l) == str.charAt(r)) {
            recursion(str, l + 1, r - 1);
        }
    }
}