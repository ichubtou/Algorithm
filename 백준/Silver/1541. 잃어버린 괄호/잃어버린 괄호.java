import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int result = 0;

        String[] split = str.split("-");

        for(int i = 0; i < split.length; i++) {
            if(i == 0) {
                String[] split1 = split[i].split("\\+");
                for(int j = 0; j < split1.length; j++) {
                    result += Integer.parseInt(split1[j]);
                }
            } else {
                String[] split1 = split[i].split("\\+");
                int sum = 0;
                for (int j = 0; j < split1.length; j++) {
                    sum += Integer.parseInt(split1[j]);
                }
                result -= sum;
            }
        }

        System.out.println(result);
    }
}
