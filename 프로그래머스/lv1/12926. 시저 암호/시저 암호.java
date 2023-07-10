class Solution {
    public String solution(String s, int n) {
        String answer = "";

        for(int i = 0; i < s.length(); i++) {
            char c = (char) (s.charAt(i) + n);
            if (s.charAt(i) == ' ') {
                c -= n;
            } else if(c > 122) {
                c -= 26;
            } else if(c > 90 && s.charAt(i) < 91) {
                c -= 26;
            }
            answer += c;
        }

        return answer;
    }
}