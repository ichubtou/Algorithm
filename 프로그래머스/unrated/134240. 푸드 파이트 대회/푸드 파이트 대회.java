import java.util.*;

class Solution {
    public String solution(int[] food) {
         StringBuilder answer = new StringBuilder();

        List<String> temp = new ArrayList<>();

        for(int i = 1; i < food.length; i++) {
            for(int j = 0; j < food[i] / 2; j++) {
                temp.add(String.valueOf(i));
            }
        }

        temp.add("0");

        for(int i = temp.size() - 2; i > -1; i--) {
            temp.add(temp.get(i));
        }

        temp.forEach(str -> answer.append(str));

        return answer.toString();
    }
}