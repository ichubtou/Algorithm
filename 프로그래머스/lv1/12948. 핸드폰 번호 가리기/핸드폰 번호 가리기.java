class Solution {
    public String solution(String phone_number) {
        String answer = "";

        int len = phone_number.length();
        StringBuilder str = new StringBuilder(phone_number);

        for(int i = 0; i < len - 4; i++) {
            str.setCharAt(i, '*');
        }

        return str.toString();
    }
}