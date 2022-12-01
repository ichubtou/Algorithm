import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String pwd = br.readLine();
            String result = keyLogger(pwd);

            System.out.println(result);
        }
    }

    public static String keyLogger(String pwd) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for(int i = 0; i < pwd.length(); i++) {
            if(pwd.charAt(i) == '<' || pwd.charAt(i) == '>' || pwd.charAt(i) == '-') {
                if(!left.isEmpty() && pwd.charAt(i) == '<') {
                    right.push(left.pop());
                }
                else if(!right.isEmpty() && pwd.charAt(i) == '>') {
                    left.push(right.pop());
                }
                else if(!left.isEmpty() && pwd.charAt(i) == '-'){
                    left.pop();
                }
            } else {
                left.push(pwd.charAt(i));
            }

        }
        while(!right.isEmpty()) {
            left.add(right.pop());
        }
        int len = left.size();
        for(int i = 0; i < len; i++) {
            sb.append(left.pop());
        }

        return sb.reverse().toString();
    }
}
