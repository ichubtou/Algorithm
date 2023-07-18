import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean check = false;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '(') {
                    stack.push('(');
                } else if (str.charAt(j) == ')') {
                    if (stack.isEmpty()) {
                        check = true;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if(check) {
                arr[i] = "NO";
            } else {
                arr[i] = stack.isEmpty() ? "YES" : "NO";
            }
        }
        for (String s : arr) {
            System.out.println(s);
        }
    }
}
