import java.util.*;
import java.util.stream.Collectors;

class Solution {
   public String[] solution(int[][] line) {
        String[] answer = {};
        int x = 0, y = 0;
        int minX = Integer.MIN_VALUE;
        int minY = Integer.MIN_VALUE;
        int maxX = Integer.MAX_VALUE;
        int maxY = Integer.MAX_VALUE;
       
        ArrayList<Integer> xPoints = new ArrayList<>();
        ArrayList<Integer> yPoints = new ArrayList<>();
       
        StringBuilder stringBuilder = new StringBuilder();
        int a = 0;

        for(int i = 0; i < line.length - 1; i++) {
            for(int j = 1; j < line.length; j++) {
                if(i != j) {
                    long deno = ((long)line[i][0] * (long)line[j][1] - (long)line[i][1] * (long)line[j][0]);
                    long moleX = ((long)line[i][1] * (long)line[j][2] - (long)line[i][2] * (long)line[j][1]);
                    long moleY = ((long)line[i][2] * (long)line[j][0] - (long)line[i][0] * (long)line[j][2]);
                    if(deno == 0) {
                        continue;
                    }
                    x = ((int)moleX / (int)deno);
                    y = ((int)moleY / (int)deno);
                    if((moleX % deno) != 0.0) {
                        continue;
                    } else if((moleY % deno) != 0) {
                        continue;
                    }
                    xPoints.add(x);
                    yPoints.add(y);
                }
            }
        }

        minX = Collections.min(xPoints);
        minY = Collections.min(yPoints);
        maxX = Collections.max(xPoints);
        maxY = Collections.max(yPoints);

        String[][] point = new String[maxY - minY + 1][maxX - minX + 1];

        for(String temp[] : point) {
            Arrays.fill(temp, ".");
        }

        for(int i = 0; i < xPoints.size(); i++) {
            point[yPoints.get(i) - minY][xPoints.get(i) - minX] = "*";
        }

        answer = new String[maxY - minY + 1];

        for (String[] strings : point) {
            answer[a] = Arrays
                    .stream(strings) 
                    .collect(Collectors.joining());
            a++;
        }

        String[] temp = new String[answer.length];
        for (int i = 0; i < answer.length; i++) {
            temp[answer.length - 1 - i] = answer[i];
        }

        answer = temp;

        return answer;
    }
}