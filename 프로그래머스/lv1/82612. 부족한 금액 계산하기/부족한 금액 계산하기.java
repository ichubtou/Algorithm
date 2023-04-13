class Solution {
    public long solution(int price, int money, int count) {
        long temp = 0;
        
        for(int i = 1; i < count + 1; i++) {
            temp += price * i;
        }
        
        return temp - money > 0 ? temp - money : 0;
    }
}