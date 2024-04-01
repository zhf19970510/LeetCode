package Leetcode188;

/**
 * leetcode 188
 */
public class BestTimeToBuyAndSellStockIII {

    public static int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k < 1) {
            return 0;
        }

        int N = prices.length;
        if (k >= N / 2) {
            return allTrans(prices);
        }

        // 这个dp数组表示在不超过 k 次交易的情况下，在0 - N的范围内进行买入和卖出股票操作获取的最大利润
        int[][] dp = new int[N][k + 1];
        // dp[...][0] = 0
        // dp [0][...] = arr[0,0] = 0
        for (int j = 1; j <= k; j++) {
            // dp[1][j] ???
            // dp[1][j] 准备好一些枚举，接下来准备好的枚举
            for (int i = 2; i < N; i++) {

            }
        }

        return 0;
    }

    public static int allTrans(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }

}
