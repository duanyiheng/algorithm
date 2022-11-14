package leetcode.editor.en;
//Given an integer n, break it into the sum of k positive integers, where k >= 2
//, and maximize the product of those integers. 
//
// Return the maximum product you can get. 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: 1
//Explanation: 2 = 1 + 1, 1 × 1 = 1.
// 
//
// Example 2: 
//
// 
//Input: n = 10
//Output: 36
//Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
// 
//
// 
// Constraints: 
//
// 
// 2 <= n <= 58 
// 
//
// Related Topics Math Dynamic Programming 👍 3323 👎 347

public class IntegerBreak {
    public static void main(String[] args) {
        Solution solution = new IntegerBreak().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // dp[i] means the result when input is i.
        public int integerBreak(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                //let's say i = 8, we are trying to fill dp[8]:if 8 can only be broken into 2 parts, the answer
                // could be among 1 * 7, 2 * 6, 3 * 5, 4 * 4... but these numbers can be further broken.
                // so we have to compare 1 with dp[1], 7 with dp[7], 2 with dp[2], 6 with dp[6]...etc
                for (int j = 1; j <= i / 2; j++) {
                    dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}