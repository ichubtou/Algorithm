import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int n = 0;

        Map<String, Integer> map = new HashMap<>();

        for (String s : keymap) {
            for (int i = s.length() - 1; i > -1; i--) {
                if(!(map.containsKey(s.substring(i, i + 1)) && map.get(s.substring(i, i + 1)) < i + 1)) {
                    map.put(s.substring(i, i + 1), i + 1);
                }
            }
        }

        boolean check = true;

        for (String target : targets) {
            int sum = 0;
            for (int i = 0; i < target.length(); i++) {
                if(map.containsKey(target.substring(i, i + 1))) {
                    sum += map.get(target.substring(i, i + 1));
                } else {
                    sum = -1;
                    check = false;
                }
            }
            if(check == true) {
                answer[n] = sum;
            } else {
                answer[n] = -1;
            }
            n++;
            check = true;
        }

            return answer;
    }
}