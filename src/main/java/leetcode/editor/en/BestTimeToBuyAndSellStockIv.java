package leetcode.editor.en;
//You are given an integer array prices where prices[i] is the price of a given 
//stock on the iᵗʰ day, and an integer k. 
//
// Find the maximum profit you can achieve. You may complete at most k 
//transactions. 
//
// Note: You may not engage in multiple transactions simultaneously (i.e., you 
//must sell the stock before you buy again). 
//
// 
// Example 1: 
//
// 
//Input: k = 2, prices = [2,4,1]
//Output: 2
//Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 
//4-2 = 2.
// 
//
// Example 2: 
//
// 
//Input: k = 2, prices = [3,2,6,5,0,3]
//Output: 7
//Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 
//6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3
//-0 = 3.
// 
//
// 
// Constraints: 
//
// 
// 1 <= k <= 100 
// 1 <= prices.length <= 1000 
// 0 <= prices[i] <= 1000 
// 
//
// Related Topics Array Dynamic Programming 👍 5890 👎 191

public class BestTimeToBuyAndSellStockIv {
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIv().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int k, int[] prices) {
            int n = prices.length;
            if (k >= n / 2) {
                // As long as there is a price gap, we gain a profit.
                int maxProfit = 0;
                for (int i = 1; i < n; i++) {
                    int diff = prices[i] - prices[i - 1];
                    if (diff > 0) {
                        maxProfit += diff;
                    }
                }
                return maxProfit;
            }
            //maxProfit[i][j] represents the max profit up until prices[j] using at most i transactions.
            int[][] maxProfit = new int[k + 1][n];
            for (int i = 1; i <= k; i++) {
                int tmpMax = -prices[0]; // maxProfit[i-1][0] equals 0 always
                for (int j = 1; j < n; j++) {
                    maxProfit[i][j] = Math.max(maxProfit[i][j - 1], tmpMax + prices[j]);
                    tmpMax = Math.max(tmpMax, maxProfit[i - 1][j] - prices[j]);
                }
            }
            return maxProfit[k][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}