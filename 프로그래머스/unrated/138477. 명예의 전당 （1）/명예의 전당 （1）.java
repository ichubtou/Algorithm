import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < score.length; i++) {
            if(list.size() < k) {
                list.add(score[i]);
                if(score[i] < min) {
                    min = score[i];
                }
            } else {
                if(score[i] > min) {
                    list.remove(Integer.valueOf(min));

                    list.add(score[i]);
                    min = Collections.min(list);
                }
            }
            answer[i] = min;
        }

        return answer;
    }
}