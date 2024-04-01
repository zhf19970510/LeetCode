package Leetcode121;

/**
 * leetcode 121
 */
public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        // 假设在i时刻必须卖出，则只需要找到前面的股票价格最小值，则是i时刻获得的最大利润，
        // 用一个变量min记录遍历过的部分的最小值
        // 每次用当前i时刻的股票价格 - 前面记录的最小值，并拿到当前利润和历史最大利润比较，即可获得最大利润
        int min = prices[0];
        int ans = 0;        // 考虑到可能价格依次递减的情况，默认初始化最大利润为0，如果两个价格相减为负数，取0
        for(int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            ans = Math.max(ans, prices[i] - min);
        }
        return ans;
    }
}
