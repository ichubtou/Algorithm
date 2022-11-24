package codestates.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GetDirections {
    public static void main(String[] args) {
        boolean result = getDirections(new int[][]
                        {
                                {0, 1, 0, 0},
                                {0, 0, 1, 0},
                                {0, 0, 0, 1},
                                {0, 1, 0, 0}
                        },
                0,
                2
        );
        System.out.println(result); // true
// 정점 0에서 2로 가는 길이 존재하는지 확인합니다.
// 0 --> 1 로 가는 간선이 존재하고, 1 --> 2 로 가는 간선이 존재하기 때문에 true를 반환합니다.

        boolean result2 = getDirections(new int[][]
                        {
                                {0, 1, 0, 0, 0},
                                {0, 0, 0, 1, 0},
                                {0, 1, 0, 0, 0},
                                {0, 1, 1, 0, 0},
                                {1, 1, 1, 1, 0}
                        },
                1,
                4
        );
        System.out.println(result2); // false
    }

    public static boolean getDirections(int[][] matrix, int from, int to) {
        // TODO:
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> al = new ArrayList<>();
        queue.add(from);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            al.add(current);

            if (current == to) {
                return true;
            }

            for (int i = 0; i < matrix.length; i++) {
                if (!al.contains(i)) {
                    if (matrix[current][i] == 1) {
                        queue.add(i);
                    }
                }
            }
        }

        return false;
    }
}