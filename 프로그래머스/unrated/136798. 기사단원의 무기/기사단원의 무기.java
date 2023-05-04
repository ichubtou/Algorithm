class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;

        for(int i = 1; i <= number; i++) {
            int divisor = divisor(i);
            if(divisor > limit) {
                answer += power;
            } else {
                answer += divisor;
            }
        }

        return answer;
    }

    public int divisor(int n) {
        int result = 0;
        for(int i = 1; i * i <= n; i++) {
            if(i * i == n) {
                result++;
            } else if (n % i == 0) {
                result += 2;
            }
        }

        return result;
    }
}