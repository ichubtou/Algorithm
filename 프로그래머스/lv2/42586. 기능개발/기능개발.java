import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();


        for(int i = 0; i < progresses.length; i++) {
            queue.add((int) Math.ceil((double) (100 - progresses[i]) / (double) speeds[i]));
        }

        while(!queue.isEmpty()) {
            int cnt = 0;
            int current = queue.poll();
            cnt++;

                while (!queue.isEmpty() && current >= queue.peek()) {
                    cnt++;
                    queue.poll();
                }

            list.add(cnt);
        }

        answer = list.stream().mapToInt(i -> i).toArray();

        return answer;
    }
}