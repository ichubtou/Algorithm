import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static int solution(int n, int[][] wires) {
        int min = Integer.MAX_VALUE;
        //송전탑이 1부터 시작하므로 Matrix를 1 늘려서 선언
        int[][] matrix = new int[n + 1][n + 1];
        
        //인접행렬로 변환
        for(int i = 0; i < wires.length; i++) {
            matrix[wires[i][0]][wires[i][1]] = 1;
            matrix[wires[i][1]][wires[i][0]] = 1;
        }

        //연결된 wire를 하나씩 끊고 bfs
        for(int i = 0; i < wires.length; i++) {
            matrix[wires[i][0]][wires[i][1]] = 0;
            matrix[wires[i][1]][wires[i][0]] = 0;

            //bfs를 이용해서 송전탑 개수의 차이 return
            int result = bfs(matrix, wires[0][0]);
            
            if(min > result) {
                min = result;
            }

            //끊은 wire 다시 연결
            matrix[wires[i][0]][wires[i][1]] = 1;
            matrix[wires[i][1]][wires[i][0]] = 1;
        }

        return min;
    }

    public static int bfs(int[][] matrix, int x) {
        Queue<Integer> queue = new LinkedList<>();
        //이미 거쳐간 송전탑을 체크
        ArrayList<Integer> visited = new ArrayList<>();
        //첫번째 송전탑과 연결된 송전탑의 개수
        int cnt = 0;

        //첫 송전탑 Add
        queue.add(x);
        
        while(!queue.isEmpty()) {
            int current = queue.poll();
            visited.add(current);
            cnt++;
            
            for(int i = 0; i < matrix.length; i++) {
                if(!visited.contains(i)) {
                    if(matrix[current][i] == 1) {
                        queue.add(i);
                    }
                }
            }
        }
        
        //a = 첫번째 송전탑과 연결된 송전탑 갯수, c - a = 반대쪽 송전탑 갯수
        //c - a - a 인데 Matrix를 한칸 늘려서 추가로 -1
        return Math.abs( (matrix.length - 2 * cnt - 1));
    }
}
