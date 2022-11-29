import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int from = 1;
        int temp = 2;
        int to = 3;
        BigInteger result = new BigInteger("1");
        if(n < 21) {
            hanoi(n, from, temp, to);

            System.out.println(sb.length() / 4);
            System.out.println(sb);
        } else {
            for(int i = 0; i < n; i++) {
                result = result.multiply(new BigInteger("2"));
            }
            result = result.subtract(new BigInteger("1"));

            System.out.println(result);
        }
    }
    public static void hanoi(int n, int from, int temp, int to) {
        //n이 1이면 목적지로 가기만 하면 되니까 from -> to
        if(n == 1) {
            sb.append(from + " " + to + "\n");
            return;
        }

        //n-1개의 요소들을 목적지가 아닌 기둥으로 옮김
        hanoi(n - 1, from, to, temp);

        //제일 큰 원판을 목적지로 이동
        sb.append(from + " " + to + "\n");

        //목적지가 아닌 기둥으로 옮긴 요소들을 다시 목적지로 이동
        hanoi(n - 1, temp, from, to);
    }
}
