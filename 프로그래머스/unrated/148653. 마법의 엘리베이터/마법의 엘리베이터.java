class Solution {
    public int solution(int storey) {
        int sum = 0;

        String str = Integer.toString(storey);

        while(str.length() != 0) {
            if(str.charAt(str.length() - 1) == '5') {
                if(str.length() > 1 && str.charAt(str.length() - 2) > '4') {
                    sum += 10 - str.charAt(str.length() - 1) + '0';
                    str = Integer.toString(Integer.parseInt(str) + 10);
                } else {
                    sum += 5;
                }
            } else if(str.charAt(str.length() - 1) > '5') {
                sum += 10 - str.charAt(str.length() - 1) + '0';
                str = Integer.toString(Integer.parseInt(str) + 10);
            } else if(str.charAt(str.length() - 1) < '5') {
                sum += str.charAt(str.length() - 1) - '0';
            }

            str = str.substring(0, str.length() - 1);
        }

        return sum;
    }
}