package leetcode.editor.en;
//You are given an array prices where prices[i] is the price of a given stock 
//on the iᵗʰ day. 
//
// Find the maximum profit you can achieve. You may complete as many 
//transactions as you like (i.e., buy one and sell one share of the stock multiple times) 
//with the following restrictions: 
//
// 
// After you sell your stock, you cannot buy stock on the next day (i.e., 
//cooldown one day). 
// 
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you 
//must sell the stock before you buy again). 
//
// 
// Example 1: 
//
// 
//Input: prices = [1,2,3,0,2]
//Output: 3
//Explanation: transactions = [buy, sell, cooldown, buy, sell]
// 
//
// Example 2: 
//
// 
//Input: prices = [1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= prices.length <= 5000 
// 0 <= prices[i] <= 1000 
// 
//
// Related Topics Array Dynamic Programming 👍 6945 👎 236

public class BestTimeToBuyAndSellStockWithCooldown {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockWithCooldown().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfitOriginal(int[] prices) {
            int len = prices.length;
            // s1: hold stock, can sell(jump to s2) or do nothing (stay in s1)
            int[] s1 = new int[len];
            // s2: just sold stock, can rest only(jump to s3)
            int[] s2 = new int[len];
            // s3: sold stock for at least one day, can do nothing or buy stock
            int[] s3 = new int[len];
            s1[0] = -prices[0];
            s2[0] = 0;
            s3[0] = 0;
            for (int i = 1; i < len; i++) {
                s1[i] = Math.max(s1[i - 1], s3[i - 1] - prices[i]);
                s2[i] = s1[i - 1] + prices[i];
                s3[i] = Math.max(s3[i - 1], s2[i - 1]);
            }
            return Math.max(s2[len - 1], s3[len - 1]);
        }

        // this works with less space.
        public int maxProfit(int[] prices) {
            int len = prices.length;
            // s1: hold stock, can sell(jump to s2) or do nothing (stay in s1)
            int s1 = -prices[0];
            // s2: just sold stock, can rest only(jump to s3)
            int s2 = 0;
            // s3: sold stock for at least one day, can do nothing or buy stock
            int s3 = 0;
            for (int i = 1; i < len; i++) {
                int lastS2 = s2;
                s2 = s1 + prices[i];
                s1 = Math.max(s1, s3 - prices[i]);
                s3 = Math.max(s3, lastS2);
            }
            return Math.max(s2, s3);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}