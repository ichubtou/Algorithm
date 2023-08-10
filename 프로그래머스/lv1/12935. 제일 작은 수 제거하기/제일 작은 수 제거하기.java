import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        int min = Integer.MAX_VALUE;

        List<Integer> list = new ArrayList<>();

        for (int i : arr) {
            list.add(i);
            if(min > i) {
                min = i;
            }
        }

        list.remove(Integer.valueOf(min));

        answer = new int[list.size()];

        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        if(list.size() == 0) {
            return new int[] {-1};
        } else {
            return answer;
        }
    }
}