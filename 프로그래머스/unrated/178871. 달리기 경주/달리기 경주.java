import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> playerMap = new HashMap<>();
        int i = 0;
        for (String player : players) {
            playerMap.put(player, i);
            i++;
        }

        for (String calling : callings) {
            Integer integer = playerMap.get(calling);

            playerMap.put(calling, integer - 1);
            playerMap.put(players[integer - 1], integer);

            String temp = players[integer];
            players[integer] = players[integer - 1];
            players[integer - 1] = temp;
        }
        
        return players;
    }
}