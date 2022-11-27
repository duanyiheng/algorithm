package leetcode.editor.en;
//You are given an integer array coins representing coins of different 
//denominations and an integer amount representing a total amount of money. 
//
// Return the fewest number of coins that you need to make up that amount. If 
//that amount of money cannot be made up by any combination of the coins, return -1.
// 
//
// You may assume that you have an infinite number of each kind of coin. 
//
// 
// Example 1: 
//
// 
//Input: coins = [1,2,5], amount = 11
//Output: 3
//Explanation: 11 = 5 + 5 + 1
// 
//
// Example 2: 
//
// 
//Input: coins = [2], amount = 3
//Output: -1
// 
//
// Example 3: 
//
// 
//Input: coins = [1], amount = 0
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 2³¹ - 1 
// 0 <= amount <= 10⁴ 
// 
//
// Related Topics Array Dynamic Programming Breadth-First Search 👍 14650 👎 334
//

public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new CoinChange().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int coinChange(int[] coins, int amount) {
            if (amount == 0) {
                return 0;
            }
            int[] dp = new int[amount + 1];
            for (int coin : coins) {
                for (int j = coin; j <= amount; j++) {
                    // It means using this coin only once can make up the current target amount j, which is definitely the BEST.
                    if (j == coin) {
                        dp[j] = 1;
                        // It means there is at least one solution if this coin is used. Otherwise, there is no need to update.
                    } else if (dp[j - coin] != 0) {
                        // It means there is no solution before this coin is used.
                        if (dp[j] == 0) {
                            dp[j] = dp[j - coin] + 1;
                        } else {
                            // It compares the two ways of either using this coin(dp[j - coin] + 1) or not(dp[j]).
                            dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                        }
                    }
                }
            }
            return dp[amount] == 0 ? -1 : dp[amount];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}