import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack = new Stack<>();

        String str = br.readLine();

        int result = 0;

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                stack.push('(');
            } else if(str.charAt(i) == ')') {
                if(stack.isEmpty()) {
                    result++;
                } else {
                    stack.pop();
                }
            }
        }

        System.out.println(result + stack.size());
    }
}
