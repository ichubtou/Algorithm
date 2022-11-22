package codestates.datastructure;

public class CreateMatrix {
    public static void main(String[] args) {
        int[][] output1 = createMatrix(new int[][]{
                {0, 3, 0},
                {0, 2, 0},
                {1, 3, 0},
                {2, 1, 0},
        });

        System.out.println(output1);


        int[][] output2 = createMatrix(new int[][]{
                {0, 2, 0},
                {2, 4, 1},
                {1, 3, 1},
                {2, 1, 0},
        });

        System.out.println(output2);
        }

    public static int[][] createMatrix(int[][] edges) {
        // TODO:
        int max = 0;
        for (int i = 0; i < edges.length; i++) {
            for (int j = 0; j < edges[0].length; j++) {
                if (edges[i][j] > max) {
                    max = edges[i][j];
                }
            }
        }

        int[][] arr = new int[max + 1][max + 1];

        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] != 0 || edges[i][1] != 0) {
                if (edges[i][2] == 0) {
                    arr[edges[i][0]][edges[i][1]] = 1;
                } else {
                    arr[edges[i][0]][edges[i][1]] = 1;
                    arr[edges[i][1]][edges[i][0]] = 1;
                }
            }
        }
        return arr;
    }
}
