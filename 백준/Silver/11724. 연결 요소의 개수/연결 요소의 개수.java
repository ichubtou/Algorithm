import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n1 + 1][n1 + 1];
        int cnt = 0;
        
        for(int i = 1; i < arr.length; i++) {
            arr[i][i] = 1;
        }

        int n2 = Integer.parseInt(st.nextToken());

        for(int i = 1; i < n2 + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            arr[num1][num2] = 1;
            arr[num2][num1] = 1;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i < arr.length; i++) {
            for(int j = 1; j < arr.length; j++) {
                if(arr[i][j] == 1) {
                    queue.add(i);
                    while(!queue.isEmpty()) {
                        int x = queue.poll();
                        for(int k = 1; k < arr.length; k++) {
                            if(arr[x][k] == 1) {
                                queue.add(k);
                                arr[x][k] = 0;
                                arr[k][x] = 0;
                            }
                        }
                    }
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
