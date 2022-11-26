package codestates.DP;

public class Ocean {
    public static void main(String[] args) {
        long output1 = ocean(50, new int[]{10, 20, 50});
        System.out.println(output1); // 4

        long output2 = ocean(100, new int[]{10, 20, 50});
        System.out.println(output2); // 10

        long output3 = ocean(30, new int[]{5, 6, 7});
        System.out.println(output3); // 4
    }

    public static long ocean(int target, int[] type) {
        // TODO:
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for(int i = 0; i < type.length; i++) {
            for(int j = 1; j < target + 1; j++) {
                int money = j;
                int coin = type[i];
                if(money >= coin) {
                    dp[money] = dp[money] + dp[money - coin];
                }
           }
        }
        return dp[target];
    }
}
