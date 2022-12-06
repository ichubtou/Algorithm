import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        //사람 명수 만큼 배열 선언
        int[] people = new int[n];
        //배열에 넣어줌
        for(int i = 0; i < n; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }
        //오름차순 정렬 가장 적은 시간을 쓰는 사림이 맨 앞에 있어야 최소시간 가능
        Arrays.sort(people);
        int result = atm(people);
        System.out.println(result);
    }

    public static int atm(int[] people) {
        int sum = 0;
        int arrLen = people.length;
        //맨앞에 있는 사람이 사용하는 시간과 사람의 명수 만큼 전체시간에 + 됨 n = 5일때 맨앞이 1이면 5 * 1 두번째가 2면 4 * 2 세번째가 3이면 3 * 3 .....
        for(int i = 0; i < people.length; i++) {
            sum = sum + people[i] * arrLen;
            arrLen--;
        }

        return sum;
    }
}