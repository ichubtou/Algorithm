import java.util.*;

class Solution {
    public int[] solution(String s) {
         int[] answer = new int[s.length()];
        
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.substring(i, i + 1))) {
                answer[i] = i - map.get(s.substring(i, i + 1));
            } else {
                answer[i] = -1;
            }

            map.put(s.substring(i, i + 1), i);
        }
        
        return answer;
    }
}