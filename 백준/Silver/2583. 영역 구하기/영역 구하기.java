import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[][] arr = new boolean[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
        int n  = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j = y1; j < y2; j++) {
                for(int k = x1; k < x2; k++) {
                    arr[j][k] = true;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int cnt = 0;
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                int num = 0;
                if(!arr[i][j]) {
                    queue.add(new int[]{i,j});
                    arr[i][j] = true;
                    num++;
                    while(!queue.isEmpty()) {
                        int[] yx = queue.poll();
                        int cy = yx[0];
                        int cx = yx[1];

                        for(int k = 0; k < 4; k++) {
                            int ny = cy + dy[k];
                            int nx = cx + dx[k];

                            if(ny >= 0 && ny < arr.length && nx >= 0 && nx < arr[0].length && !arr[ny][nx]) {
                                arr[ny][nx] = true;
                                queue.add(new int[] {ny, nx});
                                num++;
                            }
                        }
                    }
                    list.add(num);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(list);
        String str = list.stream().map(num -> num.toString()).collect(Collectors.joining(" "));
        System.out.println(str);
    }
}
