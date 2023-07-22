class Solution {
    public int solution(long num) {
        int answer = 0;

        while (true) {
            if(answer >= 500) {
                break;
            }
            else if(num == 1) {
                break;
            }
            else if (num % 2 == 0) {
                num /= 2;
                answer++;
            } else {
                num = num * 3 + 1;
                answer++;
            }

        }

        return answer == 500 ? -1 : answer;
    }
}