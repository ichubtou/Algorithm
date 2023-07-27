class Solution {
    public int solution(String s) {
        int answer = 0;
        int temp = 0;
        char c = ' ';

        for(int i = 0; i < s.length(); i++) {
             if(s.charAt(i) == c) {
                temp++;
            } else if(temp == 0) {
                c = s.charAt(i);
                temp++;
            } else {
                temp--;
            }

            if(temp == 0 || (i == s.length() - 1)) {
                answer++;
                c = ' ';
            }
        }

        return answer;
    }
}