import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        boolean check = false;
        int sum = 0;
        List<Character> list = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') {
                check = true;
            }
            sum += s.charAt(i) - '0';
            list.add(s.charAt(i));
        }

        if(!(sum % 3 == 0)) {
            check = false;
        }

        if(check == false) {
            System.out.println(-1);
        } else {
            Collections.sort(list, Collections.reverseOrder());
            String str = "";
            for (Character character : list) {
                str += character;
            }
            System.out.println(str);
        }
    }
}
