class Solution {
    public int solution(int[][] sizes) {
        int x = 0;
        int y = 0;

        for (int[] size : sizes) {
            if (size[1] > size[0]) {
                if(x < size[1]) {
                    x = size[1];
                }
                if(y < size[0]) {
                    y = size[0];
                }
            } else {
                if(x < size[0]) {
                    x = size[0];
                }
                if(y < size[1]) {
                    y = size[1];
                }
            }
        }

        return x * y;
    }
}