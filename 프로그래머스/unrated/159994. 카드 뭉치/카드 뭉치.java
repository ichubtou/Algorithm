import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";

        List<String> cards1List = new ArrayList<>(Arrays.asList(cards1));
        List<String> cards2List = new ArrayList<>(Arrays.asList(cards2));

        for (int i = 0; i < goal.length; i++) {
            if(cards1List.size() > 0 && goal[i].equals(cards1List.get(0))) {
                cards1List.remove(0);
            } else if (cards2List.size() > 0 && goal[i].equals(cards2List.get(0))) {
                cards2List.remove(0);
            } else {
                answer = "No";
                break;
            }
        }

        return answer;
    }
}