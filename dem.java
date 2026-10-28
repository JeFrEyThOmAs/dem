public int coinChange3(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = -1;
            }
        }

        int ans = helper(n - 1, amount, coins, dp);
        if (ans >= (int)1e9) return -1;
        return ans;
    }

    private int helper(int i, int amount, int[] coins, int[][] dp) {
        if (i == 0) {
            if (amount % coins[0] == 0) return amount / coins[0];
            else return (int)1e9;
        }
        if (dp[i][amount] != -1) return dp[i][amount];
        int notTake = helper(i - 1, amount, coins, dp);
        int take = (int)1e9;

        if (coins[i] <= amount) {
            take = 1 + helper(i, amount - coins[i], coins, dp);
        }

        return dp[i][amount] = Math.min(take, notTake);
    }


// This is my first feature branch change.