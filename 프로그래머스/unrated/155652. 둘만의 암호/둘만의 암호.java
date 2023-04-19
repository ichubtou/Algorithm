import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        char[] answer = new char[s.length()];
        char[] skipArr = skip.toCharArray();
        List<Character> skipList = new ArrayList<>();
        for (Character c : skipArr) {
            skipList.add(c);
        }

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for(int j = 0; j < index; j++) {
                c += 1;
                if(c > 122) {
                    c -= 26;
                }
                while(skipList.contains(c)) {
                    c += 1;
                    if(c > 122) {
                        c -= 26;
                    }
                }
            }
            answer[i] = c;
        }

        return new String(answer);
    }
}