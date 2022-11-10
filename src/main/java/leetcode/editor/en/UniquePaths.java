package leetcode.editor.en;
//There is a robot on an m x n grid. The robot is initially located at the top-
//left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right 
//corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at 
//any point in time. 
//
// Given the two integers m and n, return the number of possible unique paths 
//that the robot can take to reach the bottom-right corner. 
//
// The test cases are generated so that the answer will be less than or equal 
//to 2 * 10⁹. 
//
// 
// Example 1: 
// 
// 
//Input: m = 3, n = 7
//Output: 28
// 
//
// Example 2: 
//
// 
//Input: m = 3, n = 2
//Output: 3
//Explanation: From the top-left corner, there are a total of 3 ways to reach 
//the bottom-right corner:
//1. Right -> Down -> Down
//2. Down -> Down -> Right
//3. Down -> Right -> Down
// 
//
// 
// Constraints: 
//
// 
// 1 <= m, n <= 100 
// 
//
// Related Topics Math Dynamic Programming Combinatorics 👍 12247 👎 356

import java.util.Arrays;

public class UniquePaths {
    public static void main(String[] args) {
        Solution solution = new UniquePaths().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // math(combination) solution which is the fastest
        public int uniquePaths(int m, int n) {
            int allStepNum = m + n - 2;
            int downStepNum = n - 1;
            long res = 1;
            for (int i = 1; i <= downStepNum; i++) {
                res = res * (allStepNum - downStepNum + i) / i;
            }
            return (int) res;
        }

        // DP solution
        public int uniquePathsDP(int m, int n) {
            int[] dp = new int[n];
            Arrays.fill(dp, 1);
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
            return dp[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}