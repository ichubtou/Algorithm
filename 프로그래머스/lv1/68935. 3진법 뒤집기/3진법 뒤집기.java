class Solution {
    public int solution(int n) {
        String s = Integer.toString(n, 3);
        String reverse = "";

        for(int i = s.length(); i > 0; i--) {
            reverse += s.substring(i - 1, i);
        }

        int i = Integer.parseInt(reverse, 3);

        return i;
    }
}