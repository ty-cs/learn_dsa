package fmt.DynamicProgramming;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 * <p>
 * Note that you cannot sell a stock before you buy one.
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4] Output: 5 Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price. Example 2:
 * <p>
 * Input: [7,6,4,3,1] Output: 0 Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimetoBuyandSellStock {
    //Time complexity : O(n^2)
    //Space complexity : O(1). Only two variables - maxprofit and profit are used.
    public int maxProfit(int prices[]) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
    }



    public int maxProfitDP(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[] dp = new int[prices.length]; // max profit up to ith day
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
        }

        return dp[prices.length - 1];
    }
    // 降维...
    // T: O(N)  S: O(1)
    public int maxProfitII(int prices[]) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    // reduce to maximum subarray
    private int maxSubArray4(int[] nums) {
        int max = nums[0];
        int dp = 0;
        for (int num : nums) {
            dp = Math.max(num, dp + num);
            max = Math.max(max, dp);
        }
        return max;
    }

    public int maxProfit2(int[] nums) {
        int[] gains = new int[nums.length - 1];
        for (int i = 0; i < nums.length -1; i++) {
            gains[i] = nums[i + 1] - nums[i];
        }
        return Math.max(maxSubArray4(gains), 0);
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        BestTimetoBuyandSellStock bs = new BestTimetoBuyandSellStock();
        System.out.println(bs.maxProfitDP(prices));
        System.out.println(bs.maxProfit2(prices));
    }
}
